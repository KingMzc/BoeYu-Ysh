<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>历史提现</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/list.css" media="all" />
	<script>  
        <%--JS gloable varilible--%>  
        var ctx = "${ctx}";
        var showflag =0;
    </script>  
<style type="text/css">
</style>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote news_search">
	<form class="layui-form">
		<div>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" id="nickname" value="" placeholder="请输入姓名"
						   class="layui-input search_input">
				</div>
				<div class="layui-input-inline">
					<input type="text" id="phone" value="" placeholder="手机号码"
						   class="layui-input search_input">
				</div>
			</div>
			<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cx"
			   lay-filter="search">查询</a>
			<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cz"
			   lay-filter="search">重置</a>
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
	<!-- 数据表格 -->
	<table id="carouselList" lay-filter="test"></table>
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/page/admin/cashlog.js"></script>
	<div id="dialog_large_image"></div>
	<script type="text/html" id="tableImg">
  		<img src="${ctx}/file/showPic?fileName={{d.idcardz}}" onclick="show('{{d.idcardz}}')" style="height:48px;width:48px;line-height:48px!important;"/>
	</script>
	<script type="text/html" id="tableImgt">
		<img src="${ctx}/file/showPic?fileName={{d.idcardf}}" onclick="show('{{d.idcardz}}')" style="height:48px;width:48px;line-height:48px!important;"/>
	</script>
	<script type="text/html" id="tableImgs">
		<img src="${ctx}/file/showPic?fileName={{d.bank}}" onclick="show('{{d.idcardz}}')" style="height:48px;width:48px;line-height:48px!important;"/>
	</script>

	<script type="text/html" id="barEdit">
			<a class="layui-btn layui-btn-xs" lay-event="edit">通过</a>
			<a class="layui-btn layui-btn-xs" lay-event="editq">拒绝</a>
	</script>
<script >
	function show(id) {
	    if(showflag==0){
            var large_image = "<img src= ${ctx}/file/showPic?fileName="+id+"></img>";
            $('#dialog_large_image').html($(large_image).animate({ height: '50%', width: '50%' }, 500));
            showflag=1;
		}else{
            $('#dialog_large_image').html("");
            showflag=0;
		}

    }
</script>
	<script type="text/html" id="bankTpl">
		{{#  if(d.bankid === '1'){ }}
		中国工商银行
		{{#  } else if(d.bankid === '2'){ }}
		中国人民建设银行
		{{#  } else if(d.bankid === '3'){ }}
		中国银行
		{{#  } else if(d.bankid === '4'){ }}
		中国农业银行
		{{#  } else { }}
		未知银行
		{{#  } }}
	</script>
	<script type="text/html" id="flagTpl">
		{{#  if(d.flag === '0'){ }}
		通过
		{{#  } else if(d.flag === '1'){ }}
		未通过
		{{#  } else if(d.flag === '2'){ }}
		待审批
		{{#  } else { }}
		未知
		{{#  } }}
	</script>
	<style>
	.layui-table-cell{
	    height:36px;
	    line-height: 36px;
	}
	</style>
</body>
</html>