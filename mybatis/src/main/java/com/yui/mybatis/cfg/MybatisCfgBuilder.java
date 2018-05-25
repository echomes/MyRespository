package com.yui.mybatis.cfg;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 获取sqlsessionFactory
 * 
 * @author Echo
 *
 */
public class MybatisCfgBuilder {

	private static String source = "mybatis.cfg.xml";

	private MybatisCfgBuilder() {

	}

	public static SqlSessionFactory sqlSessionFactory() {

		try {
			InputStream in = Resources.getResourceAsStream(source);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			return sqlSessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
