package server;

import models.domain.CronGenerarSugerencia;
import models.domain.CronNotificarSugerencia;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		CronGenerarSugerencia.getInstance().run();
		CronNotificarSugerencia.getInstance().run();
		Spark.port(9000);
		Router.init();
		DebugScreen.enableDebugScreen();
	}
}
