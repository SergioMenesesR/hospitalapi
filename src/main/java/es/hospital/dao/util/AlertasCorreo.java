package es.hospital.dao.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class AlertasCorreo {
	public static String USER_NAME = "tfggs2018hospital@gmail.com";
	public static String PASSWORD = "atfgWsuscribeteS!";
	public static String SUBJECT_NEW = "Bienvenido a hospital.es";
	public static String SUBJECT_NEW_ANALISIS = "Nuevo analisis";
	public static String SUBJECT_NEW_CONSULTA = "Nueva consulta";

	public void sendEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", USER_NAME);
		props.put("mail.smtp.password", PASSWORD);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		});

		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(USER_NAME));
			/*InternetAddress toAddress = new InternetAddress(to);
			
			message.addRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, USER_NAME, PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();*/
			
			message.setFrom(new InternetAddress(USER_NAME));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
			
			System.out.println("Done");
		} catch (AddressException ae) {
			System.out.println("Fallo address");
			ae.printStackTrace();
		} catch (MessagingException me) {
			System.out.println("Otro Fallo address");
			me.printStackTrace();
		}
	}
}
