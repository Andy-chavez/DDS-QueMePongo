package domain;

import org.junit.Assert;
import org.junit.Test;

import domain.C_BuilderPrenda;
import domain.C_BuilderTipos;
import domain.C_ColoresIgualesException;
import domain.C_Prenda;
import domain.Tela;
import domain.C_ValidacionException;
import domain.C_Tipos.*;

import org.junit.Before;
import java.awt.Color;


public class C_BuilderPrendaTest {
	private C_BuilderPrenda builderDePrenda;
	private Remera familiaRemeras;
	private Tipo tipoDeRemera;
	
	@Before
	public void init() {
		builderDePrenda = new C_BuilderPrenda();
		familiaRemeras = new Remera();
		tipoDeRemera = new C_BuilderTipos().empezarCreacion()
										 .setFabricaTipos(familiaRemeras)
										 .setTela(Tela.ALGODON)
										 .crearTipo();
	}
	
	@Test
	public void remeraRojaQueEsValida() {
		C_Prenda remeraRoja = builderDePrenda.empezarCreacion()
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
		C_Prenda remeraAzul = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(familiaRemeras)
				 .crearTipoConTelaYCategoria(Tela.CUERO)
				 .setColorPrimario(Color.blue)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();
	}
	
	@Test (expected = C_ColoresIgualesException.class) 
	public void remeraDeVerdeVerdeInvalida() {
		C_Prenda remeraVerde = builderDePrenda.empezarCreacion()
				 .setTipoAUtilizar(familiaRemeras)
				 .crearTipoConTelaYCategoria(Tela.ALGODON)
				 .setColorPrimario(Color.green)
				 .setColorSecundarioOpcional(Color.green)
				 .crearPrenda();
	}
	
	@Test(expected = C_ValidacionException.class)
	public void remeraSinColorPrimario() {
		C_Prenda remeraSinColorPrimario = builderDePrenda.empezarCreacion()
													   .setTipoAUtilizar(familiaRemeras)
													   .crearTipoConTelaYCategoria(Tela.ALGODON)
													   .setColorSecundarioOpcional(Color.black)
													   .crearPrenda();
		
	}
}