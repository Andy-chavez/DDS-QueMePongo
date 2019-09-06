package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categorias.*;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.TelaIncompatibleException;
import domain.Tipos.*;
import domain.Excepciones.ValidacionException;
import domain.Telas.Algodon;
import domain.Telas.Cuero;

public class PrendaTest {
	private Prenda prenda;
	private Prenda zapatillas;
	private Zapatillas tipo;
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
		zapatillas.setColorPrimario(Color.black);
	}
	@Test
	public void remeraRojaQueEsValida() {
		Prenda remeraRoja = SimpleFactoryPrendas.crearPrenda("remera");
		remeraRoja.setColorPrimario(Color.red);
		Assert.assertNotNull(remeraRoja);
		Assert.assertTrue(remeraRoja.todosLosAtributosSonIgualesA(remeraTipo, Color.red, null));
	}
	
	@Test(expected = TelaIncompatibleException.class)
	public void remeraAzulDeCueroInvalida() {
		Prenda remeraAzul = SimpleFactoryPrendas.crearPrenda("remera");
		remeraAzul.setColorPrimario(Color.blue);
		remeraAzul.setColorSecundario(Color.green);
		remeraAzul.setTela(cuero);
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		Prenda remeraVerde = new Prenda(remeraTipo,Color.green,Color.green);
		remeraVerde.setTela(algodon);

	}
	@Test
	public void sonZapatillas() {
		Assert.assertEquals("No eran zapatillas", "zapatillas", zapatillas.getTipo().getNombre());
	}
	
	@Test
	public void sonCalzadoLosZapatos() {
		Assert.assertEquals("No eran zapatillas de calzado", new Calzado().getClass(), zapatillas.getTipo().getCategoria().getClass());
	}
	
	@Test
	public void sonNegrosLosZapatos() {
		Assert.assertEquals("No eran zapatillas negros", Color.black, zapatillas.getColorPrimario());
	}
	
	@Test
	public void sonDeCueroLosZapatos() {
		Assert.assertEquals("No eran zapatillas de cuero", cuero.getNombre(), zapatillas.getTela().getNombre());
	}
	
}