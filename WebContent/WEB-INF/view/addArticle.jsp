<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add Article</title>
</head>
<body>
<h1>Add Article</h1>

<c:url var="viewArticlesUrl" value="/articles.html" />
<a href="${viewArticlesUrl}">Show All Articles</a>
<br></br>
<c:url var="saveArticleUrl" value="/articles/save.html" />
<form:form modelAttribute="article" method="POST"
	action="${saveArticleUrl}">
	<form:label path="articleName">Article Name:</form:label>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form:input path="articleName" size="46" />
	<br></br>
	<form:label path="articleDesc">Article Description:</form:label>
	<form:textarea path="articleDesc" rows="3" cols="40" />
	<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="Save Article" />
</form:form>

</body>
</html>