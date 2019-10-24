package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import models.entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categorias.*;
import models.entities.Excepciones.ColoresIgualesException;
import models.entities.Excepciones.TelaIncompatibleException;

public class PrendaTest {
	private Prenda prenda;
	private Prenda zapatillas;
	private Tipo remeraTipo;
	private Tela algodon;
	private Tela cuero;

	@Before
	public void init() {
		List<Tela> algNylPolYSed = new ArrayList<>();
		algNylPolYSed.add(new Tela("algodon"));
		algNylPolYSed.add(new Tela("nylon"));
		algNylPolYSed.add(new Tela("seda"));
		algNylPolYSed.add(new Tela("poliester"));
		remeraTipo = new Tipo("Remera",new SuperiorBase(),algNylPolYSed,0,10);
		cuero = new Tela("Cuero");
		algodon = new Tela("Algodon");
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
		Assert.assertEquals("No eran zapatillas de calzado", (new Calzado()).getClass(), zapatillas.getTipo().getCategoria().getClass());
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