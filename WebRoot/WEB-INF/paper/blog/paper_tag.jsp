<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>${tag.name }类文章</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<jsp:include page="/meta/common.jsp"></jsp:include>
	<jsp:include page="/css/common.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/frame/header.jsp"></jsp:include>
    <!-- core content -->
    <div class="container container-fix">
      <div class="row">
        <div class="col-md-8">
        
		  <!-- 开始修改区域 -->
          <div id="content">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">${tag.name }</h4>
              </div>
              <div class="panel-body">
                <!-- story-start -->
               	<c:forEach items="${page.pageContent }" var="paper">
	                <div class="row">
	                  <div class="col-md-12 col-sm-12">
	                    <h3><a href="<c:url value='/blog/p/${paper.id }'/>" target="_Blank" >${paper.title }</a></h3>
	                    <div class="row">
	                      <div class="col-xs-12">
	                      	<br>
	                        <p>
	                          ${paper.summary }
	                        </p>
	
	                        <p class="lead">
	                        </p>
	                        <p class="pull-right">
	                          <span class="label label-default">${paper.tagDomain.name }</span>
	                          <span class="label label-default">MingJian</span>
	                          <span class="label label-default">post</span>
	                        </p>
	                        <ul class="list-inline">
	                          <li><a href="javascript:void(0);">${paper.timeAgo}</a></li>
	                        </ul>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	                <hr>
                </c:forEach>
                <!--story end -->
                <!-- 分页 -->
                <nav>
				  <ul class="pagination pull-right">
				    <li id="prePage">
				      <a href="<c:url value='/blog?tagId=${tag.id }&pageNo=${page.pageNo-1 }'/>" aria-label="Previous">
				        <span aria-hidden="true">上一页</span>
				      </a>
				    </li>
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
					   <c:choose>
						  <c:when test="${i eq page.pageNo }">
							<li class="active"><span>${i}</span></li>
						  </c:when>
						  <c:otherwise>
							<li><a href="<c:url value='/blog?tagId=${tag.id }&pageNo=${i}'/>"> ${i}</a></li>
						  </c:otherwise>
					   </c:choose>
					 </c:forEach>
				    <li id="nextPage">
				      <a href="<c:url value='/blog?tagId=${tag.id }&pageNo=${page.pageNo+1 }'/>" aria-label="Next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
				  </ul>
				</nav>
				<!-- 分页结束 -->
              </div>
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

	<hr>
	
	<!-- 页尾文件引入 -->
	<jsp:include page="/frame/footer.jsp"></jsp:include>

    <!-- script references -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/js/blog/common.js'/>"></script>
	<script>
		$(function(){
			var pageNo = ${page.pageNo};
			var pageNum = ${page.totalPageNum}
			if(pageNo <= 1){
				$("#prePage").addClass("disabled");
				$("#prePage a").attr("href","javascript:void(0);");
			}
			if (pageNo >= pageNum){
				$("#nextPage").addClass("disabled");
				$("#nextPage a").attr("href","javascript:void(0);");
			}
			
		})
	</script>
</body>
</html>
