package Constructs;

import java.util.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	
	public void sendUsingTLS() {
		// Recipient's email ID needs to be mentioned.
		String to = "anthony.c.chan@accenture.com";

		// Sender's email ID needs to be mentioned
		String from = "anthonycchan@gmail.com";

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		final String username = "anthonycchan@gmail.com";
		final String password = "@WSXVFR4";
		
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "587");
		
		
		// Get the default Session object.
		Session session = Session.getInstance(properties, 
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
					} });

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
//
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public void sendUsingSSL() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("anthonycchan@gmail.com","!QAZCDE3");
				}
			});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("anthonycchan@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("anthony.c.chan@accenture.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Session authenticate() {
		// Assuming you are sending email from gmail
		String host = "smtp.gmail.com";

		final String username = "anthonycchan@gmail.com";
		final String password = "!QAZCDE3";
		
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "587");
		
		
		// Get the default Session object.
		Session session = Session.getInstance(properties, 
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
					} });
		
		return session;
	}
	
	public void sendAttachment(String filename) {
		Session session = authenticate();
		
		// Recipient's email ID needs to be mentioned.
		String to = "anthony.c.chan@accenture.com";

		// Sender's email ID needs to be mentioned
		String from = "anthonycchan@gmail.com";
		
	      try {
	          // Create a default MimeMessage object.
	          MimeMessage message = new MimeMessage(session);

	          // Set From: header field of the header.
	          message.setFrom(new InternetAddress(from));

	          // Set To: header field of the header.
	          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

	          // Set Subject: header field
	          message.setSubject("This is the Subject Line!");

	          // Create the message part 
	          BodyPart messageBodyPart = new MimeBodyPart();

	          // Fill the message
	          messageBodyPart.setText("This is message body");
	          
	          // Create a multipart message
	          Multipart multipart = new MimeMultipart();

	          // Set text message part
	          multipart.addBodyPart(messageBodyPart);

	          // Part two is attachment
	          messageBodyPart = new MimeBodyPart();
	          DataSource source = new FileDataSource(filename);
	          messageBodyPart.setDataHandler(new DataHandler(source));
	          messageBodyPart.setFileName(filename);
	          multipart.addBodyPart(messageBodyPart);

	          // Send the complete message parts
	          message.setContent(multipart );

	          // Send message
	          Transport.send(message);
	          System.out.println("Sent message successfully....");
	       }catch (MessagingException mex) {
	          mex.printStackTrace();
	       }
	}
	
	public static void main(String[] args) {
		SendEmail sm = new SendEmail();
		
//		sm.sendUsingTLS();
//		sendUsingSSL();
		
		sm.sendAttachment("C:\\output\\addVariable.txt");
	}	
}
