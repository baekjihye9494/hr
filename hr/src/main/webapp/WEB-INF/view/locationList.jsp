<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CountryList</title>
</head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<body>
	<!-- meny.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	
	<div class="container">
		<a href= "${pageContext.request.contextPath}/addLocation" class="btn btn-success">add location</a>
	</div>
		
		<div class="container">
			<table class="table table-hover">
				<tr>
					<th>locationId</th>
					<th>streetAddress</th>
					<th>postalCode</th>
					<th>city</th>
					<th>stateProvince</th>
					<th>countryId</th>			
					<th>countryName</th>		
					<th>regionName</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach var = "m"  items="${list}"> 
					<tr>
						<td>${m.LOCATIONID}</td>
						<td>${m.STREETADDRESS}</td>
						<td>${m.POSTALCODE}</td>
						<td>${m.CITY}</td>
						<td>${m.STATEPROVINCE}</td>
						<td>${m.COUNTRYID}</td>
						<td>${m.COUNTRYNAME}</td>
						<td>${m.REGIONNAME}</td>
						<td>
							<a href="${pageContext.request.contextPath}/modifyLocation?locationId=${m.LOCATIONID}"
								class="btn btn-warning">수정</a></td>
						<td>
							<a href="${pageContext.request.contextPath}/removeLocation?locationId=${m.LOCATIONID}"
								class="btn btn-info">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	<!-- foter.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
		
</body>
</html>