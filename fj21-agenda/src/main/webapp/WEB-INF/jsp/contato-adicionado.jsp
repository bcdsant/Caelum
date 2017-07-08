<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="cabecalho.jsp"/>
<head>
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>Contato <b>${param.nome}</b> ${msg} com sucesso!</p>
		<form action="mvc?logica=ListaContatosLogica" method="post"><input type="submit" value="Voltar Para Listagem" /></form>
	</div>
</body>
<c:import url="rodape.jsp"/>
</html>