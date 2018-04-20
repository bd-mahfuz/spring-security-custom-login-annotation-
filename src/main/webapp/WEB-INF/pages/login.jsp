<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true"%> 
<%@ page isELIgnored="false"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="">
			
			<c:if test="${not empty message}">
				${message}
			</c:if>
			
			<form action="/spring_security/login" method="POST">
			<table>
				<tbody>
					<tr>
						<td>
							<input type="text" name="username" id="username"/>
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" name="password" id="password"/>
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="submit" value="Submit"/>
						</td>
					</tr>
				</tbody>
			</table>
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		</div>
</body>
</html>