package AI;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailSSL {
	
	 public static void envioTest() {

	        final String username = "addmminnn@gmail.com";
	        final String password = "Bambole,77";

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "465");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.socketFactory.port", "465");
	        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("addmminnn@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("inakiap@posteo.net")
	            );
	            message.setSubject("Testing Gmail SSL");
	            message.setText("Dear Mail Crawler,"
	                    + "\n\n Please do not spam my email!");

	            Transport.send(message);

	            System.out.println("Done\n");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public static Boolean sendEmail(String to, String subject, String body) {

	        final String username = "addmminnn@gmail.com";
	        final String password = "Bambole,77";
	        
	        Boolean response = false;

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "465");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.socketFactory.port", "465");
	        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("addmminnn@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(to)
	            );
	            message.setSubject(subject);
	            message.setText(body);

	            Transport.send(message);
	            response = true;

	            System.out.println("Enviado a "+to+"\n");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        return response;
	    }

}
