<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta name="decorator" content="default"/>
	<title>MyBatis</title>
	<script type="text/javascript">
		$(function(){
			showTable();
		})
		
		function showTable(){
			$("#table").bootstrapTable({ // 对应table标签的id
			      url: "${ctx}/test/getData", // 获取表格数据的url
			      method : "post",
			      contentType : "application/x-www-form-urlencoded",
			      cache : false,
				  striped : true,
			      pagination: true, // 在表格底部显示分页组件，默认false
			      paginationPreText : "上一页",
				  paginationNextText : "下一页",
				  pageSize : 10, //每页的记录行数（*）
				  pageList : [ 10, 50, 100, 200 ], //可供选择的每页的行数（*）
				  queryParamsType: "limit",	
				  clickToSelect: true,
				  search: true,           
				  searchOnEnterKey: true,
				  showRefresh: true,
				  showToggle: true,
				  //detailView: true,
				  uniqueId : "id",
				  sidePagination: 'server', // 设置为服务器端分页
			      queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
			          return {
			        	  offset: params.offset, // 每页显示数据的开始行号
			        	  limit: params.limit, // 每页要显示的数据条数
			              sort: params.sort, // 要排序的字段
			              sortOrder: params.order // 排序规则
			          }
			      },
			      sortName: 'id', // 要排序的字段
			      sortOrder: 'desc', // 排序规则
			      columns: [
			          {
			              checkbox: true, // 显示一个勾选框
			              align: 'center' // 居中显示
			          }, {
			              field: 'id', // 返回json数据中的name
			              title: '编号', // 表格表头显示文字
			              align: 'center', // 左右居中
			              valign: 'middle' // 上下居中
			          }, {
			              field: 'name',
			              title: '名称',
			              align: 'center',
			              valign: 'middle'
			          }, {
			              field: 'birth',
			              title: '计算方式',
			              align: 'center',
			              valign: 'middle'
			          }, {
			              title: "操作",
			              align: 'center',
			              valign: 'middle',
			              width: 160, // 定义列的宽度，单位为像素px
			              formatter: function (value, row, index) {
			                  return '<button class="btn btn-primary btn-sm" onclick="del(\'' + row.id + '\')">删除</button>';
			              }
			          }
			      ],
			      onLoadSuccess: function(){  //加载成功时执行
			            console.info("加载成功");
			            console.info(ctx);
			      },
			      onLoadError: function(){  //加载失败时执行
			            console.info("加载数据失败");
			      }
		
			})
		}
	</script>
</head>
<body>
	<div style="width: 80%;margin: 0 auto">
		<table id="table" ></table>
	</div>
</body>
</html>