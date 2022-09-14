<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>AddCountryFrom</title>
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
	<form method="post" action="${pageCotext.request.contextPath}/addCountryForm">
		<div class="form-group">
			<label for="countryId">countryId:</label>
			<input type="text" name="countryId" class="form-control">
		</div>
		
		<div class="form-group">		
			<label for="countryName">countryName:</label>
			<input type="text" name="countryName" class="form-control">
		</div>
		<select name="regionId"> <!-- select + option 은 세트 / 그안에 돌릴것만 넣으면 됨-->
			<c:forEach var="r" items="${list}">
				<option value="${r.regionId}">${r.regionName}</option>	
			</c:forEach>
		</select>	
		<button type="submit" class= "btn btn-primary">추가</button>
	</form>
	</div>
	
	<!-- foter.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
		
</body>
</html>