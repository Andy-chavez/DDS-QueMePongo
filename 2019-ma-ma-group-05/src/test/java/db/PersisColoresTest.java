package db;

import models.repositorios.RepositorioColor;
import org.junit.Test;

public class PersisColoresTest {

    @Test
    public void PersistoColoresBase(){
        RepositorioColor.getInstance().iniciarBase();
    }
}
