package domain;

import org.junit.Test;

public class SmsTest { //es super precario, ya se, pero dps va a ir mejorando(?
	
	private SmsSender sms = new SmsSender();
	
	@Test
	public void seEnvio() {
		sms.configurar();
		sms.enviar("Hola! Cómo va?");
	}
}
