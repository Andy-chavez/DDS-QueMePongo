package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AttributeSet.ColorAttribute;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Guardarropa;
import domain.Prenda;
import domain.Tela;
import domain.Telas.Algodon;

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
	
	private Algodon algodon;
	
	private List<Prenda> prendas;
	@Before
	public void init() {
		algodon = new Algodon();
		// familias de tipos
		antiparrasTipo = new domain.Tipos.Antiparras();
		musculosaTipo = new domain.Tipos.Musculosa();
		shortsTipo = new domain.Tipos.Short();
		ojotasTipo = new domain.Tipos.Ojotas();
		remeraTipo = new domain.Tipos.Remera();
		zapatillasTipo = new domain.Tipos.Zapatillas();
		
		// Prendas para el test de sugerencias
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		
		//antiparrasTipo.establecerTela(algodon);
		antiparras = SimpleFactoryPrendas.crearPrenda("antiparras");
		antiparras.setColorPrimario(Color.BLACK);
		antiparras.setTela(algodon);
		shorts = SimpleFactoryPrendas.crearPrenda("short");
		shorts.setColorPrimario(Color.BLACK);
		shorts.setTela(algodon);
		musculosa =SimpleFactoryPrendas.crearPrenda("musculosa");
		//ojotasTipo.establecerTela(algodon);
		ojotas = SimpleFactoryPrendas.crearPrenda("ojotas");
		//zapatillasTipo.establecerTela(algodon);
		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		
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
	
	/*@Test
	public void devuelvePrendasSuperiores() {
		List<Prenda> prendasSuperiores = guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR));
		Prenda prenda2=prendasSuperiores.get(0);
		Assert.assertNotNull(prenda2);
	}*/
//podriamos agregar mas cosas
}
