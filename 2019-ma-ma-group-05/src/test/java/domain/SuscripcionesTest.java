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
import domain.Tipos.*;
import domain.Tipos.Short;

public class SuscripcionesTest {
	Guardarropa guardarropa;
	
	private Antiparras antiparrasTipo;
	private Musculosa musculosaTipo;
	private Short shortsTipo;
	private Ojotas ojotasTipo;
	private Remera remeraTipo;
	private Zapatillas zapatillasTipo;
	
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
	
	private Usuario usuario;
	
	private List<Prenda> prendas;
	@Before
	public void init(){
		antiparrasTipo = new Antiparras();
		musculosaTipo = new Musculosa();
		shortsTipo = new Short();
		ojotasTipo = new Ojotas();
		remeraTipo = new Remera();
		zapatillasTipo = new Zapatillas();
		
		// Prendas para el test de sugerencias
		//remeraTipo.setTela(Tela.OTRO);
		// Prendas para el test de sugerencias
		remeraTipo.establecerTela(Tela.OTRO);
		remera = new Prenda(remeraTipo,Color.black,Color.blue);
		antiparrasTipo.establecerTela(Tela.OTRO);
		antiparras = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shortsTipo.establecerTela(Tela.OTRO);
		shorts = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosaTipo.establecerTela(Tela.OTRO);
		musculosa = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotasTipo.establecerTela(Tela.OTRO);
		ojotas = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillasTipo.establecerTela(Tela.OTRO);
		zapatillas = new Prenda(zapatillasTipo,Color.black,Color.blue);
		remera2 = new Prenda(remeraTipo,Color.black,Color.blue);
		antiparras2 = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts2 = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa2 = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas2 = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas2 = new Prenda(zapatillasTipo,Color.black,Color.blue);
		remeraBonus = new Prenda(remeraTipo,Color.black,Color.blue);
		
		prendas = new ArrayList<Prenda>();
		prendas.add(antiparras);
		prendas.add(zapatillas);
		prendas.add(musculosa);
		prendas.add(remera);
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
		Free free= new Free();
		assertEquals(free.getLimiteDePrendas(),12);
	}
	@Test
	public void usuarioConGuardarropaAlLimite(){
		assertEquals(usuario.getGuardarropa("guardarropa").cantidadDePrendas(),12);
	}
	
	@Test(expected=LimiteDePrendasAlcanzadoException.class)
	public void usuarioFreeSePasaDelLimite(){
		usuario.agregarPrenda(guardarropa, remeraBonus);
	}
	
}
