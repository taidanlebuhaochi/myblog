<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>登陆</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<jsp:include page="/meta/common.jsp"></jsp:include>
	<jsp:include page="/css/common.jsp"></jsp:include>
	<link rel="stylesheet" href="<c:url value='/css/blog/login.css'/>" >
</head>
<body>


	<jsp:include page="/frame/header.jsp"></jsp:include>
    <!-- core content -->
    <div class="container container-fix">
      <form class="form-signin" action="<c:url value='/login/account'/>" method="post">
      <c:if test="${not empty msg }">
      	<div class="alert alert-danger" role="alert">账号或密码名错误</div>
      </c:if>
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputEmail" class="sr-only">账号</label>
      <input name="email" type="email" id="inputEmail" class="form-control" placeholder="账号" required autofocus>
      <label for="inputPassword" class="sr-only">密码</label>
      <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div>
	<hr>
	<!-- 页尾文件引入 -->
	<jsp:include page="/frame/footer.jsp"></jsp:include>

    <!-- script references -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="<c:url value='/js/blog/common.js'/>"></script>
</body>
</html>
