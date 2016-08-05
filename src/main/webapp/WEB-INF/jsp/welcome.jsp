<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/template/tags.jsp"%>
<html>

<head>
	<title>Hdiv Ajax Samples</title>
	<%@ include file="/WEB-INF/jsp/template/head.jsp"%>
</head>

<body>
	<h1>Hdiv Ajax Samples</h1>

	<p>Ajax samples working with Hdiv.</p>

	<!-- For the sake of example, use the page form with this set of links: -->

	<h2>
		<c:url value="/nestedSelect" var="url" />
		<a href="${url}">Nested selects Example Section </a>
	</h2>
	<p>Nested selects example.</p>
	
	<%@ include file="/WEB-INF/jsp/template/footer.jsp"%>
</body>
</html>
