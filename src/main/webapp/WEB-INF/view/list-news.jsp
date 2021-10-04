<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>News List</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/style.css"/>" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>LIST NEWS</h2>
		</div>

		<div id="container">

			<input type="button" value="Add News"
				onclick="window.location.href = 'showFormForAdd'; return false"
				class="add-button" />

			<table>
				<tr>
					<th>Title</th>
					<th>Brief</th>
					<th>Style</th>
					<th>Date</th>
					<th></th>
				</tr>

				<c:forEach var="tmpNews" items="${news}">
				<c:url var="updateLink" value="/news/showFormForUpdate">
				<c:param name="newsId" value="${tmpNews.id}"></c:param></c:url>
				
				<c:url var="deleteLink" value="/news/delete">
				<c:param name="newsId" value="${tmpNews.id}"></c:param></c:url>
				
				<c:url var="readLink" value="/news/read/">
				<c:param name="newsId" value="${tmpNews.id}"></c:param></c:url>
				
					<tr>
						<td>${tmpNews.title}</td>
						<td>${tmpNews.brief}</td>
						<td>${tmpNews.style}</td>
						<td>${tmpNews.date}</td>
						<td>
							<!-- display the update link --> 
							<a href="${updateLink}">Update</a>
							<a href="${readLink}"> Read</a>
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>