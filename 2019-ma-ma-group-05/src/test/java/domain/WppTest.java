package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WppTest {
	
	private WppSender wp = new WppSender();
	
	@Test
	public void seEnvio() {
		wp.enviar("hola, como va?");
	}
}
