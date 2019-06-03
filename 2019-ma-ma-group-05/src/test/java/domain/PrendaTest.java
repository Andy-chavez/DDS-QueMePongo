package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Prenda;
import domain.Tela;

public class PrendaTest {
	private Prenda prenda;
	private Tipo tipo;
	
	@Before
	public void init() {
		prenda = new Prenda();
		tipo = new Tipo();
		
		tipo.setCategoria(Categoria.CALZADO);
		tipo.setNombre("Zapatos");
		tipo.setTela(Tela.CUERO);
		
		prenda.setColorPrimario(Color.black);
		prenda.setTipo(tipo);
	}
	
	@Test
	public void sonZapatos() {
		Assert.assertEquals("No eran zapatos", "Zapatos", prenda.getTipo().getNombre());
	}
	
	@Test
	public void sonCalzadoLosZapatos() {
		Assert.assertEquals("No eran zapatos de calzado", Categoria.CALZADO, prenda.getTipo().getCategoria());
	}
	
	@Test
	public void sonNegrosLosZapatos() {
		Assert.assertEquals("No eran zapatos negros", Color.black, prenda.getColorPrimario());
	}
	
	@Test
	public void sonDeCueroLosZapatos() {
		Assert.assertEquals("No eran zapatos de cuero", Tela.CUERO, prenda.getTipo().getTela());
	}
	
}