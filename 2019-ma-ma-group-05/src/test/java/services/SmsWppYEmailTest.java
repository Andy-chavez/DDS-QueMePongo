package services;

import org.junit.Before;
import org.junit.Test;

import dtoClases.SenderDto;
import entities.Usuario;

public class SmsWppYEmailTest { 
	
	private SmsSender sms = SmsSender.getInstance();
	private WppSender wpp = WppSender.getInstance();
	private EmailSender email = EmailSender.getInstance();
	private Usuario usuario = new Usuario("peter");
	private SenderDto dto = new SenderDto();
	@Before
	public void init(){
		usuario.setCelular("+541173612330");
		usuario.setMail("andychavez02@gmail.com");
		dto.asunto = "¿Que me pongo?";
		dto.celular = usuario.getCelular();
		dto.mail = "andychavez02@gmail.com";
		dto.mensaje = "Este es un mensaje de la app del grupo 5";
	}
	@Test
	public void seEnvioSms() {
		sms.enviar(dto);
	}
	@Test
	public void seEnvioWpp() {
		wpp.enviar(dto);
	}
	@Test
	public void seEnvioEmail() { //aca temporalmente van a tener que creer ciegamente que funciona, pero dps nos hacemos un mail y lo usamos
		email.enviar(dto);
	}
}
