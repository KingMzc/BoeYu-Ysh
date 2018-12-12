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

<form action="http://192.168.199.221:8080/sys/testppt" method="get">
    <input type="text" name="fname" value=""/>
    <input type="submit" value="提交">
</form>
</body>
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

</script>
</html>