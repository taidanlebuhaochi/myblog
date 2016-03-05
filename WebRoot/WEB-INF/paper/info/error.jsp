<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>错误页面</title>
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<jsp:include page="/meta/common.jsp"></jsp:include>
	<jsp:include page="/css/common.jsp"></jsp:include>
    <style>
        .row{
            margin-bottom: 5px;
        }
        .errdiv{
            text-align: center;
            /*position: relative;*/
            vertical-align:middle;
        }
        .errimg{
            width: 555px;
            height: auto;
        }
    </style>
</head>
<body style="background-color: #ffffff;">

<jsp:include page="/frame/header.jsp"></jsp:include>
<div class="container">
    <div class="errdiv">
        <img class="errimg" src="<c:url value='/images/500.png'/>">
    </div>
</div>

    <script src="${path}/js/jquery-1.10.1.min.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
</body>
</html>