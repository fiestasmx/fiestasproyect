package COM.BUENFEST.util;

import java.security.NoSuchProviderException;

import javax.mail.MessagingException;

public class TestManejadorCorreos {

	
public static void main(String[] args) {
		
		ManejadorCorreos manejadorCorreos = new ManejadorCorreos();
		try {
			manejadorCorreos.enviarCorreo("jvelazquez@inteek.mx", "Prueba de env�o de correo electr�nico");
			System.out.println("correo enviado");
		}
		catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
