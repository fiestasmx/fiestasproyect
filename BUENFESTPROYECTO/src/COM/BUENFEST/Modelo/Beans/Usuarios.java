package COM.BUENFEST.Modelo.Beans;

public class Usuarios {

	
	private int idUsuarios;
	private String email;
	private String contrasena;
	private String nombre;
	private int IdPreguntaSeguridadFK;
	
	
	public Usuarios(String email, String contrasena, String nombre, int idPreguntaSeguridadFK) {
		this.email = email;
		this.contrasena = contrasena;
		this.nombre = nombre;
		IdPreguntaSeguridadFK = idPreguntaSeguridadFK;
	}
	public int getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdPreguntaSeguridadFK() {
		return IdPreguntaSeguridadFK;
	}
	public void setIdPreguntaSeguridadFK(int idPreguntaSeguridadFK) {
		IdPreguntaSeguridadFK = idPreguntaSeguridadFK;
	}
	
	
}
