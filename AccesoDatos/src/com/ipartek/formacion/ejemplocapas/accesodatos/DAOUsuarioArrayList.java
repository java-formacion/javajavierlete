package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioArrayList implements DAOUsuarios {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public void alta(Usuario usuario) {
		usuarios.add(usuario);

	}

	@Override
	public void baja(Usuario usuario) {
		usuarios.remove(usuario);

	}

	@Override
	public void modificacion(Usuario usuario) {
		Usuario u;

		for (int i = 0; i < usuarios.size(); i++) {
			u = usuarios.get(i);

			if (u.getId() == usuario.getId()) {
				u.setApellido(usuario.getApellido());
				u.setDNI(usuario.getDNI());
				u.setEmail(usuario.getEmail());
				u.setNombre(usuario.getNombre());
				u.setPassword(usuario.getPassword());
			}
		}

	}

	@Override
	public Usuario[] obtenerUsuarios() {
		return (Usuario[]) usuarios.toArray();

	}

	@Override
	public Usuario obtenerUsuarioPorId(long id) {
		for (Usuario u : usuarios)
			if (id == u.getId())
				return u;
		
		return null;
		
		
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return null;
	}

}
