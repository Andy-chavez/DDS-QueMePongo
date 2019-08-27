package services;

import org.junit.Before;
import org.junit.Test;

import domain.Usuario;

public class SmsWppYEmailTest { //es super precario, ya se, pero dps va a ir mejorando(?
	
	private SmsSender sms = new SmsSender();
	private WppSender wpp = new WppSender();
	private EmailSender email = new EmailSender();
	private Usuario usuario = new Usuario("peter");
	@Before
	public void init(){
		usuario.setCelular("+541173612330");
		usuario.setMail("andychavez02@gmail.com");
	}
	@Test
	public void seEnvioSms() {
		sms.configurar();
		sms.enviar(usuario,"Hola! Cómo va? Este es un sms");
	}
	@Test
	public void seEnvioWpp() {
		wpp.configurar();
		wpp.enviar(usuario,"Hola! Cómo va? Este es un wpp");
	}
	@Test
	public void seEnvioEmail() { //aca temporalmente van a tener que creer ciegamente que funciona, pero dps nos hacemos un mail y lo usamos
		email.enviar(usuario,"Buenas","Intento Mail Funciona");
	}
}
