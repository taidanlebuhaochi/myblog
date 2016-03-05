<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav id="nav-fix" class="navbar navbar-default navbar-fixed-top" role="navigation">
	   <div class="container container-fix">
	       <div class="navbar-header">
	           <a class="navbar-brand" href="<c:url value='/home'/>">9Avalon的个人随笔</a>
	       </div>
	       <!--选项-->
	       <div class="collapse navbar-collapse">
	           <ul class="nav navbar-nav">
	               <li><a href="<c:url value='/home'/>">首页</a> </li>
	               <!-- <li><a href="<c:url value='/timeline'/>">时间轴</a> </li> -->
	           </ul>
	           
	           <ul class="nav navbar-right navbar-nav">
		           <c:if test="${empty user }">
		               <li><a href="<c:url value='/login'/>" >登录</a> </li>
		           </c:if>
		           <c:if test="${not empty user }">
		               <li><a href="javascript:void(0);" >管理员你好</a> </li>
		               <li><a href="<c:url value='/user/out'/>">注销</a> </li>
	           	   </c:if>
	           </ul>
	       </div>
       </div>
</nav>	

<div class="container container-fix">
	<div  class="row" style="margin-top: 10px;margin-bottom: 10px">
		<div class="col-md-12">
			<img id="round" alt="head_pic" height="250px" width="100%" src="<c:url value='/images/headpic.jpg'/>">
		</div>
	</div>
</div>
<!-- pic -->

