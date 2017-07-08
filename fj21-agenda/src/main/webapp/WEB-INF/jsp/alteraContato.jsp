<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="cabecalho.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Alterar Contato</title>
</head>
<body>

	<div align="center">
		<form action="./mvc?logica=AdicionaContatoLogica" method="post">
			ID: ${contato.id}<br /> <input type="hidden" name="id"
				value="${contato.id}" /> Nome: <input type="text" name="nome"
				value="${contato.name}" /><br /> E-mail: <input type="text"
				name="email" value="${contato.email}" /><br /> Endereço: <input
				type="text" name="endereco" value="${contato.endereco}" /><br />
			<c:set var="dataFormatada">
				<fmt:formatDate value="${contato.dataNascimento.time}"
					pattern="dd/MM/yyyy" />
			</c:set>
			Data Nascimento:
			<caelum:campoData id="dataNascimento" value="${ dataFormatada }" />
			<input type="submit" value="Alterar" />
		</form>
	</div>

</body>
<c:import url="rodape.jsp" />
</html>