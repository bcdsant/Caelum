<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adiciona Contatos</title>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>


<c:import url="cabecalho.jsp" />
<body>

	<form action="./mvc?logica=AdicionaContatoLogica" method="post">

		Nome: <input type="text" name="nome" /><br /> E-mail: <input
			type="text" name="email" /><br /> Endereço: <input type="text"
			name="endereco" /><br /> Data Nascimento:
		<caelum:campoData id="dataNascimento" />

		<input type="submit" value="Gravar" />
	</form>
</body>
<c:import url="rodape.jsp" />
</html>