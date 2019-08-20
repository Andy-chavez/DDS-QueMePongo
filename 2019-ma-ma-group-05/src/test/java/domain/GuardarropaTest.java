package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.BuilderPrenda;
import domain.Categoria;
import domain.Guardarropa;
import domain.Prenda;
import domain.Tela;

public class GuardarropaTest {
	private Guardarropa guardarropa;
	
	private Tipo antiparrasTipo;
	private Tipo musculosaTipo;
	private Tipo shortsTipo;
	private Tipo ojotasTipo;
	private Tipo remeraTipo;
	private Tipo zapatillasTipo;
	
	private Prenda antiparras;
	private Prenda musculosa;
	private Prenda shorts;
	private Prenda ojotas;
	private Prenda zapatillas;
	private Prenda remera;
	
	private Usuario usuario;
	
	private List<Prenda> prendas;
	@Before
	public void init() {
		
		// familias de tipos
		antiparrasTipo = new domain.Tipos.Antiparras();
		musculosaTipo = new domain.Tipos.Musculosa();
		shortsTipo = new domain.Tipos.Short();
		ojotasTipo = new domain.Tipos.Ojotas();
		remeraTipo = new domain.Tipos.Remera();
		zapatillasTipo = new domain.Tipos.Zapatillas();
		
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
		
		// Guardar todo menos antiparras.
		prendas = new ArrayList<Prenda>();
		prendas.add(zapatillas);
		prendas.add(musculosa);
		prendas.add(remera);
		prendas.add(shorts);
		prendas.add(ojotas);
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario = new Usuario("usuario",guardarropa);
	}
	
	@Test
	public void seGuardaUnaAntiparra() {
		guardarropa.agregarPrenda(antiparras);
		Assert.assertTrue(guardarropa.tieneLaPrenda(antiparras));
	}
	
	@Test
	public void devuelvePrendasSuperiores() {
		List<Prenda> prendasSuperiores = guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR));
		Prenda prenda2=prendasSuperiores.get(0);
		Assert.assertNotNull(prenda2);
	}
//podriamos agregar mas cosas
}
