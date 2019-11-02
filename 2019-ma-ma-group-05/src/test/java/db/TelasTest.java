package db;

import models.repositorios.RepositorioTela;
import org.junit.Before;
import org.junit.Test;

import models.entities.Tela;

public class TelasTest {
	Tela algodon;
	Tela gabardina;
	
	@Before
	public void init(){
		algodon = new Tela("algodon");
		gabardina = new Tela("gabardina");

	}
    @Test
    public void persistirTelas(){
        RepositorioTela.getInstance().agregar(algodon);

        RepositorioTela.getInstance().agregar(gabardina);
    }
}
