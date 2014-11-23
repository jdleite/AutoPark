function validar(dom,tipo){
	switch(tipo){
		case'num':var regex=/[A-Za-z]/g;break;
		case'text':var regex=/\d+$/g;break;
	case'especi':var regex =/[123456789!@#$%¨&"'()]/g;break;
	}
	dom.value=dom.value.replace(regex,'');
}