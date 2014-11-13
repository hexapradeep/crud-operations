<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		var date = $('#datepicker').datepicker({ dateFormat: 'dd/mm/yy' }).val();

	});
</script>

<style>
.rightJustified {
	text-align: right;
}
.right{
	text-align: right;
}
#empp {
background-color: #C0C0C0;
}
   .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
   .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
   .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
   .tg .tg-4eph{background-color:#f9f9f9}
 
</style>

<body id="empp">

	<h1>Add a Employee</h1>
	<c:url var="addAction" value="/empl/add"></c:url>

	<form:form action="${addAction}" commandName="employee" method="post">

		<table>
			<c:if test="${!empty employee.employeeName}">
				<tr>
					<td><form:label path="employeeId">
							<spring:message text="EmployeeID" />
						</form:label></td>
					<td><form:input path="employeeId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="employeeId" /></td>
				</tr>
			</c:if>
			

			<tr>
				<td><form:label path="employeeName">
						<spring:message text="EmployeeName" />
					</form:label></td>
				<td><form:input path="employeeName" style="text-transform: uppercase"
						type="text" placeHolder="Enter Full Name"/></td>
			</tr>


			<tr>
				<td><form:label path="country">
						<spring:message text="Country" />
					</form:label></td>
				<td>
					<%--   <form:input path="country" /> --%> <form:select
						path="country">
						<form:option value="india">INDIA</form:option>
						<form:option value="japan">JAPAN</form:option>
						<form:option value="usa">USA</form:option>
						<form:option value="china">CHINA</form:option>
					</form:select>
				</td>
			</tr>
			
			
			<tr>
				<td><form:label path="employeeSalary">
						<spring:message text="EmployeeSalary" />
					</form:label></td>
				<td><form:input path="employeeSalary" style="text-align: right"
						class="right" /></td>
			</tr>
			<tr>
				<td><form:label path="employeeAge">
						<spring:message text="EmployeeAge" />
					</form:label></td>
				<td><form:input path="employeeAge" style="text-align: right"
						class="rightJustified" /></td>
			</tr>


			<tr>
				<td><form:label path="joiningDate">
						<spring:message text="JoiningDate" />
					</form:label></td>
					
				<td><form:input path="joiningDate" id="datepicker"/>
			 

			<tr>
				<td colspan="2"><c:if test="${!empty employee.employeeName}">
						<input type="submit"
							value="<spring:message text="Edit Employee"/>" />
					</c:if> 
					<c:if test="${empty employee.employeeName}">
						<input type="submit" value="<spring:message text="Add Employee"/>" />
					</c:if></td>
			</tr>

		</table>
		
	</form:form>
	<br>
	<h2>Employee List</h2>
	<c:if test="${!empty listemployees}">
		<table class="tg">
			<tr>
				<th width="80">Employee ID</th>
				<th width="120">Employee Name</th>
				<th width="120">Employee Country</th>
				<th width="120">Employee SALARY</th>
				<th width="120">Employee AGE</th>
				<th width="120">Employee joiningDate</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listemployees}" var="Employee">
				<tr>
					<td>${Employee.employeeId}</td>
					<td>${Employee.employeeName}</td>
					<td>${Employee.country}</td>
					<td>${Employee.employeeSalary}</td>
					<td>${Employee.employeeAge}</td>
					<td>${Employee.joiningDate}</td>
					<td><a href="<c:url value='/edit/${Employee.employeeId}' />"> <button type="button">Edit</button> </a></td>
					<td><a href="<c:url value='/remove/${Employee.employeeId}' />"> <button type="button">Delete</button> </a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
