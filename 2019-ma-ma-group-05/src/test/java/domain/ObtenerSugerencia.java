package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	private Prenda antiparras2;
	private Prenda musculosa2;
	private Prenda shorts2;
	private Prenda ojotas2;
	private Prenda zapatillas2;
	private Prenda remera2;
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
	public void testObtenerAlgunaSugerencia(){
		
		Assert.assertNotNull(usuario.obtenerSugerencias(usuario.getGuardarropas().get(0)));
	}
	@Test
	public void testObtenerSugerenciaEspecifica(){
		
		Guardarropa guardarropa=usuario.getGuardarropa("guardarropa");
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.obtenerSugerencias(guardarropa);
		
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR)).get(0));
		
		Assert.assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));
	}
	@Test
	public void testObtenerOtraSugerenciaEspecifica() {

		Guardarropa guardarropa= usuario.getGuardarropa("guardarropa");
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.SUPERIOR)).get(1));
		
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.getGuardarropa("guardarropa").obtenerSugerencias();
		Assert.assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));}
}
