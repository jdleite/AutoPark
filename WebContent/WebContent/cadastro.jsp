<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
<%@include file="header.jsp"%>

<x:if test="${not empty erro }">
	<div>
		${erro }
	</div>

</x:if>
<x:if test="${not empty gravado }">
	<div>
		${gravado }
	</div>

</x:if>


</head>

<body>

	<form action="estacioServlet" method="post">
	<script language="JavaScript" type="text/javascript">
   function mascaraData(campoData){
              var data = campoData.value;
              if (data.length == 2){
                  data = data + '/';
                  document.forms[0].data.value = data;
      return true;              
              }
              if (data.length == 5){
                  data = data + '/';
                  document.forms[0].data.value = data;
                  return true;
              }
         }
</script>
	    <input type="hidden" name="acao" value="cadastrar">
		<fieldset>
			<legend>Cadastro</legend>
			  <div>
				<label for="idNome">Nome</label>
				<input type="text" name="nome" id="idNome"/>
		      </div>
		      <div>
				<label for="idDtaNasci">Data de Nascimento</label>
				<input type="text" name="data" OnKeyUp="mascaraData(this);" maxlength="10"  id="idNAsci"/> 
		      </div>
		      <div>
				<label for="idSexo">Sexo</label>
				<input type="radio" name="sexo" value="homem">Homem
                <input type="radio" name="sexo" value="mulher">Mulher
		      </div>
		      <input type="submit" values="Cadastrar">
		</fieldset>
	
	</form>

</body>
</html>