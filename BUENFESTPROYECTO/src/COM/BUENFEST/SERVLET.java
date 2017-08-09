package COM.BUENFEST;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class SERVLET
 */
public class SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String rutaJsp;
	private static final Logger log = LogManager.getLogger("Servlet: ");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

     
    
    
    
    //Para Tener la misma ruta mediante el SERVLE
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rutaJsp = config.getInitParameter("rutaJsp");
		System.out.println(rutaJsp);
		//log.info("ruta jsp: " + rutaJsp);
	//Pendiente por cambios JVV
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		if (accion != null) {
			
			if (accion.equals("login")) {
				setRespuestaControlador(accion).forward(request, response);
				//getServletContext().getRequestDispatcher(rutaJsp + "login.jsp").forward(request, response);
			}
			else if (accion.equals("inicio")) {
				setRespuestaControlador("index").forward(request, response);
				//getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
			}
		}
		else {
			setRespuestaControlador("index").forward(request, response);
			//getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
		}
	}

	
	//Metodo para Redirigir las vista
	public RequestDispatcher setRespuestaControlador(String vista){
		String url = rutaJsp + vista + ".jsp";
		return getServletContext().getRequestDispatcher(url);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
String accion = request.getParameter("accion");
		
		if (accion != null) {
			
			if (accion.equals("iniciarSesion")) {
				
				String usuario = request.getParameter("usuario");
				String contrasena = request.getParameter("contrasena");
				
				// Ámbito Request
				request.setAttribute("usuario", usuario);
				request.setAttribute("contrasena", contrasena);
				
				// Ámbito Sesión
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("contrasena", contrasena);
				
				// Ámbito Contexto
				ServletContext contexto = getServletContext();
				contexto.setAttribute("usuario", usuario);
				contexto.setAttribute("contrasena", contrasena);
				
				setRespuestaControlador("postLogin").forward(request, response);
				//getServletContext().getRequestDispatcher(rutaJsp + "postLogin.jsp").forward(request, response);
				
			}
			
			
		}
		else {
			setRespuestaControlador("index").forward(request, response);
			//getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
		}
		//JVV prueba de Maquina
		
	}
 
}
