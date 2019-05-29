package domain;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.BuilderPrenda;
import domain.Categoria;
import domain.FamiliaTipos;
import domain.Guardarropa;
import domain.Prenda;
import domain.Tela;
import domain.Atuendo;

public class GuardarropaTest {
	private Guardarropa guardarropa;
	
	private FamiliaTipos antiparrasFamiliaTipo;
	private FamiliaTipos musculosaFamiliaTipo;
	private FamiliaTipos shortsFamiliaTipo;
	private FamiliaTipos ojotasFamiliaTipo;
	private FamiliaTipos remeraFamiliaTipo;
	private FamiliaTipos zapatillasFamiliaTipo;
	
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
		Assert.assertTrue(prendasSuperiores.stream().allMatch(prenda -> prenda.deCategoria(Categoria.SUPERIOR)));
	}
//podriamos agregar mas cosas
}
