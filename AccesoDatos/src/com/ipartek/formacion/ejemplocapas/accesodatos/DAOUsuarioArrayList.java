package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioArrayList  implements DAOUusuario{

private ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	
	@Override
	public void alta(Usuario usuario) {
		if(obtenerUsuariosPorEmail(usuario.getEmail()) !=null)
			throw new AccesoDatosException("Ya existe un usuario con el email "+usuario.getEmail());
		
		//expresion regular  email: \w+\@\w+\.\w+
		//expresion regular codigo postal: \d{5}
		//expresion regular numero telefonos [6789]\d{8}
		
		
		usuarios.add(usuario);
		
	}

	@Override
	public void baja(Usuario usuario) {
		usuarios.remove(usuario);
		
	}

	@Override
	public void modificacion(Usuario usuario) {
		// TODO Auto-generated method stub
		
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
		return usuarios.toArray(new Usuario[usuarios.size()]);
	}

	@Override
	public Usuario obtenerUsuariosPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuariosPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
