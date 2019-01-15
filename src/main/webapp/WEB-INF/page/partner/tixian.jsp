<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>提现</title>
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
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/list.css" media="all" />

	<script>
        <%--JS gloable varilible--%>
        var ctx = "${ctx}";
	</script>
	<style type="text/css">
    </style>
<body class="childrenBody">
	<blockquote class="layui-elem-quote list_search">
			<div class="layui-inline">
				全部收益：${smoney/100}
			</div>
			<div class="layui-inline">
				账户余额：${money/100}
			</div>
		   <%-- <div class="layui-inline">
			    已经提现金额：${tmoney}
		    </div>--%>
	</blockquote>
<div style="width: 100%;height: 100%;text-align: center">
	      提现申请温馨提示<br/>
	银行：<select id="yinhang">
	<option value="0">---请选择---</option>
	<option value="1">中国工商银行</option>
	<option value="2">中国人民建设银行</option>
	<option value="3">中国银行</option>
	<option value="4">中国农业银行</option>
</select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	账户：<input type="text" id="zhanghu">  <br/>
	提现金额：<input type="text" id="jine" onchange="getrmb()">(提现需要收取1%手续费！)<br/>
	实际到账金额：<input type="text" id="dzjine" readonly="readonly">(已经扣除1%的手续费)<br/>
	<div style="border: 1px dashed #ccc; width: 350px;height: 200px;margin-left: 37%">
		<img class="layui-upload-img" id="preview" style="width: 150px;margin-top: 5px">
	</div>
	<button type="button" class="layui-btn" id="onePicUpload"><i class="layui-icon"></i>身份证正面上传</button>
	<p id="uploadError"></p>
		<input type="hidden" lay-verify="imgurl" name="imgurl" id="newsImg" value=""/>

	<div style="border: 1px dashed #ccc; width: 350px;height: 200px;margin-left: 37%">
		<img class="layui-upload-img" id="previewt" style="width: 150px;margin-top: 5px">
	</div>
		<button type="button" class="layui-btn" id="twoPicUpload"><i class="layui-icon"></i>身份证反面上传</button><br />
		<p id="uploadErrort"></p>
		<input type="hidden" lay-verify="imgurl" name="imgurl" id="newsImgt" value=""/>

	<div style="border: 1px dashed #ccc; width: 350px;height: 200px;margin-left: 37%">
		<img class="layui-upload-img" id="previews" style="width: 150px;margin-top: 5px">
	</div>
		<button type="button" class="layui-btn" id="sanPicUpload"><i class="layui-icon"></i>银行卡上传</button><br />
		<p id="uploadErrors"></p>
		<input type="hidden" lay-verify="imgurl" name="imgurl" id="newsImgs" value=""/>
</div>
	<button style="float:right" class="layui-btn" lay-submit="" onclick="tixinc()">立即提交</button>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
<script >
    layui.config({
        base : "js/"
    }).use(['layer','jquery','upload'],function() {
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            laypage = layui.laypage,upload = layui.upload;
        $ = layui.jquery;
        form = layui.form;
        //身份证正面上传
        var uploadInst = upload.render({
            elem: '#onePicUpload'
            , url: ctx + '/file/upload'
            , before: function (obj) {
                //预读本地文件
                obj.preview(function (index, file, result) {
                    $('#preview').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg(res.msg);
                }
                //上传成功
                //设置src给图片隐藏域
                $("#newsImg").val(res.data.src);
                layer.msg('上传成功')
            }
            , error: function () {
                //失败状态，并实现重传
                var uploadError = $('#uploadError');
                uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                uploadError.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });

        //身份证反面上传
        var uploadInstt = upload.render({
            elem: '#twoPicUpload'
            , url: ctx + '/file/upload'
            , before: function (obj) {
                //预读本地文件
                obj.preview(function (index, file, result) {
                    $('#previewt').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg(res.msg);
                }
                //上传成功
                //设置src给图片隐藏域
                $("#newsImgt").val(res.data.src);
                layer.msg('上传成功')
            }
            , error: function () {
                //失败状态，并实现重传
                var uploadError = $('#uploadErrort');
                uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                uploadError.find('.demo-reload').on('click', function () {
                    uploadInstt.upload();
                });
            }
        });

        //银行卡上传
        var uploadInsts = upload.render({
            elem: '#sanPicUpload'
            , url: ctx + '/file/upload'
            , before: function (obj) {
                //预读本地文件
                obj.preview(function (index, file, result) {
                    $('#previews').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg(res.msg);
                }
                //上传成功
                //设置src给图片隐藏域
                $("#newsImgs").val(res.data.src);
                layer.msg('上传成功')
            }
            , error: function () {
                //失败状态，并实现重传
                var uploadError = $('#uploadErrors');
                uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                uploadError.find('.demo-reload').on('click', function () {
                    uploadInsts.upload();
                });
            }
        });


    });
    function getrmb(){
        var num1 = document.getElementById('jine').value; //获取第一个输入框的值
        if (isNaN(num1)) {  //如果为非数字，结果为空
            alert("金额必须为正整数！");
            document.getElementById('jine').value="";
        } else {  //将第二个输入框设置为美元值乘以汇率的结果
            document.getElementById('dzjine').value = num1*(1-0.01);
        }
    }

    function tixinc() {
        var yinhang =$("#yinhang").val();
        var zhanghu =$("#zhanghu").val();
        var jine =$("#jine").val();
        var dzjine =$("#dzjine").val();
        var newsImg =$("#newsImg").val();
        var newsImgt =$("#newsImgt").val();
        var newsImgs =$("#newsImgs").val();
        if(yinhang==""||yinhang=="0"){
            alert("请选择银行！")
			return false;
		}
        if(zhanghu==""||zhanghu==null){
            alert("银行账户不能为空！")
            return false;
        }
        if(jine==""||jine==null){
            alert("金额不能为空！")
            return false;
        }else{
            if(jine>${money /100}){
                alert("本次最多提现金额为"+${money /100})
                return false;
            }
            jine=jine*100;
            dzjine=dzjine*100;
		}
        if(newsImg==""||newsImg==null){
            alert("请上传身份证正面图片！")
            return false;
        }
        if(newsImgt==""||newsImgt==null){
            alert("请上传身份证反面图片！")
            return false;
        }
        if(newsImgs==""||newsImgs==null){
            alert("请上传银行卡图片！")
            return false;
        }
        $.ajax({
            type: "post",
            url: ctx+"/partner/addtixian",
            data:{"yinhang": yinhang,
                "zhanghu": zhanghu,
                "jine": jine,
                "newsImg": newsImg,
                "newsImgt": newsImgt,
                "newsImgs": newsImgs,
                "dzjine":dzjine},
            async: false,
            dataType:"json",
            success:function(d){
                alert(d.msg);
            }
        });

    }
</script>


</body>

</html>