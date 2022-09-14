<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegionList</title>
</head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<body>
<body>
	<!-- meny.jsp  include-->
	<div class= "container">
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
		
	<div class= "container">
		<a href= "${pageContext.request.contextPath}/addRegion" class="btn btn-success">add region</a>
	</div>
	
	<div class="container">
	<table class="table table-hover">
		<tr>
			<th>regionId</th>
			<th>regionName</th>	
			<th>수정</th>			
			<th>삭제</th>
		</tr>
		<c:forEach var="r" items="${list}">
			<tr>
				<td>${r.regionId}</td>
				<td>${r.regionName}</td>
				<td>
				<a href="${pageContext.request.contextPath}/modifyRegion?regionId=${r.regionId}&regionName=${r.regionName}"
						class="btn btn-warning">수정</a></td>
				<td>
				<a href="${pageContext.request.contextPath}/removeRegion?regionId=${r.regionId}"
						class="btn btn-info">삭제</a></td>
				
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<!-- foter.jsp  include-->
	<div class= "container">
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
		
</body>
</html>