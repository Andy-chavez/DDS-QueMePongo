package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import dtoClases.SenderDto;
import entities.ConfigReader;
import entities.Sender;

public class SmsSender extends Sender {
	    //No me parece mala idea leer estos datos del properties y el numero de twilio tmb
	    private String ACCOUNT_SID;// = "ACe7e5de9db047d602c38b5540708a7dae";
	    private String AUTH_TOKEN;// = "9dafb932843d8ad753aef04f40518d62";
	    private String TWILIO;// = "+12035909054";
	    public SmsSender() {
	    	this.configurar();
	    }
	    private static SmsSender singleInstance = null;

		public static SmsSender getInstance(){
			if(singleInstance == null){
				singleInstance = new SmsSender();
			}
			return singleInstance;
		}
	    protected void configurar(){
	    	this.ACCOUNT_SID = ConfigReader.getStringValue("configuraciones.properties","twilioAcc");
	    	this.AUTH_TOKEN = ConfigReader.getStringValue("configuraciones.properties","twilioToken");
	    	this.TWILIO = ConfigReader.getStringValue("configuraciones.properties","twilioNum");
	    }
	    
	    public void enviar(SenderDto dto) {
	    	this.configurar();
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator( /*(from, to, menssage) */
	                new com.twilio.type.PhoneNumber(dto.celular),
	                new com.twilio.type.PhoneNumber(TWILIO),
	                dto.mensaje)
	            .create();

	        System.out.println(message.getSid());
	    }
}
