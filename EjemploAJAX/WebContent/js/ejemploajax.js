'use strict';

$(function(){
	$('form').submit(function(e){
		e.preventDefault();
		
		var emailCodificado = encodeURIComponent($('#email').val());
		
		console.log(emailCodificado);
		
		$.getJSON('existeemail?email=' + emailCodificado, function(datos){
			alert(datos.respuesta);
		}).fail(function(a, b, error){
			alert(error);
		}).always(function(){
			alert("SIEMPRE");
		});
	});
});