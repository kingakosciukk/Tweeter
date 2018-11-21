<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tweeter</title>
</head>
<body>
<h1>Tweeter</h1><br>
<h3>Welcome in Tweeter application</h3><br>
<a href="<c:url value='user/1/tweets'/>"> Show tweets  </a><br>
<a href="<c:url value='user/add'/>"> Add user  </a><br>
<a href="<c:url value='tweet/add'/>"> Add tweet  </a><br>
<a href="<c:url value='user/all'/>"> Show users  </a><br>
</body>
</html>