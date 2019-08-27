package services;

import org.junit.Test;

public class SmsYWppTest { //es super precario, ya se, pero dps va a ir mejorando(?
	
	private SmsSender sms = new SmsSender();
	private WppSender wpp = new WppSender();
	private EmailSender email = new EmailSender();
	@Test
	public void seEnvioSms() {
		sms.configurar();
		sms.enviar("Hola! Cómo va? Este es un sms");
	}
	@Test
	public void seEnvioWpp() {
		wpp.configurar();
		wpp.enviar("Hola! Cómo va? Este es un wpp");
	}
	@Test
	public void seEnvioEmail() { //aca temporalmente van a tener que creer ciegamente que funciona, pero dps nos hacemos un mail y lo usamos
		email.enviar("xxxxx@gmail.com","contraXXXXX","andychavez02@gmail.com","Buenas","Intento Funciona");
	}
}
