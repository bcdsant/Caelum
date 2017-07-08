<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="cabecalho.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
	<body>
		<div align="center">
			<form action='mvc?logica=ListaContatosLogica' method="post">
			    <input type="submit" value="Ver Agenda" />
			</form>
		</div>
	</body>
<c:import url="rodape.jsp"/>
</html>