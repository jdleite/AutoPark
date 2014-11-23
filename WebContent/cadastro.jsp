<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de cliente</title>
<%@include file="header.jsp"%>
<%@include file="mensagem.jsp"%>

 
<script language="JavaScript" type="text/javascript" src="java/validar.js"></script>
<script language="JavaScript" type="text/javascript" src="java/formatarData.js"></script> 
<script language="JavaScript" type="text/javascript" src="java/validarCadastro.js"></script>
<script language="javaScript" type="text/javascript" src="java/formatarPlaca.js"></script>
</head>
<body>


	<%@include file="menu.jsp"%>
	<div class="container">
		<form action="estacioServlet" method="post"  onsubmit="validarCadastro()">
			<input type="hidden" name="acao" value="cadastrar">
			

			<h2>Cadastro de cliente</h2>
			<div class="row">

				<div>
					 <input type="text"
						name="ident" id="idIdent" readonly="readonly" class="form-control"
						size="10px" style="width: 100px" value="${numero}" />
				</div>

				<div class="form-group col-md-6">
					<label for="idNome">Nome</label> <input type="text" name="nome"
						id="idNome" class="form-control" size="10px" 
						style="width: 300px"onkeyup="validar(this,'especi');"/>
				</div>
                
				<div class="form-group col-md-4">
					<label for="idSexo">Sexo</label> <select name="sexo" id="idSexo"
						class="form-control">
						<option>Selecione</option>
						<option>Homem</option>
						<option>Mulher</option>
					</select>
				</div>
				 </div>
                 <div class="row">

				<div class="form-group col-md-6">
					<label for="idDtaNasci">Data de Nascimento</label> <input
						type="text" name="data" OnKeyUp="mascaraData(this);"
						maxlength="10" id="idNAsci" class="form-control"
						style="width: 300px"/>
				</div>






				<div class="form-group col-md-6">
					<label for="idCor">Cor do carro</label> <input type="text"
						name="cor" id="idCor" style="width: 300px" 
						onkeyup="validar(this,'especi');" class="form-control"/>
				</div>

				<div class="form-group col-md-6">
					<label for="idMarca">Marca</label> <input type="text" name="marca"
						id="idMarca" style="width: 300px" 
						onkeyup="validar(this,'especi');" class="form-control" />
				</div>
					<div class="form-group col-md-4">
					<label for="idTipo">Tipo do Veiculo</label> <select name="tipo" id="idTipo"
						class="form-control">
						<option>Selecione</option>
						<option>Carro</option>
						<option>Moto</option>
						<option>Van</option>
						<option>Caminhão</option>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="idPlaca">Placa</label> <input type="text" name="placa"
						id="idPlaca" style="width: 300px" class="form-control" 
						OnKeyUp="formatarPlaca(this);" maxlength="8"/>
				</div>

				
				</div>
                 <div class="form-group">
				<input type="submit" value="Salvar" onclick="document.location='cadastro.jsp'"
						class="btn btn-success"/>
			</div>
		</form>
           
	</div>
	
</body>
</html>