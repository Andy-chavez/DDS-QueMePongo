package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import domain.Excepciones.*;

public class ObtenerSugerencia {
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
		usuario= new Usuario("usuario",guardarropa);
	}
	
	@Test
	public void testObtenerAlgunaSugerencia(){
		
		assertNotNull(usuario.obtenerSugerencias(usuario.getGuardarropas().get(0)));
	}
	@Test
	public void testObtenerSugerenciaEspecifica(){
		
		Guardarropa guardarropa=usuario.getGuardarropa("ropalinda");
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.obtenerSugerencias(guardarropa);
		
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR)).get(0));
		
		assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));
	}
	@Test
	public void testObtenerOtraSugerenciaEspecifica() {

		Guardarropa guardarropa= usuario.getGuardarropa("ropalinda");
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR)).get(1));
		
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.getGuardarropa("ropalinda").obtenerSugerencias();
		assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));}
}
