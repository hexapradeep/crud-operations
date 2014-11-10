<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>

<body>
<h1>
    Add a Employee
</h1>
 
<c:url var="addAction" value="empl/add" ></c:url>
 
<form:form action="${addAction}" commandName="employee" method="post">

<table>
    <c:if test="${!empty Employee.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td>
    </tr>
    
    <tr>
        <td>
               <form:label path="country"> 
                <spring:message text="country"/>
               </form:label>
         </td>
        <td>
        
          <%--   <form:input path="country" /> --%>
                <form:select path="country">  
                <form:option value="india">INDIA</form:option>  
                <form:option value="japan">JAPAN</form:option>  
                <form:option value="usa">USA</form:option>  
                <form:option value="china">CHINA</form:option>  
               </form:select>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="salary">
                <spring:message text="Salary"/>
            </form:label>
        </td>
        <td>
            <form:input path="salary" />
        </td>
    </tr>
     <tr>
        <td>
            <form:label path="age">
                <spring:message text="AGE"/>
            </form:label>
        </td>
        <td>
            <form:input path="age" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty Employee.name}">
                <input type="submit"
                    value="<spring:message text="Edit Employee"/>" />
            </c:if>
            <c:if test="${empty Employee.name}">
                <input type="submit"
                    value="<spring:message text="Add Employee"/>" />
            </c:if>
        </td>
    </tr>
</table> 
</form:form>
<br>
<h3>employee List</h3>
<c:if test="${!empty listemployees}">
    <table class="tg">
    <tr>
        <th width="80">Employee ID</th>
        <th width="120">Employee Name</th>
        <th width="120">Employee Country</th>
        <th width="120">Employee SALARY</th>
        <th width="120">Employee AGE</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listemployees}" var="Employee">
        <tr>
            <td>${Employee.id}</td>
            <td>${Employee.name}</td>
            <td>${Employee.country}</td>
             <td>${Employee.age}</td>
              <td>${Employee.salary}</td>
            <td><a href="<c:url value='/edit/${Employee.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${Employee.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>