<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>管理系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="${ctx }/css/main.css" media="all" />
	<script>  
        var ctx = "${ctx}";
    </script>
</head>
<body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main">
				<a href="#" class="logo">BoeYu管理系统</a>
				<!-- 显示/隐藏菜单 -->
				<a href="javascript:;" class="iconfont hideMenu icon-menu1"></a>
			    <!-- 顶部右侧菜单 -->
			    <ul class="layui-nav top_menu">
			    	<%--<li class="layui-nav-item showNotice" id="showNotice">
						<a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
					</li>--%>
			    	<%--<li class="layui-nav-item" mobile>
			    		<a href="javascript:;" class="mobileAddTab" data-url="${ctx }/sys/changePwd"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a>
			    	</li>--%>
			    	<%--<li class="layui-nav-item" mobile>
			    		<a href="${ctx }/sys/loginOut" class="signOut"><i class="iconfont icon-loginout"></i> 退出</a>
			    	</li>--%>
					<li class="layui-nav-item" pc>
						<a href="javascript:;">
							<i class="layui-icon">&#xe612;</i>
							<cite><shiro:principal property="fullname"/>  </cite>
						</a>
						<dl class="layui-nav-child">
							<dd><a href="javascript:;" data-url="${ctx }/sys/personalData"><i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd>
							<dd><a href="javascript:;" data-url="${ctx }/sys/changePwd"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd>
							<dd><a href="${ctx }/sys/loginOut" class="signOut"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<!-- <div class="navBar layui-side-scroll"></div> -->
			<div class="navBar"></div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form" style="border-top: 0px solid #1AA094;border-left: 0px solid #1AA094">
			<div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
				<ul class="layui-tab-title top_tab" id="top_tabs" style="height: 100px">
					<li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>首页</cite></li>
				</ul>
				<!-- 当前页面操作 -->
				<ul class="layui-nav closeBox" >
				  <li class="layui-nav-item" >
				    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
				    <dl class="layui-nav-child">
					  <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
				      <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
				      <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
				    </dl>
				  </li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show" id="showflag">
						<iframe id="myframe" src="${ctx }/sys/main"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 移动导航 -->
	<div class="site-tree-mobile layui-hide"><i class="layui-icon">&#xe602;</i></div>
	<div class="site-mobile-shade"></div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/leftNav.js"></script>
	<script type="text/javascript" src="${ctx }/js/index.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
	<script>
		var flag=0;
        $(document).ready(function(){
            $.ajax({
                type: "POST",
                url: ctx+"/sys/checkflag",
                async: false,
                success: function (result) {
                    flag=result.data;
                    if(result.data>1){
                        checkflag();
					}
                }
            });
            if(flag>0){
                document.getElementById("myframe").src="${ctx }/partner/customerList"
			}
        });
     function checkflag() {
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['退出','测试']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>你的账号还未通过后台的审核，如需帮助<br><br>请联系我们<br><br>联系方式是：哈哈哈</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: '${ctx }/sys/loginOut'
                ,target: '${ctx }/sys/loginOut'
            });
        }
    });
	})
}

	</script>
</body>
</html>