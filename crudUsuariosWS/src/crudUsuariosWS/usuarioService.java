package crudUsuariosWS;

import java.util.ArrayList;

import org.apache.catalina.startup.CredentialHandlerRuleSet;

public class usuarioService {
	
	private String url="jdbc:sqlite:C:\\sqliteCRUDUsuariosWS\\crudUsuariosWS.db";
	private String user="";
	private String password="";
	
	Daousuario daou = new Daousuario(url, user, password);
	
	
	
	public void insertarUsuario(Usuario usuario) {
		
	try {
		daou.insertarUsuario(usuario);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
	
	
	public Usuario[] mostrarUsuarios() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			//usuarios = daou.mostrarUsuarios();
			return usuarios.toArray(new Usuario[usuarios.size()]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void eliminarUsuario(Usuario usuario) {
		
		try {
			daou.borrarUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void modificarUsuario(Usuario usuario) {
		
		try {
			daou.modificarUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
