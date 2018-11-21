<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tweeter</title>
</head>
<body>
<table border="1">
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Email</td>
        <td>Delete/Edit</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td><a href="<c:url value='delete?id=${user.id}'/>">Delete</a>
                <a href="<c:url value='edit?id=${user.id}'/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>