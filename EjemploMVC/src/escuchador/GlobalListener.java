package escuchador;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.ejemplocapas.entidades.Producto;

/**
 * Application Lifecycle Listener implementation class GlobalListener
 *
 */
@WebListener
public class GlobalListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public GlobalListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent HttpSE)  { 
         // TODO Auto-generated method stub
    	ArrayList<Producto> carrito = new ArrayList<Producto>();

		HttpSE.getSession().setAttribute("carrito", carrito);
    	
  
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
