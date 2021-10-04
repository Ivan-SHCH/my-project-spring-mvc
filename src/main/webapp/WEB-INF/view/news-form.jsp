<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Read News</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/add-news-form.css" />" />

<style>
.error {
	color: red
}
</style>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<c:if test="${param['newsId'] !=null }">
			<h2>Update news</h2>
			</c:if>
			<c:if test="${param['newsId'] ==null }">
			<h2>Add news</h2>
			</c:if>
			
		</div>
		
		<form:form action="addNews" modelAttribute="news" method="POST">
			<form:hidden path="id" />
			
			<div class="textarea">
				<label for="title" style="color:green">Title:</label>
				<br />
				<form:textarea class="txta" id="title" name="title" path="title"/>
				<form:errors path = "title" cssClass="error" ></form:errors>
			</div>
			<br />
			
			<div class="textarea">
				<label for="brief" style="color:green">Brief:</label>
				<br />
				<form:textarea class="txta" id="brief" name="brief" path="brief"/>
				<form:errors path = "brief" cssClass="error" />
			</div>
			
			<br />
			<div class="textarea">
				<label for="content" style="color:green">Content:</label>
				<br />
				<form:textarea class="txta" id="content" name="content" path="content"/>
				<form:errors path = "content" cssClass="error" />
			</div>
			
			<br />
			
				<label for="content" style="color:green">Style:</label>
				<br />
				<form:input  id="style" name="style" path="style"/>
				<form:errors path = "style" cssClass="error" />
			
			
			<br />
			<input class= add-button type="submit" value="Save" class="save" />

		</form:form>
		<div>
			<p>
				<a href="list">Back to News List</a>
			</p>
		</div>
	</div>
</body>
</html>