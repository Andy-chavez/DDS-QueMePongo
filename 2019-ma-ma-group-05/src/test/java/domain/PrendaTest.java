package domain;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Prenda;
import domain.Tela;
import domain.Tipos.*;
public class PrendaTest {
	private Prenda prenda;
	private Zapatillas tipo;
	
	@Before
	public void init() {
		tipo = new Zapatillas();
		
		//tipo.setCategoria(Categoria.CALZADO);
		//tipo.setNombre("Zapatillas");
		tipo.establecerTela(Tela.CUERO);
		
		//prenda.setColorPrimario(Color.black);
		//prenda.setTipo(tipo);
		
		prenda = new Prenda(tipo,Color.black);
	}
	
	@Test
	public void sonZapatillas() {
		Assert.assertEquals("No eran zapatillas", "Zapatillas", prenda.getTipo().getNombre());
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