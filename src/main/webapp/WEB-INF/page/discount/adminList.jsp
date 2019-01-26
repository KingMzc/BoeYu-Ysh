<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>充值优惠</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<input type="hidden" id="adminId"
		value="<shiro:principal property="id"/>" />
	<blockquote class="layui-elem-quote list_search">
		<form class="layui-form">
			<div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="number" id="csize" value="" placeholder="生成条数(最多100条)"
							   class="layui-input search_input">
					</div>
					<div class="layui-input-inline layui-form">
						<select name="distype" class="sex" id="distype">
							<option value="-1">请选择充值卡</option>
							<option value="0">月卡</option>
							<option value="1">季卡</option>
							<option value="2">年卡</option>
						</select>
					</div>
					<div class="layui-inline">
						<input type="text" id="endtime"
							   class="layui-input userName" name="endtime"
							   placeholder="充值卡有效期" value="">
					</div>

					<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cx"
					   lay-filter="search">生成充值卡</a>
				</div>
			</div>
		</form>
	</blockquote>
	<!-- 数据表格 -->
	<table id="adminList" lay-filter="adminList"></table>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/discount/adminList.js"></script>
	<script type="text/html" id="barEdit">
	<shiro:hasPermission name="sys:admin:update">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">审核</a>
	</shiro:hasPermission>
	<%--<shiro:hasPermission name="sys:admin:delete">
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</shiro:hasPermission>--%>
	</script>
	<script type="text/html" id="typeTpl">
 		 {{#  if(d.type === '0'){ }}
   		 充值卡
		{{#  } else{ }}
		 打折卡
  		{{#  } }}
	</script>
	<script type="text/html" id="distypeTpl">
		{{#  if(d.distype === '0'){ }}
		月卡
		{{#  } else if(d.distype === '1'){ }}
		季卡
		{{#  } else{ }}
		年卡
		{{#  } }}
	</script>
	<script type="text/html" id="exportTpl">
		{{#  if(d.export === '0'){ }}
		未导出
		{{#  } else if(d.export === '1'){ }}
		已导出
		{{#  } else{ }}
		已导出
		{{#  } }}
	</script>
</body>
</html>