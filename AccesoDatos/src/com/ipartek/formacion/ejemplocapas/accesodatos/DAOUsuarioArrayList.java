package com.ipartek.formacion.ejemplocapas.accesodatos;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplocapas.entidades.Usuario;

public class DAOUsuarioArrayList implements DAOUsuarios {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public void alta(Usuario usuario) {
		if (obtenerUsuarioPorEmail(usuario.getEmail()) != null)
			throw new AccesoDatosException("Ya existe un usuario con el email " + usuario.getEmail());

		usuarios.add(usuario);

		/**
		 * Expresiones regulares: \w+\@\w+\.\w+ seria para email \d{5} seria para un
		 * numero de 5 digitos \[6789]\d{8}
		 */

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
		if (email == null)
			return null;
		for (Usuario u : usuarios)
			if (u.getEmail() != null && u.getEmail().equals(email))
				return u;
		return null;
	}

}
