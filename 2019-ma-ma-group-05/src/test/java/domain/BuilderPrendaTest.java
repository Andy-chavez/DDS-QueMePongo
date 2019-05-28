package domain;

import org.junit.Assert;
import org.junit.Test;

import domain.BuilderPrenda;
import domain.BuilderTipos;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.ValidacionException;
import domain.Tipos.*;

import org.junit.Before;
import java.awt.Color;


	public class BuilderPrendaTest {
	private BuilderPrenda builderDePrenda;
	private Remera familiaRemeras;
	private Tipo tipoDeRemera;
	
	@Before
	public void init() {
		builderDePrenda = new BuilderPrenda();
		familiaRemeras = new Remera();
		tipoDeRemera = new BuilderTipos().empezarCreacion()
										 .setFabricaTipos(familiaRemeras)
										 .setTela(Tela.ALGODON)
										 .crearTipo();
	}
	
	@Test
	public void remeraRojaQueEsValida() {
		Prenda remeraRoja = builderDePrenda.empezarCreacion()
					 .setTipoAUtilizar(familiaRemeras)
					 .crearTipoConTelaYCategoria(Tela.ALGODON)
					 .setColorPrimario(Color.red)
					 .setColorSecundarioOpcional(null)
					 .crearPrenda();
		Assert.assertNotNull(remeraRoja);
		Assert.assertTrue(remeraRoja.todosLosAtributosSonIgualesA(tipoDeRemera, Color.red, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void remeraAzulDeCueroInvalida() {
		Prenda remeraAzul = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(familiaRemeras)
				 .crearTipoConTelaYCategoria(Tela.CUERO)
				 .setColorPrimario(Color.blue)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();
	}
	
	@Test (expected = ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		Prenda remeraVerde = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(familiaRemeras)
				 .crearTipoConTelaYCategoria(Tela.ALGODON)
				 .setColorPrimario(Color.green)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();
	}
	
	@Test(expected = ValidacionException.class)
	public void remeraSinColorPrimario() {
		Prenda remeraSinColorPrimario = builderDePrenda.empezarCreacion()
													   .setTipoAUtilizar(familiaRemeras)
													   .crearTipoConTelaYCategoria(Tela.ALGODON)
													   .setColorSecundarioOpcional(Color.black)
													   .crearPrenda();
		
	}
}