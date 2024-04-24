<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>
    $(function() {
        $("#birthday").datepicker();
    });
</script>

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
		<label for="birthday">Birthday</label>
		<html:text property="birthday" name="prod"></html:text>
		<br>
		<html:submit>Create new User</html:submit>
	</html:form>
</body>
</html>