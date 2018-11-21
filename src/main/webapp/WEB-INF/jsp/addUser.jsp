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
<form:form action="add" method="post" modelAttribute="newUser">
    First name : <form:input path="firstName" /><br><br>
    Last name : <form:input path="lastName" /><br><br>
    Email : <form:input path="email" /><br><br>
    <input type="submit" value="Save"><br><br>
</form:form>
</body>
</html>