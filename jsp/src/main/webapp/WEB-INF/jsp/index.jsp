<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Giriş Sayfası</title>
</head>
<body>
<c:if test="${not empty hata}">
<font color="red"><strong>${hata}</strong></font>
</c:if>
<form action="<c:url value="/giris" />" method="post">
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
	<input type="submit" value="Giriş" />
</form>
</body>
</html>