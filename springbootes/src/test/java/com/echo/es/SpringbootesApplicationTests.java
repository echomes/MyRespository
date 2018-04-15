package com.echo.es;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.echo.es.dao.UserDao;
import com.echo.es.projo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootesApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TransportClient client;

	@Test
	public void contextLoads() {

	}

	@Test
	public void add() {
		User u = new User();
		u.setAge(22);
		u.setName("测试");
		u.setBirth(new Date());
		u.setDesc("test");
		u.setId(6l);

		userDao.save(u);
	}

	@Test
	public void query() {
		// Iterable<User> all = userDao.findAll();
		// for (User user : all) {
		// System.out.println(user);
		// }
		QueryBuilder query = QueryBuilders.boolQuery().
				must(QueryBuilders.termQuery("name", "测试"))
				.must(QueryBuilders.rangeQuery("age").from("10").to("30"));

		Iterable<User> iterable = userDao.search(query);
		System.out.println(query);
		for (User user : iterable) {
			System.out.println(user);
		}
	}
	
	@Test
	public void agg() {
		QueryBuilder qr = QueryBuilders.rangeQuery("price").from("10").to("40");
		
		AggregationBuilder agg = AggregationBuilders.terms("agg_name").field("name").
				subAggregation(AggregationBuilders.avg("avg_price").field("price"));
		
		SearchResponse response = client.prepareSearch("books").
				setTypes("book").setQuery(qr).
				addAggregation(agg).setSize(0).
				execute().actionGet();
		
		System.out.println(response.toString());;
		SearchHits searchHits = response.getHits();
		Map<String, Aggregation> asList = response.getAggregations().asMap();
		
		for (Map.Entry<String, Aggregation> entity : asList.entrySet()) {
			Terms terms = (Terms) entity.getValue();
			List<? extends Bucket> list = terms.getBuckets();
			
			for (Bucket b : list) {
				System.out.println(b.getKey());
			}
		}
		
		for (SearchHit sh : searchHits) {
			//System.out.println("id:"+sh.getId()+"索引:"+sh.getIndex()+"Type:"+sh.getType());
			System.out.println(sh.getSourceAsString());
		}
		client.close();
		
	}

}
