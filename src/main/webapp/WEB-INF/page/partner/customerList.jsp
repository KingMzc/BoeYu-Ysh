<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>家长列表</title>
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
					<input type="text" id="nickname" value="" placeholder="请输入昵称"
						   class="layui-input search_input">
				</div>
				<div class="layui-input-inline">
					<input type="text" id="phone" value="" placeholder="手机号码"
						   class="layui-input search_input">
				</div>
				<div class="layui-input-inline layui-form">
					<select name="sex" class="sex" id="sex">
						<option value="-1">请选择性别</option>
						<option value="1">男</option>
						<option value="0">女</option>
						<option value="2">保密</option>
					</select>
				</div>
				<div class="layui-input-inline layui-form">
					<select name="vip" class="vip" id="vip">
						<option value="-1">请选择账户类型</option>
						<option value="0">普通</option>
						<option value="1">VIP</option>
						<option value="2">异常</option>
					</select>
				</div>
				<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cx"
				   lay-filter="search">查询</a>
				<a class="layui-btn search_btn" lay-submit="" data-type="search" id="cz"
				   lay-filter="search">重置</a>
			</div>
		</div>
	</form>
	</blockquote>
	<!-- 数据表格 -->
	<table id="adminList" lay-filter="test"></table>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<%--<script type="text/javascript" src="${ctx }/page/partner/customerList.js"></script>--%>
	<script >
        layui.config({
            base : "js/"
        }).use(['form','layer','jquery','laypage','table','laytpl'],function(){
            var form = layui.form,table = layui.table;
            layer = parent.layer === undefined ? layui.layer : parent.layer,
                laypage = layui.laypage,
                $ = layui.jquery;
            active = {
                search : function() {
                    var nickname = $('#nickname'), sex = $('#sex option:selected'), vip = $('#vip option:selected') ,phone = $('#phone');
                    //执行重载
                    table
                        .reload(
                            'adminList',
                            {
                                page : {
                                    curr : 1
                                    //重新从第 1 页开始
                                },
                                where : {
                                    //key: {
                                    nickname : nickname
                                        .val(),
                                    phone : phone
                                        .val(),
                                    sex : sex
                                        .val(),
                                    vip : vip
                                        .val()
                                }
                            });
                }
            };
            //数据表格
            table.render({
                id:'adminList',
                elem: '#adminList'
                ,url: ctx+'/partner/getCustomerList' //数据接口
                ,cellMinWidth: 80
                ,toolbar : true
                ,limit:10//每页默认数
                ,limits:[10,20,30,40]
                ,cols: [[ //表头
                    {field:'id', title: 'ID', sort: true}
                    ,{field:'nickname', title: '昵称'}
                    ,{field:'sex', title: '性别',templet: '#sexTpl'}
                    ,{field:'vip', title: '会员',templet: '#vipTpl'}
                    ,{field:'vipTime', title: '会员到期时间',templet: '<div>{{ formatTime(d.vipTime,"yyyy-MM-dd")}}</div>'}
                    ,{field:'phone', title: '联系方式'}
                    ,{field:'money', title: '金钱'}
                    ,{field:'money', title: '佣金',templet: '<div>{{ d.money * 0.3}}</div>'}
                ]]
                ,page: true //开启分页
                ,where: {timestamp: (new Date()).valueOf()}
            });
            //监听工具条
            table.on('tool(test)', function(obj){
                var data = obj.data,adminId=$("#adminId").val();
                if(obj.event === 'del'){
                    if(data.id==adminId){
                        layer.msg("不允许删除自己！",{icon: 5});
                        return;
                    }
                    layer.confirm('真的删除行么', function(index){
                        $.ajax({
                            url:ctx+'/sys/delAdminById/'+data.id,
                            type : "get",
                            success : function(d){
                                if(d.code==0){
                                    //obj.del();
                                    table.reload('adminList', {})
                                }else{
                                    layer.msg("权限不足，联系超管！",{icon: 5});
                                }
                            }
                        })
                        layer.close(index);
                    });
                } else if(obj.event === 'edit'){
                    if(data.id=='1'){
                        layer.msg("不允许编辑此用户！",{icon: 5});
                        return;
                    }
                    if(data.id==adminId){
                        layer.msg("不允许编辑自己！",{icon: 5});
                        return;
                    }
                    layer.open({
                        type: 2,
                        title:"编辑角色",
                        area: ['380px', '560px'],
                        content:ctx+"/partner/editAdmin/"+data.id //这里content是一个普通的String
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
                 $('#nickname').val("");
                $('#phone').val("");
                $("#sex").val("-1");
                 $('#vip').val("-1");
                 $('#phone').val("");
                var form = layui.form;
                form.render('select');
            })

            //添加角色
            $(".adminAdd_btn").click(function(){
                var index = layui.layer.open({
                    title : "添加管理员",
                    type : 2,
                    content : ctx+"/sys/addAdmin",
                    success : function(layero, index){
                        layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    }
                })
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layui.layer.full(index);
                })
                layui.layer.full(index);
            })

            //批量删除角色
            $(".batchDel").click(function(){
                var checkStatus = table.checkStatus('adminList')
                    ,data = checkStatus.data,adminStr='',flag=false,adminId=$("#adminId").val();
//	      layer.alert(JSON.stringify(data));
                if(data.length>0){
                    $.each(data, function (n, value) {
                        //避免选择不允许操作角色
                        if(value.roleName=='超级管理员'){
                            flag=true;
                            layer.msg('"超级管理员"不允许被删除！',{icon: 5});
                            return;
                        }
                        if(value.id+""==adminId){
                            flag=true;
                            layer.msg('不允许删除自己！',{icon: 5});
                            return;
                        }
                        adminStr+=value.id+',';
                    });
                    //包含不允许操作角色，结束方法
                    if(flag){
                        return;
                    }
                    adminStr=adminStr.substring(0,adminStr.length-1);
                    layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
                        //调用删除接口
                        $.ajax({
                            url:ctx+'/sys/delAdmins/'+adminStr,//接口地址
                            type : "get",
                            success : function(d){
                                if(d.code==0){
                                    //删除成功，刷新父页面
                                    parent.location.reload();
                                }else{
                                    layer.msg("删除错误，稍后再试！",{icon: 5});
                                }
                            }
                        })
                    });
                }else{
                    layer.msg("请选择要操作的数据！");
                }

            })

        })

        //格式化时间
        function formatTime(datetime,fmt){
            if (parseInt(datetime)==datetime) {
                if (datetime.length==10) {
                    datetime=parseInt(datetime)*1000;
                } else if(datetime.length==13) {
                    datetime=parseInt(datetime);
                }
            }
            datetime=new Date(datetime);
            var o = {
                "M+" : datetime.getMonth()+1,                 //月份
                "d+" : datetime.getDate(),                    //日
                "h+" : datetime.getHours(),                   //小时
                "m+" : datetime.getMinutes(),                 //分
                "s+" : datetime.getSeconds(),                 //秒
                "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
                "S"  : datetime.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
        }


	</script>
	<script type="text/html" id="sexTpl">
 		 {{#  if(d.sex === '0'){ }}
   		 <span style="color: #F581B1;">女</span>
  		{{#  } else if(d.sex === '1'){ }}
   		 	男
		{{#  } else{ }}
   		 	保密
  		{{#  } }}
	</script>
	<script type="text/html" id="vipTpl">
		{{#  if(d.vip === '0'){ }}
		普通
		{{#  } else if(d.sex === '1'){ }}
		<span style="color: sandybrown;">VIP</span>
		{{#  } else{ }}
		异常
		{{#  } }}
	</script>
</body>
</html>