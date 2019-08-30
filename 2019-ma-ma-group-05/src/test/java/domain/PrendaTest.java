package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categorias.*;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ColoresIgualesException;
import domain.Tipos.*;
import domain.Excepciones.ValidacionException;
import domain.Telas.Algodon;
import domain.Telas.Cuero;

public class PrendaTest {
	private Prenda prenda;
	private Zapatillas tipo;
	private Remera remeraTipo;
	private Tela algodon;
	private Tela cuero;
	@Before
	public void init() {
		cuero = new Cuero();
		algodon = new Algodon();
		remeraTipo = new Remera();
		remeraTipo.establecerTela(algodon);
		
		tipo = new Zapatillas();
		tipo.establecerTela(cuero);
		prenda = new Prenda(tipo,Color.black);
	}
	@Test
	public void remeraRojaQueEsValida() {
		Prenda remeraRoja = new Prenda(remeraTipo,Color.red);
		Assert.assertNotNull(remeraRoja);
		Assert.assertTrue(remeraRoja.todosLosAtributosSonIgualesA(remeraTipo, Color.red, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void remeraAzulDeCueroInvalida() {
		remeraTipo.establecerTela(cuero);
		Prenda remeraAzul = new Prenda(remeraTipo,Color.blue,Color.green);
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		remeraTipo.establecerTela(algodon);
		Prenda remeraVerde = new Prenda(remeraTipo,Color.green,Color.green);

	}
	@Test
	public void sonZapatillas() {
		Assert.assertEquals("No eran zapatillas", "zapatillas", prenda.getTipo().getNombre());
	}
	
	@Test
	public void sonCalzadoLosZapatos() {
		Assert.assertEquals("No eran zapatillas de calzado", new Calzado().getClass(), prenda.getTipo().getCategoria().getClass());
	}
	
	@Test
	public void sonNegrosLosZapatos() {
		Assert.assertEquals("No eran zapatillas negros", Color.black, prenda.getColorPrimario());
	}
	
	@Test
	public void sonDeCueroLosZapatos() {
		Assert.assertEquals("No eran zapatillas de cuero", cuero.getNombre(), prenda.getTipo().getTela().getNombre());
	}
	
}