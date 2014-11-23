function validarCadastro()
{
		if(idNome.value==""){
			alert("O Nome Deve Ser Preenchido");
			document.getElementById("idNome").focus();
			return false;
		}
		if(idSexo.value=="Selecione"){
			alert("Selecione o Sexo");
			return false;
			
		}
		if(idNAsci.value==""){
			alert("Informe a Data de Nascimento");
			document.getElementById("idNAsci").focus();
			return false;
		}
		if(idCor.value==""){
			alert("Iforme a Cor do Veiculo");
			document.getElementById("idCor").focus();
			return false;
		}
		if(idMarca.value==""){
			alert("Iforme a Marca do Veiculo");
			document.getElementById("idMarca").focus();
			return false;
			
		}
		
		if(idPlaca.value==""){
			alert("Iforme a Placa do veiculo");
			document.getElementById("idPlaca").focus();
			return false;
		}
		
			
      alert("Cliente Cadastrado Com Sucesso!");
			
		
}