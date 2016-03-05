<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 侧边栏 -->
<c:if test="${not empty user and user.auth==1 }">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">控制面板</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<a href="<c:url value='/markdown'/>">添加随笔</a><br>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-12">
							<a href="javascript:void(0);" data-toggle="modal" data-target="#addTimeLine">添加时间轴</a><br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">动态</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<p>平时在项目中遇到的问题或者方法，我会一一记录下来，以后可以当作资料库查阅。</p>
						<br />
						<p>勤为捷径，滴水石穿。</p>
						<hr>
						<p>小站诞生第${builtDay }日</p>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">随笔分类</h3>
			</div>
			<div class="panel-body">
				<div>
					<c:forEach items="${tags }" var="tag">
						<a href="<c:url value='/home?type=tag&detail=${tag.id }'/>">${tag.name }(${tag.count })</a>
						<hr>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">归档</h3>
			</div>
			<div class="panel-body">
				<div>
					<c:forEach items="${allData }" var="data">
						<c:forEach items="${data.months}" var="month">
							<a href="<c:url value='/home?type=history&detail=${data.year }-${month.month }'/>">${data.year}年${month.month }月(${month.count})</span></a>
							<hr>
						</c:forEach>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="addTimeLine" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <form action="<c:url value='/timeline'/>" method="post">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">增加时间轴事件</h4>
	      </div>
	      
	      <div class="modal-body">
	        	<input class="form-control" name="content" placeholder="内容"/>
	      </div>
	      <div class="modal-footer">
	        <button type="submit" class="btn btn-primary">确定</button>
	      </div>
	    </div>
	  </div>
  </form>
</div>

