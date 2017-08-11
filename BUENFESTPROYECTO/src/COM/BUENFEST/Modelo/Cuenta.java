package COM.BUENFEST.Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Cuenta {
	private static final Logger log = LogManager.getLogger("Cuenta: ");
	
	private Connection con;

	public Cuenta(Connection con) {
		this.con = con;
	}

	public boolean login(String email, String contrasena) {
		
		String sql = "select count(*) as count from usuarios where email = ? and contrasena = ?";
		int cta = 0;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, contrasena);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				cta = rs.getInt("count");
			}
			
			rs.close();
		}
		catch (SQLException e) {
			log.error("Al realizar login: " + e.getMessage());
			return false;
		}
		
		if (cta == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
