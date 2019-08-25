package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Suscripciones.Free;
import domain.Suscripciones.Premium;
import domain.Excepciones.LimiteDePrendasAlcanzadoException;
import static org.mockito.Mockito.*
public class SuscripcionesTest {
	Guardarropa guardarropa;
	
	private Tipo antiparrasFamiliaTipo;
	private Tipo musculosaFamiliaTipo;
	private Tipo shortsFamiliaTipo;
	private Tipo ojotasFamiliaTipo;
	private Tipo remeraFamiliaTipo;
	private Tipo zapatillasFamiliaTipo;
	
	private Prenda antiparras;
	private Prenda musculosa;
	private Prenda shorts;
	private Prenda ojotas;
	private Prenda zapatillas;
	private Prenda remera;
	private Prenda antiparras2;
	private Prenda musculosa2;
	private Prenda shorts2;
	private Prenda ojotas2;
	private Prenda zapatillas2;
	private Prenda remera2;
	private Prenda remeraBonus;
	private Free mockSuscripcionFree;
	private Usuario usuario;
	private Guardarropa guardarropa2;
	private Usuario usuario2;
	private List<Prenda> prendas;
	@Before
	public void init(){
		antiparrasFamiliaTipo = new domain.Tipos.Antiparras();
		musculosaFamiliaTipo = new domain.Tipos.Musculosa();
		shortsFamiliaTipo = new domain.Tipos.Short();
		ojotasFamiliaTipo = new domain.Tipos.Ojotas();
		remeraFamiliaTipo = new domain.Tipos.Remera();
		zapatillasFamiliaTipo = new domain.Tipos.Zapatillas();
		
		// Prendas para el test de sugerencias
		remera = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		antiparras = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(antiparrasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		shorts = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(shortsFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		musculosa = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(musculosaFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		ojotas = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(ojotasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		zapatillas = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(zapatillasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		remera2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		antiparras2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(antiparrasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		shorts2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(shortsFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		musculosa2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(musculosaFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		ojotas2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(ojotasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		zapatillas2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(zapatillasFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		remeraBonus = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraFamiliaTipo)
				 .crearTipoConTelaYCategoria(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		//la remera 1 no esta en la lista inicial
		prendas = new ArrayList<Prenda>();
		prendas.add(antiparras);
		prendas.add(zapatillas);
		prendas.add(musculosa);
		prendas.add(shorts);
		prendas.add(ojotas);
		prendas.add(antiparras2);
		prendas.add(zapatillas2);
		prendas.add(musculosa2);
		prendas.add(remera2);
		prendas.add(shorts2);
		prendas.add(ojotas2);
		
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		
		guardarropa2 = new Guardarropa("g2",prendas);
		usuario2 = new Usuario("usadsa",guardarropa2);
		
		mockSuscripcionFree = mock(Free.class);
		usuario.setSuscripcion(mockSuscripcionFree);
		when(mockSuscripcionFree.getLimiteDePrendas()).thenReturn(12);
	}
	@Test
	public void usuarioNuevoEsFree(){
		assertTrue(usuario.getSuscripcion().getClass()==Free.class);
	}
	@Test
	public void usuarioFreePasaAPremium(){
		Premium prem=new Premium();
		usuario.getSuscripcion().cambiarSuscripcion(usuario,prem);
		
		assertTrue(usuario.getSuscripcion().getClass()==Premium.class);
	}
	@Test
	public void limiteDePrendasDeLaSuscrpcionFreeEs12(){
		assertEquals(mockSuscripcionFree.getLimiteDePrendas(),12);
	}
	@Test
	public void usuarioFreeAgregaPrendasSinInconvenientesYQuedaEnElLimite(){
		usuario.agregarPrenda(guardarropa, remera);
		assertEquals(usuario.getGuardarropa("guardarropa").cantidadDePrendas(),12);
	}
	
	@Test(expected=LimiteDePrendasAlcanzadoException.class)
	public void usuarioFreeSePasaDelLimite(){
		usuario.agregarPrenda(guardarropa, remera);
		usuario.agregarPrenda(guardarropa, remeraBonus);
	}
	
	@Test
	public void usuarioPremiumSePasaAFreeYNoPuedeVerTodasLasPrendas(){
		//Usuario Premium
		Premium prem=new Premium();
		usuario.getSuscripcion().cambiarSuscripcion(usuario,prem);
		
		//Le agrego prendas para superar el limite
		usuario.agregarPrenda(guardarropa, remera);
		usuario.agregarPrenda(guardarropa, remeraBonus);
		assertEquals(usuario.getPrendasDelguardarropa("guardarropa").size(),13);
		//Se pasa a free
		Free f=new Free();
		usuario.setSuscripcion(f);
		
		assertEquals(usuario.getPrendasDelguardarropa("guardarropa").size(),12);
	}
	
	@Test
	public void usuarioComparteGuardarropasConOtro(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		
		assertNotNull(usuario2.getGuardarropa("guardarropa"));
	}
	
	@Test
	public void usuarioPremiumComparteGuardarropaConOtroUsuarioFreeYNoPuedeVerTodasLasPrendas(){
		usuario.setSuscripcion(new Premium());
		usuario.agregarPrenda(guardarropa, remeraBonus);
		usuario.compartirGuardarropa(usuario2, guardarropa);
		
		assertEquals(usuario2.getGuardarropa("guardarropa").cantidadDePrendas(),12);
	}
	
	@Test
	public void usuarioPremiumComparteGuardarropaConOtroUsuarioPremiumYPuedeVerTodasLasPrendas(){
		usuario.setSuscripcion(new Premium());
		usuario2.setSuscripcion(new Premium());
		usuario.agregarPrenda(guardarropa, remeraBonus);
		usuario.compartirGuardarropa(usuario2, guardarropa);
		
		assertEquals(usuario2.getGuardarropa("guardarropa").cantidadDePrendas(),13);
	}
	
	@Test
	public void usuarioDejaDeCompartirGuardarropasConOtroUsuarioYEsteYaNoPuedeAccederAEl(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		assertEquals(usuario2.getGuardarropa(guardarropa.getNombre()),guardarropa);
		
		usuario.sacarCompartimientoDeGuardarropaAUnUsuario(usuario2, guardarropa);
		assertNull(usuario.getGuardarropa(guardarropa.getNombre()));
	}
	
	@Test
	public void usuarioPremiumAgregaPrendasAGuardarropaCompartido(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		usuario2.setSuscripcion(new Premium());
		usuario2.agregarPrenda(guardarropa, remeraBonus);
		assertEquals(usuario2.getPrendasDelguardarropa(guardarropa.getNombre()),13);
	}
	@Test
	public void usuarioFreeAgregaPrendaPeroElGuardarropaEstaAlLimite(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		usuario2.setSuscripcion(mockSuscripcionFree);
		usuario2.agregarPrenda(guardarropa, remeraBonus);
		assertEquals(usuario2.getPrendasDelguardarropa(guardarropa.getNombre()),12);
	}
}
