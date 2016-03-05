<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>MingJian's add_blog</title>
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
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">添加随笔</h3>
			</div>
			<div class="panel-body">
				<!-- 表单开始 -->
				<form id="addForm" action="<c:url value='/blog'/>" method="POST">
					<input name="content" type="hidden">
					<!-- 主内容区 -->
					<div class="row">
						<div class="col-md-6">
							<!--文章标题-->
							<input name="title" type="text" class="form-control"
								placeholder="文章标题">
						</div>

						<div class="col-md-2">
							<!--标签-->
							<select name="tag" class="form-control">
								<c:forEach items="${tags }" var="tag">
									<option value="${tag.id }">${tag.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<hr>

					<div class="row">
						<div class="col-md-6">
							<input name="summary" type="text" class="form-control"
								placeholder="文章大纲">
						</div>

						<div class="col-md-3">
							<!--图片上传-->
							<input name="pic" type="file">
						</div>
					</div>
					<hr>
					
					<!--preview-->
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title">展示区</h3>
								</div>
								<div class="panel-body">
									<div id="preview"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div id="content">
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-success">
											<div class="panel-heading">
												<h3 class="panel-title">预编译区</h3>
											</div>
										</div>
									</div>
								</div>
								<!-- 开始修改区域 -->
								<div class="row">
									<div class="col-md-12">
										<textarea id="text-input" oninput="this.editor.update()"
											rows="10">#Type Markdown here.</textarea>
									</div>
								</div>
								<!-- 结束 -->
							</div>
						</div>
					</div>
					
					<hr>
					<div class="row">
						<div class="col-md-1 col-md-offset-10">
							<button id="addBtn" class="btn btn-primary">确认添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
			

		<!-- 主内容区结束 -->
		
	</div>

	<hr>

	<!-- 页尾文件引入 -->
	<jsp:include page="/frame/footer.jsp"></jsp:include>

	<!-- script references -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="js/markdown.min.js"></script>
	<script>
 		//markdown实时展示
		function Editor(input, preview) {
		  this.update = function () {
		    preview.innerHTML = markdown.toHTML(input.value);
		  };
		  input.editor = this;
		  this.update();
		}
    </script>
    
    <script>
    	$(function(){
    		var $markdown = function (id) { return document.getElementById(id); };
    		new Editor($markdown("text-input"), $markdown("preview"));
    		
    		$("#addBtn").click(function(){
	    		$("#addForm input:first").attr("value",$("#preview").html());
	    		$("#addForm").submit();
    		})
    		
    	})
    </script>
</body>
</html>
