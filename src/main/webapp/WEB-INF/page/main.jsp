<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx}/css/main.css" media="all" />
<script type="text/javascript" src="${ctx}/js/echarts.js"></script>
<script>
	
<%--JS gloable varilible--%>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody" style="margin: 1%">
	<fieldset class="layui-elem-field layui-field-title">
		<legend>信息统计</legend>
	</fieldset>
	<div>
		<table class="layui-table">

			<thead>
				<tr>
					<th><strong>统计</strong></th>
					<th><strong>家长</strong></th>
					<th><strong>统计</strong></th>
					<th><strong>合伙人</strong></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>总数</td>
					<td class="userTotal"></td>
					<td>总数</td>
					<td class="parTotal"></td>
				</tr>
				<tr>
					<td>今日</td>
					<td class="usersToday"></td>
					<td>今日</td>
					<td class="parToday"></td>
				</tr>
				<tr>
					<td>昨日</td>
					<td class="usersYestoday"></td>
					<td>昨日</td>
					<td class="parYestoday"></td>
				</tr>
				<tr>
					<td>本周</td>
					<td class="usersYearWeek"></td>
					<td>本周</td>
					<td class="parYearWeek"></td>
				</tr>
				<tr>
					<td>本月</td>
					<td class="usersMonth"></td>
					<td>本月</td>
					<td class="parMonth"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<fieldset class="layui-elem-field layui-field-title">
		<legend>家长性别占比</legend>
	</fieldset>
	<div id="info" style="width: 600px; height: 400px;"></div>

	<!-- 事件线 -->

	</div>

	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/js/main.js"></script>

</body>
</html>