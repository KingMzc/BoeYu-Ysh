<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>城市合伙人</title>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/partner.css" media="all" />
    <script>
        var ctx = "${ctx}";
    </script>


</head>
<body>


<div class="video_mask"></div>
<div class="login">
    <h1>注册合伙人</h1>
    <form class="layui-form" id="form">
        <div class="layui-form-item">
            手机号码：
            <input class="layui-input" id="username" name="username"  placeholder="手机号码"  lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            登录密码：
            <input class="layui-input" id="password" name="password"   placeholder="密码"   lay-verify="required" type="password" autocomplete="off">
        </div>
        <div class="layui-form-item">
            确认密码：
            <input class="layui-input" id="passwordt" name="passwordt"   placeholder="确认密码"   lay-verify="required" type="password" autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" style="width: 140px;"  id="vcode" name="vcode" placeholder="验证码" lay-verify="required" type="text" autocomplete="off" maxlength="4">
            <div class="code"><img id="captcha" src="${ctx }/sys/vcode" width="100" height="36" onclick="refreshCode(this)"></div>
        </div>
        <div class="layui-form-item form_code">
            <input type="checkbox" name="cs" id="yhxy" lay-skin="primary">
            <span><a href="javascript:void(0);" onclick="yhxy()">用户协议</a></span>
        </div>
        <button class="layui-btn login_btn"  id="ceshi">注册</button>
    </form>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js">
</script>



</body>
<script>
    layui.use(['form', 'layer'], function () {});
    $("#ceshi").click(function () {

        var password=$("#password").val();
        var passwordt=$("#passwordt").val();
        var username=$("#username").val();
        var vcode=$("#vcode").val();
        if(password!=passwordt){
            alert('两次输入密码不一致！');
            refreshCode();
            return false;
        }
        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(!myreg.test(username))
        {
            alert('请输入有效的手机号码！');
            refreshCode();
            return false;
        }
        if(document.getElementById("yhxy").checked){
        }else{
            alert('请选择用户协议');
            refreshCode();
            return false;
        }
        $.ajax({
            type: "POST",
            url: ctx+"/partner/register",
            async: false,
            data:{"password": password,
                "vcode": vcode,
                "username": username},
            success: function (result) {
                alert(result.msg);
                $("#password").val("");
                $("#username").val("")
            }
        });
    })

    function yhxy() {
        layui.use('layer', function() { //独立版的layer无需执行这一句
            var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
            layer.open({
                type: 1,
                title: "用户协议",
                closeBtn: false,
                area: ['600px','400px'],
                shade: 0.8,
                id: 'LAY_layuipro',
                btn: ['关闭'],
                moveType: 1,
                content: '<div style="padding:15px 20px; text-align:justify; line-height: 22px; text-indent:2em;border-bottom:1px solid #e2e2e2;">' +
                    '提示条款<br/>' +
                    '欢迎您与各我方平台经营者（详见定义条款）共同签署本《用户服务协议》（下称“本协<br/>' +
                    '议”）并使用我方平台服务！<br/>' +
                    '各条款标题仅为帮助您理解该条款表达的主旨之用，不影响或限制本协议条款的含义或解<br/>' +
                    '释。为维护您自身权益，建议您仔细阅读各条款具体表述。<br/>' +
                    '【审慎阅读】 您在申请注册流程中点击同意本协议之前，应当认真阅读本协议。 请您务必<br/>' +
                    '审慎阅读、充分理解各条款内容，特别是免除或者限制责任的条款、法律适用和争议解决条<br/>' +
                    '款。免除或者限制责任的条款将以粗体下划线标识，您应重点阅读。 如您对协议有任何疑<br/>' +
                    '问，可向我方平台客服咨询。<br/>' +
                    '【签约动作】 当您按照注册页面提示填写信息、阅读并同意本协议且完成全部注册程序<br/>' +
                    '后，即表示您已充分阅读、理解并接受本协议的全部内容，并与我方平台网站达成一致，成<br/>' +
                    '为优酷网或我方平台“用户”。 阅读本协议的过程中，如果您不同意本协议或其中任何条<br/>' +
                    '款约定，您应立即停止注册程序。<br/>' +
                    '如果您未申请注册流程，您仍可浏览网站内容，但不能发表评论、弹幕或观看付费内容。<br/>' +
                    '如果您在本协议生效前已成为我方平台的注册用户，则您通过访问和/或使用我方平台网<br/>' +
                    '站，即视为您表示同意接受本协议的全部内容，否则请您不要访问或使用我方平台网站。<br/>' +
                    '【法律适用】本协议之订立、生效、解释、修订、补充、终止、执行与争议解决均适用中华<br/>' +
                    '人民共和国法律；如法律无相关规定的，参照商业惯例及/或行业惯例。<br/>' +
                    '【管辖】您因使用我方平台服务所产生及与我方平台服务有关的争议，由我方与您协商解<br/>' +
                    '决。协商不成时，任何一方均可向被告所在地人民法院提起诉讼。<br/>' +
                    '【条款有效性】本协议任一条款被视为废止、无效或不可执行，该条应视为可分的且并不影<br/>' +
                    '响本协议其余条款的有效性及可执行性。<br/>' +
                    '</div>',
                success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.css('text-align', 'center');

                }
            });
        })
    }
    function refreshCode(){
        var captcha = document.getElementById("captcha");
        captcha.src = ctx+"/sys/vcode?t=" + new Date().getTime();
    }
</script>

</html>