package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ColoresIgualesException;
import domain.Tipos.*;
import domain.Excepciones.ValidacionException;

public class PrendaTest {
	private Prenda prenda;
	private Zapatillas tipo;
	private Remera remeraTipo;
	@Before
	public void init() {
		remeraTipo = new Remera();
		remeraTipo.setNombre("remera");
		remeraTipo.setCategoria(Categoria.SUPERIOR);
		remeraTipo.establecerTela(Tela.ALGODON);
		
		tipo = new Zapatillas();
		tipo.establecerTela(Tela.CUERO);
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
		remeraTipo.establecerTela(Tela.CUERO);
		Prenda remeraAzul = new Prenda(remeraTipo,Color.blue,Color.green);
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		remeraTipo.establecerTela(Tela.ALGODON);
		Prenda remeraVerde = new Prenda(remeraTipo,Color.green,Color.green);

	}
	@Test
	public void sonZapatillas() {
		Assert.assertEquals("No eran zapatillas", "zapatillas", prenda.getTipo().getNombre());
	}
	
	@Test
	public void sonCalzadoLosZapatos() {
		Assert.assertEquals("No eran zapatillas de calzado", Categoria.CALZADO, prenda.getTipo().getCategoria());
	}
	
	@Test
	public void sonNegrosLosZapatos() {
		Assert.assertEquals("No eran zapatillas negros", Color.black, prenda.getColorPrimario());
	}
	
	@Test
	public void sonDeCueroLosZapatos() {
		Assert.assertEquals("No eran zapatillas de cuero", Tela.CUERO, prenda.getTipo().getTela());
	}
	
}