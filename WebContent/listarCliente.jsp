<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Cadastro</title>
<%@include  file="menu.jsp"%>
<%@include file="header.jsp" %>
</head>
<body>

<table class="table table-hover">
		<tr>
			<th>Identificação</th>
			<th>Nome</th>
			<th>Data de Cadastro</th>
			<th>Data de nascimento</th>
		</tr>
		<c:forEach items="${dados}" var="ca">
		 	<tr>
		 		<td>${ca.cliente.getId_Cliente()}</td>
		 		<td>${ca.cliente.getNome()}</td>
		 		<td><fmt:formatDate value="${ca.dtCadastro.time}" pattern="dd/MM/yyyy"/></td>
		 		<td><fmt:formatDate value="${ca.cliente.getDt_Nascimento().getTime()}" pattern="dd/MM/yyyy"/></td>
		 		<td><c:url value="estacioServlet" var="link">
		 			<c:param name="acao" value="excluirCadastro"/>
		 			<c:param name="ident" value="${ca.cliente.getId_Cliente()}"/>
		 		</c:url>
		 		<a href="${link}" onclick="return confirm('Tem Certeza?') "class="btn btn-danger">
		 		Apagar
		 		</a>
		 		</td>	
		 	</tr>
		</c:forEach>
	</table>

</body>
</html>