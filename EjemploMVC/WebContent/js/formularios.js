/**
 * Comprobacion de passwordmatching para formulario
 */

    function check() {
        if (document.getElementById('password2').value != document.getElementById('password').value) {
            //input.setCustomValidity('Password Must be Matching.');
        	alert("Diferentes");
        } else {
            // input is valid -- reset the error message
            //input.setCustomValidity('');
        	alert("Iguales");
        	
        }
    }