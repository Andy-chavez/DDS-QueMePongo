package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.BuilderTipos;
import domain.Categoria;
import domain.Tela;
import domain.Tipos.*;

public class BuilderTipoTest {
	private BuilderTipos builderDeTipo;
	private Remera familiaRemeras;
	private Pantalon familiaPantalones;
	private Ojotas familiaOjotas;
	private Reloj familiaRelojes;
	
	@Before
	public void init() {
		builderDeTipo = new BuilderTipos();
		familiaRemeras = new Remera();
		familiaPantalones = new Pantalon();
		familiaOjotas = new Ojotas();
		familiaRelojes = new Reloj();
	}
	
	@Test
	public void creacionRemeraAlgodonValida() {
		Tipo remeraAlgodon = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaRemeras)
				.setTela(Tela.ALGODON)
				.crearTipo();
		Assert.assertTrue(remeraAlgodon.todosLosAtributosDeTipoSonIgualesA(Tela.ALGODON, "remera", Categoria.SUPERIOR));
	}
	
	@Test
	public void creacionPantalonNylonValida() {
		Tipo pantalonNylon = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaPantalones)
				.setTela(Tela.NYLON)
				.crearTipo();
		Assert.assertEquals(Tela.NYLON, pantalonNylon.getTela());
		Assert.assertEquals("pantalon", pantalonNylon.getNombre());
		Assert.assertEquals(Categoria.INFERIOR, pantalonNylon.getCategoria());
	}	
	
	@Test
	public void creacionOjotasCueroValida() {
		Tipo ojotasCuero = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaOjotas)
				.setTela(Tela.CUERO)
				.crearTipo();
		Assert.assertEquals(Tela.CUERO, ojotasCuero.getTela());
		Assert.assertEquals("ojotas", ojotasCuero.getNombre());
		Assert.assertEquals(Categoria.CALZADO, ojotasCuero.getCategoria());
	}
	
	@Test
	public void creacionRelojOtroValida() {
		Tipo relojOtro = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaRelojes)
				.setTela(Tela.OTRO)
				.crearTipo();
		Assert.assertEquals(Tela.OTRO, relojOtro.getTela());
		Assert.assertEquals("reloj", relojOtro.getNombre());
		Assert.assertEquals(Categoria.ACCESORIO, relojOtro.getCategoria());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void creacionRemeraCuero() {
		Tipo remeraAlgodon = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaRemeras)
				.setTela(Tela.CUERO)
				.crearTipo();
	}
	
	@Test(expected = NullPointerException.class)
	public void creacionRelojSinTipo() {
		Tipo relojOtro = 
				builderDeTipo.empezarCreacion()
				.setTela(Tela.OTRO)
				.crearTipo();
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void creacionPantalonConTelaNull() {
		Tipo pantalonNylon = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaPantalones)
				.setTela(null)
				.crearTipo();
	}	
	
	@Test
	public void creacionRemeraSinTela() {
		Tipo remeraSinTela = 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaRemeras)
				.crearTipo();
		Assert.assertEquals("remera", remeraSinTela.getNombre());
		Assert.assertEquals(Categoria.SUPERIOR, remeraSinTela.getCategoria());
	}
	
	@Test
	public void remeraSinTelaTieneTelaNull() {
		Tipo remeraSinTela= 
				builderDeTipo.empezarCreacion()
				.setFabricaTipos(familiaRemeras)
				.crearTipo();
		Assert.assertNull(remeraSinTela.getTela());
	}
	
}
