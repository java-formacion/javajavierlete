'use strict';

var fieldset;
var form;
var spanerror;
var divError;

window.onload = function (){
	fieldset = document.getElementsByTagName('fieldset')[0];
	form = document.forms[0];
	
	form.onsubmit = function(e){
		e.preventDefault();
		
		var pass = document.getElementById("password");
		var dato = pass.value;
		
		resetErrores();
		
		if(esPasswordValida(dato)){
			alert('OK');
			form.submit();
		}
		else {
			spanerror = document.getElementById("errorpassword");
			spanerror.innerHTML = "La contraseña debe cumplir los requisitos de complejidad";
			
			divError = document.createElement('div');
			
			divError.className = "alert alert-danger";
			divError.setAttribute('role', 'alert');
			divError.innerHTML = "Ha habido errores en los campos";
					
			fieldset.appendChild(divError);
			//return false;
		}
	};
};

function resetErrores(){
	if(spanerror){
		spanerror.innerHTML = "";
	}
	
	if(divError){
		divError.parentNode.removeChild(divError);
		divError = undefined;
	}
}

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