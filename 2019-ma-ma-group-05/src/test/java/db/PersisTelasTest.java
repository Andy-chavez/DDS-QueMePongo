package db;

import models.repositorios.RepositorioTela;
import org.junit.Test;

public class PersisTelasTest {
    @Test
    public void persistirTelas(){
		RepositorioTela.getInstance().iniciarBase();
    }
}
