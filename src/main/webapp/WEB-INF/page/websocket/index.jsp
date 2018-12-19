<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Java后端WebSocket的Tomcat实现</title>
　　　　　<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
　　　　　<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body>
    Welcome<br/>
    id<br/>
    <input id="id" type="text"/><br/>
    ms<br/>
    <input id="text" type="text"/>
    <button onclick="send()">发送消息</button>
    <div id="list"></div>
    <hr/>
    <button onclick="closeWebSocket()">关闭WebSocket连接</button>
    <hr/>
    <div id="message">
        <img id="imgInit" src="" />
    </div>
</body>
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws:localhost:8080/websocket/${customerid }");
    }
    else {
        alert('当前浏览器 Not support websocket');
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    };
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        var mycars=new Array(event.data);
        setMessageInnerHTML(mycars[0]);
    };
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    };
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    };
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/Api/parent/readImg?token=00ebb809a913f9572332cb0afa8ee2c3&toId=f61e077460b769d8",
            success:function(data){
                var arry=data.data;
                var adres="http://localhost:8080/Api/parent/show?token=00ebb809a913f9572332cb0afa8ee2c3&fileName="+arry;
                document.getElementById('imgInit').src = adres
            }
        });

        document.getElementById('message').innerHTML += innerHTML + '<br/>';

    }
    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }
    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        var  id = document.getElementById('id').value;
        var data = id+"-"+message;
        websocket.send(data);
    }
</script>
</html>