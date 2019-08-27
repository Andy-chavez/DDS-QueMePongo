package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import domain.Usuario;

public class WppSender {
	//No me parece mala idea leer estos datos del properties y el numero de twilio tmb
    private String ACCOUNT_SID;// = "ACe7e5de9db047d602c38b5540708a7dae";
    private String AUTH_TOKEN;// = "9dafb932843d8ad753aef04f40518d62";
    private String TWILIO;// = "+12035909054";
    public WppSender() {
    	this.configurar();
    }
    public void configurar(){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	this.ACCOUNT_SID= archivoDeConfiguraciones.getProperty("twilioAcc");
    	this.AUTH_TOKEN=archivoDeConfiguraciones.getProperty("twilioToken");
    	this.TWILIO=archivoDeConfiguraciones.getProperty("twilioNumWpp");
    }
    
    public void enviar(Usuario usuario,String mensaje) {
    //public void enviar(String mensaje, Usuario usuario) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator( /*(from, to, menssage) */
                //new com.twilio.type.PhoneNumber("+5491173612330"), //aca va el numero del usuario, dejo temporalmente eso asi voy viendo si puedo mandar un wpp
                new com.twilio.type.PhoneNumber("whatsapp:"+usuario.getCelular()),
                new com.twilio.type.PhoneNumber(TWILIO),
                mensaje)
            .create();

        System.out.println(message.getSid());
    }
}
