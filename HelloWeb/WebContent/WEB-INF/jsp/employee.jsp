<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>BWSS</title>
</head>
<body>
<DIV ALIGN=CENTER>
<h2>Biltmore Weekly Scheduling System</h2>
<form:form method="POST" action="/BWSS/addEmp">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password"  type='password'/></td>
    </tr>
    <tr>
    <form:form method="GET" action="/BWSS/addEmp">
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
       </form:form>
    </tr>
</table>  
</form:form>
</DIV>
</body>
</html>