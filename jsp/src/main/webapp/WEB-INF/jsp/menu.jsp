<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Menü Sayfası</title>
</head>
<body>
Hoşgeldiniz ${login}<br/><br/>
<a href="<c:url value="/personeller" />">Personeller</a><br/>
<a href="<c:url value="/cikis" />">Çıkış</a><br/>
</body>
</html>