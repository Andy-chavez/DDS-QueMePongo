package domain;

import org.junit.Test;

public class SmsYWppTest { //es super precario, ya se, pero dps va a ir mejorando(?
	
	private SmsSender sms = new SmsSender();
	private WppSender wpp = new WppSender();
	@Test
	public void seEnvioSms() {
		sms.configurar();
		sms.enviar("Hola! Cómo va? Este es un sms");
	}
	@Test
	public void seEnvioWpp() { //aca habria que preguntar porque solo puede enviarse un wpp si se unen al sandbox de Twilio, eso es valido?
		wpp.configurar();
		wpp.enviar("Hola! Cómo va? Este es un wpp");
	}
}
