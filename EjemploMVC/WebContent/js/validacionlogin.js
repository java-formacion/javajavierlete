'use strict';

window.onload=function (){
	var form = document.forms[0];
	
	form.onsubmit=function(e){
		e.preventDefault();
		
		var pass = document.getElementById("password");
		var dato = pass.value;
		
		if(esPasswordValida(dato)){
			alert('OK');
			form.submit();
		}
		else {
			alert('MAL');
			//return false;
		}
	};
};

function esPasswordValida(dato) {
	return tieneMayuscula(dato) && tieneMinuscula(dato) &&
		tieneNumero(dato) && tieneSimbolo(dato);
}

function tieneMayuscula(dato){
	return dato != dato.toLowerCase();
}

function tieneMinuscula(dato){
	return dato != dato.toUpperCase();
}

function tieneNumero(dato){
	return /[0-9]/.test(dato);
}

function tieneSimbolo(dato){
	return /[^0-9a-zA-Z]/.test(dato);
}