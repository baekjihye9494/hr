<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>AddRegionFrom</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- meny.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	
	<div class="container">
	<form method="post" action="${pageCotext.request.contextPath}/addRegion">
		<div class="form-group">
			<label for="regionId">regionId:</label>
			<input type="text" name="regionId" class="form-control">
		</div>
		<div class="form-group">		
			<label for="regionName">regionName:</label>
			<input type="text" name="regionName" class="form-control">
		</div>
		<div>		
			<button type="submit" class= "btn btn-primary">추가</button>
		</div>
	</form>
	</div>
	
	
	<!-- foter.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
		
</body>
</html>