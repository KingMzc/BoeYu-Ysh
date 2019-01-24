<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>孩子管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<form class="layui-form">
			<div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" id="name" value="" placeholder="姓名"
							class="layui-input search_input">
					</div>
					<div class="layui-input-inline layui-form">
						<select name="sex" class="" id="sex">
							<option value="-1">请选择性别</option>
							<option value="1">男</option>
							<option value="0">女</option>
							<%--<option value="2">保密</option>--%>
						</select>
					</div>
					<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cx"
					   lay-filter="search">查询</a>
					<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cz"
					   lay-filter="search">重置</a>
				</div>
			</div>
			<div style="margin-top: 1%">
				<%--<div class="layui-inline">
					<input type="text" id="createTimeStart"
						class="layui-input userName" name="createTimeStart"
						placeholder="注册时间(开始)" value="">
				</div>
				<div class="layui-inline">
					<input type="text" id="createTimeEnd" class="layui-input userName"
						name="createTimeEnd" placeholder="注册时间(结束)" value="">
				</div>--%>

			</div>
		</form>
	</blockquote>

	<div class="layui-form">
		<table id="userList" lay-filter="userList"></table>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/html" id="barEdit">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	</script>
	<script type="text/html" id="sexTpl">
 		 {{#  if(d.sex === '0'){ }}
   		 <span style="color: #F581B1;">女</span>
  		{{#  } else if(d.sex === '1'){ }}
   		 	男
		{{#  } else{ }}
   		 	未设置
  		{{#  } }}
	</script>
	<script type="text/html" id="gradeTpl">
 		 {{#  if(d.grade === '0'){ }}
   		 一年级
  		{{#  } else if(d.grade === '1'){ }}
		 二年级
		 {{#  } else if(d.grade === '2'){ }}
		 三年级
		 {{#  } else if(d.grade === '3'){ }}
		 四年级
		 {{#  } else if(d.grade === '4'){ }}
		 五年级
		 {{#  } else if(d.grade === '5'){ }}
		 六年级
		 {{#  } else if(d.grade === '6'){ }}
		 七年级
		 {{#  } else if(d.grade === '7'){ }}
		 一年级
		 {{#  } else if(d.grade === '8'){ }}
		 八年级
		 {{#  } else if(d.grade === '9'){ }}
		 九年级
		 {{#  } else if(d.grade === '10'){ }}
		 高一年级
		 {{#  } else if(d.grade === '11'){ }}
		 高二年级
		 {{#  } else if(d.grade === '12'){ }}
		 高三年级
		{{#  } else{ }}
   		 未设置
  		{{#  } }}
	</script>

	<script type="text/html" id="safeType">
		{{#  if(d.safeType === '0'){ }}
		白名单
		{{#  } else if(d.safeType === '1'){ }}
        黑名单
		{{#  } else{ }}
        未设置
		{{#  } }}
	</script>

	<script type="text/html" id="childType">
		{{#  if(d.childType === '0'){ }}
		未锁定屏幕
		{{#  } else if(d.childType === '1'){ }}
		锁定屏幕
		{{#  } else{ }}
		未设置
		{{#  } }}
	</script>
	<script>
		layui
				.config({
					base : "js/"
				})
				.use(
						[ 'form', 'layer', 'jquery', 'table', 'laydate' ],
						function() {
							var form = layui.form, table = layui.table, layer = parent.layer === undefined ? layui.layer
									: parent.layer, laydate = layui.laydate
									$ = layui.jquery,
									nowTime = new Date().valueOf(),
									max = null,
									active = {
										search : function() {
											var name = $('#name'), sex = $('#sex option:selected');
											//执行重载
											table
													.reload(
															'userList',
															{
																page : {
																	curr : 1
																//重新从第 1 页开始
																},
																where : {
																	//key: {
																	name : name
																			.val(),
																	sex : sex
																			.val()
																//}
																}
															});
										}
									};

							var start = laydate.render({
								elem : '#createTimeStart',
								type : 'datetime',
								max : nowTime,
								btns : [ 'clear', 'confirm' ],
								done : function(value, date) {
									endMax = end.config.max;
									end.config.min = date;
									end.config.min.month = date.month - 1;
								}
							});
							var end = laydate.render({
								elem : '#createTimeEnd',
								type : 'datetime',
								max : nowTime,
								done : function(value, date) {
									if ($.trim(value) == '') {
										var curDate = new Date();
										date = {
											'date' : curDate.getDate(),
											'month' : curDate.getMonth() + 1,
											'year' : curDate.getFullYear()
										};
									}
									start.config.max = date;
									start.config.max.month = date.month - 1;
								}
							})

							//加载页面数据
							table
									.render({
										id : 'userList',
										elem : '#userList',
										url : ctx + '/child/getchildList' //数据接口
										,
										limit : 10//每页默认数
										,
										limits : [ 10, 20, 30, 40 ],
										cols : [ [ //表头
												{
													field : 'id',
													title : 'ID',
													width : '4%'
												},

												{
													field : 'name',
													title : '姓名'
												},
												{
													field : 'sex',
													title : '性别',
													templet : '#sexTpl',
												},
												{
													field : 'grade',
													title : '年级',
                                                    templet : '#gradeTpl'
												},
												{
													field : 'safeType',
													title : '安全模式',
													templet : '#safeType',
												},
												{
													field : 'childType',
													title : '孩子状态',
													templet : '#childType',
												},
												{
													field : 'years',
													title : '生日',
													templet : '<div>{{ formatTime(d.years,"yyyy-MM-dd")}}</div>'
												},

												{
													field : 'createTime',
													title : '注册日期',
													templet : '<div>{{ formatTime(d.createTime,"yyyy-MM-dd hh:mm:ss")}}</div>'
												},
                                            {
                                                field : 'fkCustomerId',
                                                title : '家长电话'
                                            }/*,
											{
													title : '操作',
													toolbar : '#barEdit'
												} */] ],
										page : true
										,where: {timestamp: (new Date()).valueOf()}
									//开启分页
									});

							//监听工具条
							table.on('tool(userList)', function(obj) {
								var data = obj.data;
								if (obj.event === 'del') {
									layer.confirm('真的删除行么', function(index) {
										$.ajax({
											url : ctx + '/user/delUserByUid/'
													+ data.uid,
											type : "get",
											success : function(d) {
												if (d.code == 0) {
													obj.del();
												} else {
													layer.msg("权限不足！", {
														icon : 5
													});
												}
											}
										})
										layer.close(index);
									});
								} else if (obj.event === 'edit') {
									layer.open({
										type : 2,
										title : "编辑用户",
										area : [ '400px', '500px' ],
										content : ctx + "/user/editCustomer/"
												+ data.id //这里content是一个普通的String
									})
								}

							});

                            //查询
                            $("#cx").click(function() {
                                var type = $(this).data('type');
                                active[type] ? active[type].call(this) : '';
                            })
                            //重置
                            $("#cz").click(function() {
                                $('#name').val("");
                                $("#sex").val("-1");
                                var form = layui.form;
                                form.render('select');
                            })

							//添加文章
							$(".userAdd_btn").click(function() {
								var index = layui.layer.open({
									title : "添加文章",
									type : 2,
									content : ctx + "/user/addUser",
									success : function(layero, index) {

									}
								})
								//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
								$(window).resize(function() {
									layui.layer.full(index);
								})
								layui.layer.full(index);
							})

							//批量删除
							$(".batchDel")
									.click(
											function() {
												var checkStatus = table
														.checkStatus('userList'), data = checkStatus.data, userStr = '';
												if (data.length > 0) {
													$.each(data, function(n,
															value) {
														userStr += value.uid
																+ ',';
													});
													userStr = userStr
															.substring(
																	0,
																	userStr.length - 1);
													layer
															.confirm(
																	'确定删除<strong>'
																			+ data.length
																			+ '</strong>条数据吗？',
																	function(
																			index) {
																		//调用删除接口
																		$
																				.ajax({
																					url : ctx
																							+ '/user/delUsers/'
																							+ userStr,//接口地址
																					type : "get",
																					success : function(
																							d) {
																						if (d.code == 0) {
																							//删除成功，刷新父页面
																							parent.location
																									.reload();
																						} else {
																							layer
																									.msg(
																											"权限不足，联系超管！",
																											{
																												icon : 5
																											});
																						}
																					}
																				})
																	});
												} else {
													layer.msg("请选择需要删除的用户");
												}
											})

						})

		//格式化时间
		function formatTime(datetime, fmt) {
			if (datetime == null || datetime == 0) {
				return "";
			}
			if (parseInt(datetime) == datetime) {
				if (datetime.length == 10) {
					datetime = parseInt(datetime) * 1000;
				} else if (datetime.length == 13) {
					datetime = parseInt(datetime);
				}
			}
			datetime = new Date(datetime);
			var o = {
				"M+" : datetime.getMonth() + 1, //月份   
				"d+" : datetime.getDate(), //日   
				"h+" : datetime.getHours(), //小时   
				"m+" : datetime.getMinutes(), //分   
				"s+" : datetime.getSeconds(), //秒   
				"q+" : Math.floor((datetime.getMonth() + 3) / 3), //季度   
				"S" : datetime.getMilliseconds()
			//毫秒   
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		}
	</script>
</body>
</html>