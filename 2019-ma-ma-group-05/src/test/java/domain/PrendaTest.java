package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.ColorPersistible;
import models.entities.Prenda;
import models.entities.SimpleFactoryPrendas;
import models.entities.Tela;
import models.entities.Categorias.*;
import models.entities.Excepciones.ColoresIgualesException;
import models.entities.Excepciones.TelaIncompatibleException;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Tipos.*;

public class PrendaTest {
	private Prenda prenda;
	private Prenda zapatillas;
	private Remera remeraTipo;
	private Tela algodon;
	private Tela cuero;
	@Before
	public void init() {
		cuero = new Cuero();
		algodon = new Algodon();
		prenda = SimpleFactoryPrendas.crearPrenda("remera");
		prenda.setTela(algodon);
		
		zapatillas  = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setTela(cuero);
		zapatillas.setColorPrimario(ColorPersistible.black);
	}
	@Test
	public void remeraRojaQueEsValida() {
		Prenda remeraRoja = SimpleFactoryPrendas.crearPrenda("remera");
		remeraRoja.setColorPrimario(ColorPersistible.red);
		Assert.assertNotNull(remeraRoja);
		Assert.assertTrue(remeraRoja.todosLosAtributosSonIgualesA(remeraTipo, ColorPersistible.red, null));
	}
	
	@Test(expected = TelaIncompatibleException.class)
	public void remeraAzulDeCueroInvalida() {
		Prenda remeraAzul = SimpleFactoryPrendas.crearPrenda("remera");
		remeraAzul.setColorPrimario(ColorPersistible.blue);
		remeraAzul.setColorSecundario(ColorPersistible.green);
		remeraAzul.setTela(cuero);
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		Prenda remeraVerde = new Prenda(remeraTipo,ColorPersistible.green,ColorPersistible.green);
		remeraVerde.setTela(algodon);

	}
	@Test
	public void sonZapatillas() {
		Assert.assertEquals("No eran zapatillas", "zapatillas", zapatillas.getTipo().getNombre());
	}
	
	@Test
	public void sonCalzadoLosZapatos() {
		Assert.assertEquals("No eran zapatillas de calzado", Calzado.getInstance().getClass(), zapatillas.getTipo().getCategoria().getClass());
	}
	
	@Test
	public void sonNegrosLosZapatos() {
		Assert.assertEquals("No eran zapatillas negros", ColorPersistible.black, zapatillas.getColorPrimario());
	}
	
	@Test
	public void sonDeCueroLosZapatos() {
		Assert.assertEquals("No eran zapatillas de cuero", cuero.getNombre(), zapatillas.getTela().getNombre());
	}
	
}