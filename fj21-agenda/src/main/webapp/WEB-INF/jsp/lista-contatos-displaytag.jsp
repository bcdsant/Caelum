<%@page import="br.com.caelum.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>Lista Contatos</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<display:table name="contatos" id="contatosTable">
	<display:setProperty name="basic.msg.empty_list"> <a href="mvc?logica=AdicionaContatoForm"> Adicione seu primeiro contato</a> </display:setProperty>
	<display:column property="id" title="ID"/>
    <display:column property="name" title="Nome"/>
    <display:column property="email" autolink="true" title="E-mail" />
    <display:column property="dataNascimento.time" format="{0,date,dd/MM/yyyy}" title="Data de nascimento"/>
    <display:column property="endereco" title="Endereço"/>
    <display:column title="Remover"> <a href="mvc?logica=RemoveContatoLogica&id=${contatosTable.id}">Remover</a> </display:column>
    <display:column title="Alterar"> <a href="mvc?logica=AlteraContatoLogica&id=${contatosTable.id}">Alterar</a> </display:column>
    <display:footer>
    	<td>-</td>
    	<td>-</td>
    	<td>-</td>
    	<td>-</td>
    	<td>-</td>
    	<td><a href="mvc?logica=AdicionaContatoForm">Adicionar</a></td>
    	<td>-</td>
    </display:footer>
</display:table>
<c:import url="rodape.jsp"/>

</body>
</html>