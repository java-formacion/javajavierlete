package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioArrayList  implements DAOUusuario{

private ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	
	@Override
	public void alta(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void baja(Usuario usuario) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
