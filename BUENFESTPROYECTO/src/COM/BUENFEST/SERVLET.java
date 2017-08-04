package COM.BUENFEST;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SERVLET
 */
public class SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String rutaJsp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

     
    
    
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rutaJsp = config.getInitParameter("rutaJsp");
		System.out.println(rutaJsp);
		
	}






	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		if (accion != null) {
			
			if (accion.equals("login")) {
				getServletContext().getRequestDispatcher(rutaJsp + "login.jsp").forward(request, response);
			}
			else if (accion.equals("inicio")) {
				getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
			}
		}
		else {
			getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
		}
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
				
				getServletContext().getRequestDispatcher(rutaJsp + "postLogin.jsp").forward(request, response);
				
			}
			
			
		}
		else {
			getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
		}
		//JVV prueba de Maquina
		
	}
 
}
