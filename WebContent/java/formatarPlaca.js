function formatarPlaca(campoPlaca){
	var placa = campoPlaca.value;
	if(placa.length == 3){
		placa = placa + '-';
		document.forms[0].placa.value = placa;
		return true;
	}
}