'use strict';

$(function (){
	$('input[type=submit]').click(function(e){
		e.preventDefault();
		
		resetErrores();
		
		if(esPasswordValida($('#password').val())){
			$('form').submit();
		}
		else {
			$('#errorpassword').html("La contraseña debe cumplir los requisitos de complejidad");
			
			$('fieldset').append('<div class="alert alert-danger" role="alert">Ha habido errores en los campos</div>');
		}
	});
});

function resetErrores(){
	$('span.alert-danger').empty();
	
	$('div.alert-danger').remove();
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