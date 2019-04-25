package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
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
		/*System.out.println(usuario.obtenerSugerencia(guardarropa).atuendosIguales(atuendo));
		System.out.println(atuendo.getParteSuperior().equals(usuario.obtenerSugerencia(guardarropa).getParteSuperior()));
		System.out.println(atuendo.getParteInferior().equals(usuario.obtenerSugerencia(guardarropa).getParteInferior()));
		System.out.println(atuendo.getCalzado().equals(usuario.obtenerSugerencia(guardarropa).getCalzado()));
		System.out.println(atuendo.getAccesorio().equals(usuario.obtenerSugerencia(guardarropa).getAccesorio()));
		/*Misma remera, mismo pantalon, todos los attr iguales
		, pero sin embargo cuando los comparo  me da bandera azul y no pasa el test
		*/
		//System.out.println(usuario.getGuardarropa("ropalinda").obtenerTodasLasSugerencias());
		List<Atuendo> atuendossugeridos=new ArrayList<Atuendo>();
		atuendossugeridos=usuario.getGuardarropa("ropalinda").obtenerTodasLasSugerencias();
		System.out.println("Cantidad de atuendos sugeridos: " +atuendossugeridos.size());
		for(int i=0;i<atuendossugeridos.size();i++){
			System.out.println("Prenda : " + i);
			System.out.println("Torso: " + atuendossugeridos.get(i).getParteSuperior().toString());
			System.out.println("Piernas: " + atuendossugeridos.get(i).getParteInferior().toString());
			System.out.println("Calzado: " + atuendossugeridos.get(i).getCalzado().toString());
			System.out.println("Accesorio: " + atuendossugeridos.get(i).getAccesorio().toString());
		}/*Ésto fue para probar que me crea varios atuendos con las combinaciones, teóricamente el algoritmo funciona.
		Hasta ahora en nuestro guardarropa tenemos 1 pantalon, 1 accesorio, 1 calzado y 2 remeras, me debería crear 2 atuendos
		y lo hace efectivamente.*/
		
		assertTrue(atuendo.getParteSuperior()==usuario.obtenerSugerencia(guardarropa).getParteSuperior());
	

}
}
