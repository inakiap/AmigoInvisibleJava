package AI;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	private static String fromEmail = "inakiap@gmail.com";
	private static String password = "tehurebambole";
	
	public static void EnvioEmail(String toEmail, String subject, String body) {
		sslEnviarEmail(toEmail, subject, body);
	}
	
	
	private static boolean sendEmail(Session session, String toEmail, String subject, String body){
		
		boolean respuesta = true;
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress(fromEmail, "No contestad a este correo"));
	      msg.setReplyTo(InternetAddress.parse(fromEmail, false));
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setSentDate(new Date());
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Mensaje preparado...");
    	  Transport.send(msg);  
	      System.out.println("EMail enviado!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("NO enviado a " + toEmail);
	      respuesta = false;
	    }
		return respuesta;
	}
	
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	private static boolean sslEnviarEmail(String toEmail, String subject, String body) {
		System.out.println("EnviarEmail");
		boolean respuesta= false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		//System.out.println("Session created");
	    respuesta = sendEmail(session, toEmail, subject, body);
	    return respuesta;
	}
	
	
}
