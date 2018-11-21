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
<form:form action="editSaveToDB" method="post" modelAttribute="newUser">
New first name : <form:input path="firstName" />
New last name : <form:input path="lastName" />
New email : <form:input path="email" />
</div>
<f:hidden path="id" />
<div>
    <input type="submit" value="Save">
    </form:form>
</body>
</html>