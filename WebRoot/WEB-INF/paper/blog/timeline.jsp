<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>最近开发时间轴</title>
   	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/css/blog/timeline.css'/>" >
	<jsp:include page="/meta/common.jsp"></jsp:include>
	<jsp:include page="/css/common.jsp"></jsp:include>
	
  </head>
  
  <body>
  	<jsp:include page="/frame/header.jsp"></jsp:include>
  	<div class="container container-fix">
  		<div class="tl-content">
  			<div class="row">
  				<div class="col-md-8">
	  				<div class="panel panel-default">
					  <div class="panel-heading">最近开发轴</div>
					  <div class="panel-body">
					  <c:forEach items="${ctimelines }" var="clines">
		  				<article>
							<h3>${clines.year }</h3>
							<c:forEach items="${clines.blogTimeLineList}" var="lines">
								<section>
									<c:if test="${lines.color == 1 }">
										<span class="point-time point-yellow"></span>
									</c:if>
									<c:if test="${lines.color == 2 }">
										<span class="point-time point-red"></span>
									</c:if>
									<c:if test="${lines.color == 3 }">
										<span class="point-time point-blue"></span>
									</c:if>	
									<c:if test="${lines.color == 4 }">
										<span class="point-time point-green"></span>
									</c:if>
									<c:if test="${lines.color == 5 }">
										<span class="point-time point-purple"></span>
									</c:if>		
									<time datetime="2013-03">
										<span><fmt:formatDate pattern="MM.dd" value="${lines.date}" /></span>
									</time>
									<aside>
										<p style="margin:0 auto" class="brief">${lines.content }</p>
									</aside>
								</section>
							</c:forEach>
						</article>					  
					  </c:forEach>

					  </div>
					</div>
  				</div>
  				
		        <!--siderbar-->
		        <div class="col-md-4">
			        <div id="siderbar">
			        
			        </div>	
		        </div>
  			</div>
  			

		</div>
  	</div>
  	
  	<hr>
	<!-- 页尾文件引入 -->
	<jsp:include page="/frame/footer.jsp"></jsp:include>
 	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/js/frame/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/blog/common.js'/>"></script>

  </body>
  
</html>
