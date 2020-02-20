<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业图谱查询</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />


</head>
<body >

	<div class="row-fluid" style="margin-top: 100px;">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/Echart/全国/预测.jsp"
				method="post" id="checkForm" target="myFrameName">
				
					<div class="form-group">
					<label class="col-md-3 control-label" for="tags">预测城市</label>
					<div class="col-md-9">
						<input class="form-control" name="Yu_city" type="text" id="tags"
							placeholder="例如“石家庄”" value="" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-primary btn-block">
							提交</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/myValidate.js" type="text/javascript"></script>
	
</body>
</html>