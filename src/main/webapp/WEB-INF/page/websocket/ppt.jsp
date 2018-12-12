<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>PPT</title>
　　　　　<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
　　　　　<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<img id="imgInit" src="" style="height:500px;width:800px;line-height:600px!important;" onclick="xyy()"/><br/>
<input type="button" value="上一页" onclick="syy()"><input type="button" value="下一页" onclick="xyy()">
<div id="cs">

</div>
</body>
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    var arry=new Array();
    var yes=0;
    var zs=0;
    $(document).ready(function(){
        <c:forEach items="${imgNames }" var="item">
        arry.push("${item}");
        </c:forEach>
        /*document.getElementById("cs").innerText="<img src=http://localhost:8080/file/showPPT?fileName="+img[0]+"/>"*/
        console.log(arry[0]);
        var adres="http://192.168.199.221:8080/file/showPPT?fileName="+arry[yes];
        document.getElementById('imgInit').src = adres
        zs=arry.length;
    });
function syy() {
    var ys=yes-1;
    yes--;
    if(ys<0){
        var adres="http://192.168.199.221:8080/file/showPPT?fileName="+arry[0];
        document.getElementById('imgInit').src = adres
        yes=0
    }else{
        var adres="http://192.168.199.221:8080/file/showPPT?fileName="+arry[yes];
        document.getElementById('imgInit').src = adres
    }

}

function xyy() {
    var ys=yes+1;
    yes++;
    if(ys>=zs){
        var adres="http://192.168.199.221:8080/file/showPPT?fileName="+arry[zs-1];
        document.getElementById('imgInit').src = adres
        yes=zs-1;
    }else{
        var adres="http://192.168.199.221:8080/file/showPPT?fileName="+arry[yes];
        document.getElementById('imgInit').src = adres
    }
}

</script>
</html>