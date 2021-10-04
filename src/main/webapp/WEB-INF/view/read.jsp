<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Read news</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="s/resources/css/add-news-form.css" />" />

</head>
<body>
<body>
	<h1>${news.title}</h1>

	<h3>${news.date}</h3>

	<h2>${news.content}</h2>
	<br>

	<div style="">
		<p>
			<a href="../list">Back to News List</a>
		</p>
	</div>

</body>
</body>
</html>