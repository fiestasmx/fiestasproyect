package COM.BUENFEST;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import COM.BUENFEST.Modelo.Cuenta;


/**
 * Servlet implementation class SERVLET
 */
public class SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger("Servlet: ");
	private DataSource ds;
	private Connection con;
	private String rutaJsp;
	
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
		BasicConfigurator.configure();
		
		try 
		
		{
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/BuenFestJDBC");
		}
		catch (NamingException e) {
			log.error("Al configurar JNDI: " + e.getMessage());
		}
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
			setRespuestaControlador("login").forward(request, response);
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
HttpSession sesion = request.getSession();	

try {
	con = ds.getConnection();
}
catch (SQLException e) {
	// Enviar a una vista de error
	log.error("Error al crear conexion: " + e.getMessage());
}

		if (accion != null) {
			
			if (accion.equals("iniciarSesion")) {
				
				String usuario = request.getParameter("usuario");
				String contrasena = request.getParameter("contrasena");
			    
				Cuenta cuenta = new Cuenta(con);
				
				if (cuenta.login(usuario, contrasena)) {
					log.info("Ingresado correctamente como: " + usuario);
					sesion.setAttribute("email", usuario);
					setRespuestaControlador("index").forward(request, response);
				}
				else {
					log.error("Error de login");
					request.setAttribute("error", "Nombre de usuario o contraseña incorrectos.");
					setRespuestaControlador("login").forward(request, response);
				}
				/*
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
				*/
			}
			
			
		}
		else { //index Vista incial
			setRespuestaControlador("login").forward(request, response);
			//getServletContext().getRequestDispatcher(rutaJsp + "index.jsp").forward(request, response);
		}
		//JVV prueba de Maquina
		
		
		try {
			con.close();
		}
		catch (SQLException e) {
			// Enviar a una vista de error
			log.error("Error al cerrar conexion: " + e.getMessage());
		}
		
	}
 
}
