<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.ucsal.lamis.util.Repositorio" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="repositorio" class="br.ucsal.lamis.util.Repositorio" scope="application"/>
<meta charset="ISO-8859-1">
<title>Laboratorios</title>
</head>
<body>
<p>Usuário: ${usuario.login}</p>
<p>Lista de laboratórios livres</p>
<c:forEach var="item" items="${listaLaboratorios}">
	 Id: ${item.id} | }Nome: ${item.nome } | Descrição: ${item.descricao} | Bloco: ${item.bloco.nome } |**| <a href="./Excluir?id=${item.id}"> Excluir</a> 
</c:forEach>
</body>
</html>