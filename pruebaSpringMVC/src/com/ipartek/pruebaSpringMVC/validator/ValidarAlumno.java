package com.ipartek.pruebaSpringMVC.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.pruebaSpringMVC.vo.Alumno;

@Component
public class ValidarAlumno implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Alumno.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		
	
		ValidationUtils.rejectIfEmpty(arg1, "nombre", "error.nombre", "Nombre mal");
		/*
		ValidationUtils.rejectIfEmpty(arg1, "apellido", "apellido vacio");
		ValidationUtils.rejectIfEmpty(arg1, "telefono", "telefono vacio");
		ValidationUtils.rejectIfEmpty(arg1, "direccion", "direcion vacia");
		ValidationUtils.rejectIfEmpty(arg1, "email", "email vacio");
		*/
		
		
		
	}

}
