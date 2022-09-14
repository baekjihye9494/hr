<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
 <%--    <div class="navbar-header">
      <a class="navbar-brand " href="${pageContext.request.contextPath}/regionList">Home</a>
    </div> --%>
    <ul class="nav navbar-nav">
      	<li><a href="${pageContext.request.contextPath}/regionList">대륙관리</a></li>
		<li><a href="${pageContext.request.contextPath}/countryList">나라관리</a></li>
		<li><a href="${pageContext.request.contextPath}/locationList">지역관리</a></li>
		<li><a href="${pageContext.request.contextPath}/departmentList">부서관리</a></li>		
		<li><a href="${pageContext.request.contextPath}/employeeList">사원관리</a></li>
		<li><a href="${pageContext.request.contextPath}/jobList">사원이력관리</a></li>	
		<li><a href="${pageContext.request.contextPath}/jobHistoryList">사원이력관리</a></li>
    </ul>
  </div>
</nav>
<hr>