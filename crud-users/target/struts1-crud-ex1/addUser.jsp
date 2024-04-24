<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new User</title>
</head>
<body>
	<html:link action="/home.html">Return home page</html:link>
	<br>
	<logic:present name="message">
		<bean:write name="message" />
	</logic:present>
	<br>
	<html:form action="/process-add-user.do" method="post">
		<label>Name</label>
		<html:text property="name" name="prod"></html:text>
		<br>
		<label>Email</label>
		<html:text property="email" name="prod"></html:text>
		<br>
		<label>Phone</label>
		<html:text property="phone" name="prod"></html:text>
		<br>
		<label>Birthday</label>
		<html:text property="birthday" name="prod" type="date"></html:text>
		<br>
		<html:submit>Create new User</html:submit>
	</html:form>
</body>
</html>