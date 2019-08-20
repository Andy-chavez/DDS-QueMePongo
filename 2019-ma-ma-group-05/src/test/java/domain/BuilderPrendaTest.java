package domain;

import org.junit.Assert;
import org.junit.Test;

import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.ValidacionException;
import domain.Tipos.*;

import org.junit.Before;
import java.awt.Color;

	public class BuilderPrendaTest {
	private Remera remeraTipo;
	
	@Before
	public void init() {
		remeraTipo = new Remera();
		remeraTipo.setNombre("remera");
		remeraTipo.setCategoria(Categoria.SUPERIOR);
		remeraTipo.establecerTela(Tela.ALGODON);
	}
	
	@Test
	public void remeraRojaQueEsValida() {
		/*Prenda remeraRoja = builderDePrenda.empezarCreacion()
					 .setTipoAUtilizar(remeraTipo)
					 .setearTelaATipo(Tela.ALGODON)
					 .setColorPrimario(Color.red)
					 //.setColorSecundarioOpcional(null)
					 .crearPrenda();*/
		Prenda remeraRoja = new Prenda(remeraTipo,Color.red);
		Assert.assertNotNull(remeraRoja);
		Assert.assertTrue(remeraRoja.todosLosAtributosSonIgualesA(remeraTipo, Color.red, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void remeraAzulDeCueroInvalida() {
		remeraTipo.establecerTela(Tela.CUERO);
		Prenda remeraAzul = new Prenda(remeraTipo,Color.blue,Color.green);
		/*Prenda remeraAzul = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(remeraTipo)
				 .setearTelaATipo(Tela.CUERO)
				 .setColorPrimario(Color.blue)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();*/
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		remeraTipo.establecerTela(Tela.ALGODON);
		Prenda remeraVerde = new Prenda(remeraTipo,Color.green,Color.green);
		/*Prenda remeraVerde = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(remeraTipo)
				 .setearTelaATipo(Tela.ALGODON)
				 .setColorPrimario(Color.green)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();*/
	}

}