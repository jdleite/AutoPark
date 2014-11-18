<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp" %>
<%@include file="mensagem.jsp" %>
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

</head>
<body>


<%@include file="menu.jsp"%>
	<form action="estacioServlet" method="post">
	    <input type="hidden" name="acao" value="cadastrar">
		
			<legend>Cadastro de cliente</legend>
			
              <div>
				<label for="idIdent">Indentificação</label>
				<input type="text" name="ident" id="idIdent" readonly="readonly"
				class="form-control" size="10px" style="width:100px" value="${numero}"/>
		      </div>			
			  <div>
				<label for="idNome">Nome</label>
				<input type="text" name="nome" id="idNome"
				class="form-control" size="10px" style="width:300px"/>
		      </div>
		   <div>
				<label for="idDtaNasci">Data de Nascimento</label>
				<input type="text" name="data" 
				OnKeyUp="mascaraData(this);" maxlength="10"  
				id="idNAsci" class="form-control" style="width:300px"/> 
		      </div>
		     <div>
				<label for="idSexo">Sexo</label>
				<input type="radio" name="sexo" value="homem">Homem
                <input type="radio" name="sexo" value="mulher">Mulher
		      </div>
		      <div>
		      	<label for="idCor">Cor</label>
		      	<input type="text" name="cor" id="idCor" style="width:300px" 
		      	 class="form-control"/>		      
		      </div>
		  
		       <div>
		      	<label for="idMarca">Marca</label>
		      	<input type="text" name="marca" id="idMarca" style="width:300px" 
		      	 class="form-control"/>		      
		      </div>
		      <div>
		      	<label for="idPlaca">Placa</label>
		      	<input type="text" name="marca" id="idMarca" style="width:300px" 
		      	class="form-control"/>		      
		      </div>
		      <div>
		      	<label for="idPlaca">Tipo</label>
		      	<input type="text" name="tipo" id="idTipo" style="width:300px" 
		      	class="form-control"/>		      
		      </div>
		      	    
		      <div>		   
		      <input type="submit" values="Cadastrar">
		      </div>
		  
		      
		
	
	</form>
  </div>
</body>
</html>