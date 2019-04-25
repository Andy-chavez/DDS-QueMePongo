package domain;

import static org.junit.Assert.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.CalzadoMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;

public class ObtenerSugerencia {

	@Test
	public void testObtenerAlgunaSugerencia() throws RemeraMalConstruida, PantalonMalConstruido, CalzadoMalConstruido, AccesorioMalConstruido {
		
		Usuario usuario=Usuario.testGenerarUsuario();
		assertNotNull(usuario.obtenerSugerencia(usuario.getGuardarropas().get(0)));
	}
	@Test
	public void testObtenerSugerenciaEspecifica() throws RemeraMalConstruida, PantalonMalConstruido, CalzadoMalConstruido, AccesorioMalConstruido {
		
		Usuario usuario=Usuario.testGenerarUsuario();
		Atuendo atuendo=new Atuendo();
		Guardarropa guardarropa=usuario.getGuardarropa("ropalinda");
		Prenda unAccesorio = guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0);
		Prenda unPantalon = guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_INFERIOR)).get(0);
		Prenda unosZapatos = guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0); 
		Prenda unaRemera= guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_SUPERIOR)).get(0);
		
		atuendo.setAccesorio(unAccesorio);
		atuendo.setCalzado(unosZapatos);
		atuendo.setParteInferior(unPantalon);
		atuendo.setParteSuperior(unaRemera);
		/*El atuendo que me debería dar tiene los mismos atributos que el atuendo que me devuelve  el obtenerSugerencia
		 *Sin embargo, cuando los comparo me tira bandera azul y no me pasa el test 
		 */
		System.out.println(usuario.obtenerSugerencia(guardarropa).toString());
		System.out.println(atuendo.toString());
		/*Misma remera, mismo pantalon, todos los attr iguales
		, pero sin embargo cuando los comparo  me da bandera azul y no pasa el test
		*/
		assertTrue(atuendo.getParteSuperior().equals(usuario.obtenerSugerencia(guardarropa).getParteSuperior()));
	

}
}
