package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Timer;

import org.junit.Test;

public class CronTest {
//	private Evento evento;
	
	public void init(){
//		evento = new Evento("fiesta", "pacha", LocalDate.now(), "formal");		
	}
	@Test
	public void timerTest(){
		LocalDate tomorrow = LocalDate.parse("2019-10-01");
		LocalDate today = LocalDate.now();
		System.out.println(today.until(tomorrow.minusDays(2), ChronoUnit.DAYS));
		System.out.println(ConfigReader.getIntValue("configuraciones.properties", "diasPreviosDeAviso"));
//		Timer timer = new Timer();
//		Evento evento = new Evento("fiesta", "pacha", LocalDate.now(), "formal");
//		timer.schedule(evento, 3000, 10000);
	}
}