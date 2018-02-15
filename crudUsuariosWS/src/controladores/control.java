package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudUsuariosWS.Daousuario;
import crudUsuariosWS.Usuario;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String url="jdbc:sqlite:C:\\sqliteCRUDUsuariosWS\\crudUsuariosWS.db";
	private final String user="";
	private final String password="";
    public control() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//insertarUsuario();
	
		Usuario[] usuarios = mostrarUsuarios();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("WEB-INF/Index.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	public void insertarUsuario() {
		
	Usuario u1 = new Usuario(0, "Borja", "Gonzalez", "borja@email.com", 123456789);
	//Usuario u2 = new Usuario(0, "Monkey D", "Luffy", "luffy@email.com", 987654321);
	Daousuario daouser = new Daousuario(url, user, password);
	
	try {
		daouser.insertarUsuario(u1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public Usuario[] mostrarUsuarios() {
		
		Daousuario daouser = new Daousuario(url, user, password);
		
		Usuario[]usuarios = null;
		try {
			usuarios = daouser.mostrarUsuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
		
	}
	
	public void borrarUsuario() {
		

		
		Daousuario daouser = new Daousuario(url, user, password);
		Usuario u = new Usuario(9, "", "","", 123214);
		
		try {
			daouser.borrarUsuario(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
