package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import entities.ColorPersistible;
import entities.Guardarropa;
import entities.Prenda;
import entities.SimpleFactoryPrendas;
import entities.Usuario;
import entities.Excepciones.LimiteDePrendasAlcanzadoException;
import entities.Suscripciones.Free;
import entities.Suscripciones.Premium;

public class SuscripcionesTest {
	private Guardarropa guardarropa;
	
	private Prenda remeraBonus;
	private Usuario usuario;
	private Guardarropa guardarropa2;
	private Usuario usuario2;
	private List<Prenda> prendas;
	
	@Before
	public void init(){
		
		prendas = new ArrayList<Prenda>();
		prendas = TestCargaDePrendas.init();
		remeraBonus = SimpleFactoryPrendas.crearPrenda("remera");
		remeraBonus.setColorPrimario(ColorPersistible.BLUE);
		
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		
		guardarropa2 = new Guardarropa("g2",prendas);
		usuario2 = new Usuario("usadsa",guardarropa2);
	}
	@Test
	public void usuarioNuevoEsFree(){
		assertTrue(usuario.getSuscripcion().getClass()==Free.class);
	}
	@Test
	public void usuarioFreePasaAPremium(){
		usuario.cambiarAPremium();
		
		assertTrue(usuario.getSuscripcion().getClass()==Premium.class);
	}
	@Test
	public void limiteDePrendasDeLaSuscrpcionFreeEs12(){
		Free f = Free.getInstance();
		assertEquals(f.getLimiteDePrendas(),12);
	}
	@Test
	public void cantidadDePrendasDelGuardarropaEs12(){
		assertEquals(guardarropa.cantidadDePrendas(),12);
	}
	@Test(expected=LimiteDePrendasAlcanzadoException.class)
	public void usuarioFreeSePasaDelLimite(){
		usuario.agregarPrenda(guardarropa, remeraBonus);
	}
	
	@Test
	public void usuarioPremiumSePasaAFreeYNoPuedeVerTodasLasPrendas(){
		usuario.cambiarAPremium();
		
		usuario.agregarPrenda(guardarropa, remeraBonus);
		assertEquals(usuario.getPrendasDelguardarropa("guardarropa").size(),13);

		usuario.cambiarAFree();
		
		assertEquals(usuario.getPrendasDelguardarropa("guardarropa").size(),12);
	}
	
	@Test
	public void usuarioComparteGuardarropasConOtro(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		assertNotNull(usuario2.getGuardarropa("guardarropa"));
	}
	
	@Test
	public void usuarioPremiumComparteGuardarropaConOtroUsuarioFreeYNoPuedeVerTodasLasPrendas(){
		usuario.cambiarAPremium();
		usuario.agregarPrenda(guardarropa, remeraBonus);
		usuario.compartirGuardarropa(usuario2, guardarropa);
		
		assertEquals(usuario2.getPrendasDelguardarropa("guardarropa").size(),12);
	}
	
	@Test
	public void usuarioPremiumComparteGuardarropaConOtroUsuarioPremiumYPuedeVerTodasLasPrendas(){
		usuario.cambiarAPremium();
		usuario2.cambiarAPremium();
		usuario.compartirGuardarropa(usuario2, guardarropa);
		
		assertEquals(usuario2.getPrendasDelguardarropa("guardarropa").size(),12);
	}
	
	@Test
	public void usuarioDejaDeCompartirGuardarropasConOtroUsuarioYEsteYaNoPuedeAccederAEl(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		assertEquals(usuario2.getGuardarropa(guardarropa.getNombre()),guardarropa);
		
		usuario.sacarCompartimientoDeGuardarropaAUnUsuario(usuario2, guardarropa);
		assertFalse(usuario2.getGuardarropas().stream().anyMatch(g -> g.equals(guardarropa)));
	}
	
	@Test
	public void usuarioPremiumAgregaPrendasAGuardarropaCompartido(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		usuario2.setSuscripcion(Premium.getInstance());
		assertEquals(usuario2.getGuardarropa(guardarropa.getNombre()).cantidadDePrendas(),12);
	}
	@Test
	public void usuarioFreeAgregaPrendaPeroElGuardarropaEstaAlLimite(){
		usuario.compartirGuardarropa(usuario2, guardarropa);
		usuario2.setSuscripcion(Free.getInstance());
		assertEquals(usuario2.getGuardarropa(guardarropa.getNombre()).cantidadDePrendas(),12);
	}
}
