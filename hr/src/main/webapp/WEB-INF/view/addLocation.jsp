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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function(){
		$('#regionId').change(function() {
			// alert('regionId change');
			// ajax호출 -> 값 -> countryId select append
			if($('#regionId').val() == '') {
				alert('region을 선택하세요');
			} else {
				$('#countryId').empty();
				$('#countryId').append('<option value="">::: country 선택 :::</option>')
				
				$.ajax({
					url : '/rest/getCountryList',
					type : 'get',
					data : {regionId : $('#regionId').val()},
					success : function(json) {
						//let arr = [];
						$(json).each(function(index, item){
							//arr.push(item);
							$('#countryId').append('<option value="'+item.countryId+'">'+item.countryName+'</option>')
						});
						//console.log(arr);
					}
				});
			}
		});
	});
	</script>

</head>
<body>
	
	<!-- meny.jsp  include-->
	<div class="container">
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	

	<div class="container">
	<form method="post" action="${pageContext.request.contextPath}/addLocation">
		<div class="form-group">
			regionId :
			<select id="regionId">
				<option value="">::: region 선택 :::</option>
				<c:forEach var="r" items="${regionList}">
					<option value="${r.regionId}">${r.regionName}</option>
				</c:forEach>
			</select>
			
			countryId :
			<select name="countryId" id="countryId">
			</select>
		</div>
		
		<div class="form-group">
			<label for="locationId">locationId:</label>
			<input type="text" name="locationId" class="form-control">
		</div>
		<div class="form-group">
			<label for="streetAddress">streetAddress:</label>
			<input type="text" name="streetAddress" class="form-control">
		</div>
		<div class="form-group">
			<label for="postalCode">postalCode:</label>
			<input type="text" name="postalCode" class="form-control">
		</div>
		<div class="form-group">
			<label for="city">city:</label>
			<input type="text" name="city" class="form-control">
		</div>
		<div class="form-group">
			<label for="stateProvince">stateProvince:</label>
			<input type="text" name="stateProvince" class="form-control">
		</div>
		<button type="submit" class= "btn btn-primary">추가</button>
	</form>
	</div>
	
	<!-- footer include -->
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
</body>
</html>