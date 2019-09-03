package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import domain.ConfigReader;
import domain.CronGenerarSugerencia;
import domain.GestorSugerencia;
import domain.Sender;
import domain.Usuario;
import dtoClases.SenderDto;

public class WppSender extends Sender{
	//No me parece mala idea leer estos datos del properties y el numero de twilio tmb
    private String ACCOUNT_SID;// = "ACe7e5de9db047d602c38b5540708a7dae";
    private String AUTH_TOKEN;// = "9dafb932843d8ad753aef04f40518d62";
    private String TWILIO;// = "+12035909054";

    private static WppSender singleInstance = null;
 
	public static WppSender getInstance(){
		if(singleInstance == null){
			singleInstance = new WppSender();
		}
		return singleInstance;
	}
    
    public WppSender() {
    	this.configurar();
    }
    protected void configurar(){
    	ConfigReader.getStringValue("twilioAcc", ACCOUNT_SID);
    	ConfigReader.getStringValue("twilioToken", AUTH_TOKEN);
    	ConfigReader.getStringValue("twilioNumWpp", TWILIO);
    }
    
    public void enviar(SenderDto dto) {
    //public void enviar(String mensaje, Usuario usuario) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator( /*(from, to, menssage) */
                //new com.twilio.type.PhoneNumber("+5491173612330"), //aca va el numero del usuario, dejo temporalmente eso asi voy viendo si puedo mandar un wpp
                new com.twilio.type.PhoneNumber("whatsapp:"+dto.celular),
                new com.twilio.type.PhoneNumber(TWILIO),
                dto.mensaje)
            .create();

        System.out.println(message.getSid());
    }
}
