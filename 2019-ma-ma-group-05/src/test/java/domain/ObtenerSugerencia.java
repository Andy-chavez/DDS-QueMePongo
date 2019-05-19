package domain;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import domain.Excepciones.*;

public class ObtenerSugerencia {

	@Test
	public void testObtenerAlgunaSugerencia() throws PrendaMalConstruida {
		
		Usuario usuario=Usuario.testGenerarUsuario();
		assertNotNull(usuario.obtenerSugerencias(usuario.getGuardarropas().get(0)));
	}
	@Test
	public void testObtenerSugerenciaEspecifica() throws PrendaMalConstruida {
		
		Usuario usuario=Usuario.testGenerarUsuario();
		Guardarropa guardarropa=usuario.getGuardarropa("ropalinda");
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.obtenerSugerencias(guardarropa);
		
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_SUPERIOR)).get(0));
		
		assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));
	}
	@Test
	public void testObtenerOtraSugerenciaEspecifica() throws PrendaMalConstruida {
			
		Usuario usuario=Usuario.testGenerarUsuario();
		Guardarropa guardarropa= usuario.getGuardarropa("ropalinda");
		Atuendo atuendo=new Atuendo();
		atuendo.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_INFERIOR)).get(0));
		atuendo.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_SUPERIOR)).get(1));
		
		List<Atuendo> atuendosSugeridos=new ArrayList<Atuendo>();
		atuendosSugeridos=usuario.getGuardarropa("ropalinda").obtenerSugerencias();
		assertTrue(atuendosSugeridos.stream().anyMatch(unAtuendo->unAtuendo.compararConOtroAtuendo(atuendo)));}
}
