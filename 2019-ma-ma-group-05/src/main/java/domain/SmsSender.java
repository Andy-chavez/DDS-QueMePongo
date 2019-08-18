package domain;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
	    // Find your Account Sid and Token at twilio.com/console
	    // DANGER! This is insecure. See http://twil.io/secure
	    public static final String ACCOUNT_SID = "ACe7e5de9db047d602c38b5540708a7dae";
	    public static final String AUTH_TOKEN = "9dafb932843d8ad753aef04f40518d62";

	    public void enviar(String mensaje) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator( /*(from, to, menssage) */
	                new com.twilio.type.PhoneNumber("+541173612330"), //aca va el numero del usuario, dejo temporalmente eso asi voy viendo si puedo mandar un wpp
	                new com.twilio.type.PhoneNumber("+12035909054"),
	                mensaje)
	            .create();

	        System.out.println(message.getSid());
	    }
}
