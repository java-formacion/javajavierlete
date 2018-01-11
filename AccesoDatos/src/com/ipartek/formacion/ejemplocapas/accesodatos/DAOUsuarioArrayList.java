package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioArrayList  implements DAOUusuario{

private ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	
	@Override
	public void alta (Usuario usuario){
		
		if(obtenerUsuariosPorEmail(usuario.getEmail())!= null)
			throw new AccesoDatosExcepcion ("Ya existe un usuario con el email: "+ usuario.getEmail());
		usuarios.add(usuario);
		
			//--> \W+ SIGNIFICA PQUE PUEDE TENER UNA LETRA ALFANUMERICA O MAS (+)
			// \@ ARROBA CON LA BARRA CON CARACTER ESPECCIAL
			// \. EL PUNTO TAMBIEN ES UN CARACTER ESPECIAL
			// PARA FORMAR UNA EXPERSION REGULAR DE COMPORBACION DE CORREO SERÍA ASI:
			//--> \w+\@\w+\.\w+
			
		
		
	}

	@Override
	public void baja(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacion(Usuario usuario) {
				
		Usuario u;
		
		for (int i =0; i< usuarios.size();i++) {
			u=usuarios.get(i);
			
			if(u.getId()== usuario.getId()) {
				u.setApellido(usuario.getApellido());
				u.setDni(usuario.getDni());
				u.setEmail(usuario.getEmail());
				u.setNombre(usuario.getNombre());
				u.setPassword(usuario.getPassword());
			}
		}
			
				
	}

	@Override
	public Usuario[] obtenerUsuarios() {
		//devuelve un array de usuarios dandole yo un array vacio con capacidad para los usuarios de la coleccion
		//si no, lo tiene que generar el  por su cuenta y devolveroa un array de objets
		return usuarios.toArray(new Usuario[usuarios.size()]);
	}

	@Override
	public Usuario obtenerUsuariosPorId(long id) {
		
		for (Usuario u: usuarios) {
			if (id==u.getId()) {
				//se devuelve el resultado, el null solo de devuelve cuando no se cumple el if
				return  u;
			}
		}
			
		return null;
	}

	@Override
	public Usuario obtenerUsuariosPorEmail(String email) {
		
		if (email==null)
		return null;	
			
		for (Usuario u: usuarios) {
			
			if (u.getEmail().equals(email)) {
				//se devuelve el resultado, el null solo de devuelve cuando no se cumple el if
				return  u;
			}
		}
		return null;
	}
	
	

}
