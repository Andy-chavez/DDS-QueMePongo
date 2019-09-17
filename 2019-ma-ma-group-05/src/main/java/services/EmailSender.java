package services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import domain.ConfigReader;
import domain.Sender;
import dtoClases.SenderDto;

public class EmailSender extends Sender{
	static Properties props = new Properties();  
	private String emisor;
	private String contraDeEmisor;
    public EmailSender(){
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");
          this.configurar();
    }
    private static EmailSender singleInstance = null;
	public static EmailSender getInstance(){
		if(singleInstance == null){
			singleInstance = new EmailSender();
		}
		return singleInstance;
	}
    protected void configurar(){
    	String nombreConfig="configuraciones.properties";
    	this.emisor=ConfigReader.getStringValue(nombreConfig, "mailEmisor");
    	this.contraDeEmisor=ConfigReader.getStringValue(nombreConfig, "contraEmisor");
    }
    public void enviar(SenderDto dto){ 
    	this.configurar();
    	//get Session   
    	Session session = Session.getInstance(props,    
    			new javax.mail.Authenticator() {    
    		protected PasswordAuthentication getPasswordAuthentication() {    
    			return new PasswordAuthentication(emisor,contraDeEmisor);  
    		}    
    	});    
    	//compose message    
    	try {    
    		MimeMessage message = new MimeMessage(session);    
    		message.addRecipient(Message.RecipientType.TO,new InternetAddress(dto.mail));    
    		message.setSubject(dto.asunto);    
    		message.setText(dto.mensaje);      
    		Transport.send(message); //send message        
    	} catch (MessagingException e) {throw new RuntimeException(e);}    

    }  
}
