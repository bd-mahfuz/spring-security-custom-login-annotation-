<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true" %>
<html>
<body>
<h2>Hello World!</h2>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	Welcome ${pageContext.request.userPrincipal.name} <br/>
	<a href='<c:url value="/logout"></c:url>'>logout</a>
</c:if>
</body>
</html>
