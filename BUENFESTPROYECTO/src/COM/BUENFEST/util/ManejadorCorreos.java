package COM.BUENFEST.util;

import java.security.NoSuchProviderException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ManejadorCorreos {

	private Properties props;
	private Session sesion;
	private Transport t;
	private MimeMessage msg;
	
	public ManejadorCorreos() {
		props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.user", "fiestasmxoficial@gmail.com");
		props.setProperty("mail.smtp.auth", "true");
	}
	
	public void enviarCorreo(String destino, String mensaje) throws MessagingException, NoSuchProviderException {
		
		sesion = Session.getDefaultInstance(props);
		
		msg = new MimeMessage(sesion);
		msg.setFrom(new InternetAddress("fiestasmxoficial@gmail.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
		msg.setSubject("Tienes un nuevo correo electrónico");
		
		msg.setText("<h2>"+ mensaje +"</h2>", "UTF-8", "html");
		
		t = sesion.getTransport("smtp");
		t.connect("fiestasmxoficial@gmail.com", "chichic*2014Hask");
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();
		
	}
}
