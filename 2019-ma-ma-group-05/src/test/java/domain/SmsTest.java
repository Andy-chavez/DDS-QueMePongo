package domain;

import org.junit.Test;

public class SmsTest { //es super precario, ya se, pero dps va a ir mejorando(?
	
	private SmsSender wp = new SmsSender();
	
	@Test
	public void seEnvio() {
		wp.enviar("hola, como va?");
	}
}
