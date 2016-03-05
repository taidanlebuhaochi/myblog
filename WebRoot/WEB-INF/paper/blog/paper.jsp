<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>${paper.title }</title>
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
			<div class="col-md-12">
				<!-- 开始修改区域 -->
				<div id="content">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title ">文章详情</h4>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<h3>${paper.title }</h3>
									<hr style="border-top: 1px solid #ffffff;">
									<div id="paperContent">${paper.content }</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="pull-right">
										<span class="label label-default">${paper.tagDomain.name}</span> 
										<span class="label label-default">MingJian</span> 
										<span class="label label-default">post</span>
									</p>
									<ul class="list-inline">
										<li><a href="javascript:void(0);">${paper.timeAgo}</a></li>
									</ul>
								</div>
							</div>
							<!-- story-start -->

							<!--story end -->

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<!-- 页尾文件引入 -->
	<jsp:include page="/frame/footer.jsp"></jsp:include>

	<!-- script references -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
