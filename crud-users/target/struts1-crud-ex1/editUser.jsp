<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ page import="com.mlvn.crud_users.model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit product</title>
</head>
<body>
	<html:link action="/home.html">Return home page</html:link>
	<br>
	<br>
	<html:form action="/process-edit-product.html" method="post">
		<%User user = (User) request.getAttribute("user"); %>
		<html:text name="prod" property="id" readonly="true" value="<%=user.getId()%>"></html:text>
		<br>
		<label>Name</label>
		<html:text property="name" name="prod" value="<%=user.getName()%>"></html:text>
		<br>
		<label>Email</label>
		<html:text property="email" name="prod" value="<%=user.getEmail()%>"></html:text>
		<br>
		<label>Phone</label>
		<html:text property="phone" name="prod" value="<%=user.getPhone()%>"></html:text>
		<br>
		<label>Birthday</label>
		<html:text property="birthday" name="prod" type="date" value="<%=user.getBirthday()%>"></html:text>
		<br>
		<html:submit>Edit User</html:submit>
	</html:form>
</body>
</html>