package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import domain.Excepciones.*;

public class ObtenerSugerencia {
	private Prenda prenda;
	private Tipo tipo;
	private Guardarropa guardarropa;
	private Usuario usuario;
		
	@Before
	public void init() {
		prenda = new Prenda();
		tipo = new Tipo();
		
		tipo.setCategoria(Categoria.CALZADO);
		tipo.setNombre("Zapatos");
		tipo.setTela(Tela.CUERO);
		
		prenda.setColorPrimario(Color.black);
		prenda.setTipo(tipo);
		
		guardarropa= new Guardarropa("guardarropa",prenda);
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
