<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>编辑用户信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<script>  
        var ctx = "${ctx}";  
    </script> 
<style type="text/css">
.layui-form-item .layui-inline {
	width: 33.333%;
	float: left;
	margin-right: 0;
}

@media ( max-width :1240px) {
	.layui-form-item .layui-inline {
		width: 100%;
		float: none;
	}
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 80%;">
		<!-- 管理员id -->
		<input type="hidden" name="id" value="${customer.id }" id="uid"/>
		<div class="layui-form-item">
			<label class="layui-form-label">昵称</label>
			<div class="layui-input-block">
				<input type="text" id="nickname" class="layui-input userName"
					lay-verify="required" name="nickname" value="${customer.nickname }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
			<c:if test="${customer.sex=='0' }">
				<input type="radio" name="sex" value="1" title="男" >
				<input type="radio" name="sex" value="0" title="女" checked> 
				<input type="radio" name="sex" value="2" title="保密">
			</c:if>
			<c:if test="${customer.sex=='1' }">
				<input type="radio" name="sex" value="1" title="男" checked>
				<input type="radio" name="sex" value="0" title="女" > 
				<input type="radio" name="sex" value="2" title="保密">
			</c:if>
			<c:if test="${customer.sex=='2' }">
				<input type="radio" name="sex" value="1" title="男" >
				<input type="radio" name="sex" value="0" title="女"> 
				<input type="radio" name="sex" value="2" title="保密" checked>
			</c:if>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户信息</label>
			<div class="layui-input-block">
				<input type="text" name="message" class="layui-input userName" lay-verify="required" placeholder="请输入用户信息" value="${customer.message }">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-block">
				<input type="text" name="phone" class="layui-input userName"
					lay-verify="phone" placeholder="请输入手机号" value="${customer.phone }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户状态</label>
			<div class="layui-input-block">
				<select name="status" class="" id="status">
					<c:if test="${customer.status=='0' }">
						<option value="0" selected="selected">未激活</option>
						<option value="1">正常</option>
						<option value="2">禁用</option>
					</c:if>
					<c:if test="${customer.status=='1' }">
						<option value="0">未激活</option>
						<option value="1" selected="selected">正常</option>
						<option value="2">禁用</option>
					</c:if>
					<c:if test="${customer.status=='2' }">
						<option value="0">未激活</option>
						<option value="1">正常</option>
						<option value="2" selected="selected">禁用</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">VIP</label>
			<div class="layui-input-block">
				<select name="vip" class="" id="vip">
					<c:if test="${customer.vip=='0' }">
						<option value="0" selected="selected">正常</option>
						<option value="1">VIP</option>
						<option value="2">异常</option>
					</c:if>
					<c:if test="${customer.vip=='1' }">
						<option value="0">正常</option>
						<option value="1" selected="selected">VIP</option>
						<option value="2">异常</option>
					</c:if>
					<c:if test="${customer.vip=='2' }">
						<option value="0">正常</option>
						<option value="1">VIP</option>
						<option value="2" selected="selected">异常</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="updUser">立即保存</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<%--<script type="text/javascript" src="${ctx }/page/user/editUser.js"></script>--%>
<script type="text/javascript">
    var $;
    var form;
    layui.config({
        base : "js/"
    }).use(['form','layer','jquery','laydate'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            laydate = layui.laydate;
        $ = layui.jquery;
        form = layui.form;

        laydate.render({
            elem: '#birthday' //指定元素
            ,max: 'new Date()'
        });

        $("#nickname").blur(function(){
            $.ajax({
                type: "get",
                url: ctx+"/user/checkUserByNickname/"+$("#uid").val()+"&nickname="+$("#nickname").val(),
                success:function(data){
                    if(data.code!=0){
                        top.layer.msg(data.msg);
                        $("#nickname").val("");
                        $("#nickname").focus();
                    }
                }
            });
        });

        $("#eMail").blur(function(){
            $.ajax({
                type: "post",
                url: ctx+"/user/checkUserByEmail/"+$("#uid").val()+"&eMail="+$("#eMail").val(),
                success:function(data){
                    if(data.code!=0){
                        top.layer.msg(data.msg);
                        $("#eMail").val("");
                        $("#eMail").focus();
                    }
                }
            });
        });


        form.on("submit(updUser)",function(data){
            //弹出loading
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var msg;
            $.ajax({
                type: "post",
                url: ctx+"/user/updUser",
                data:data.field,
                dataType:"json",
                success:function(d){
                    if(d.code==0){
                        msg="修改成功";
                    }else{
                        msg=d.msg;
                    }
                }
            });
            setTimeout(function(){
                top.layer.close(index);
            },1000);
            setTimeout(function(){
                top.layer.msg(msg);
            },2000);
            setTimeout(function(){
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
           },4000);
            return false;
        })

    })
</script>
</body>
</html>