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
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.Excepciones.ZapatosMalConstruidos;

public class ObtenerSugerencia {

	@Test
	public void testObtenerAlgunaSugerencia() throws RemeraMalConstruida, PantalonMalConstruido, ZapatosMalConstruidos, AccesorioMalConstruido {
		
		Usuario usuario=Usuario.testGenerarUsuario();
		assertNotNull(usuario.obtenerSugerencia(usuario.getGuardarropas().get(0)));
	}
	@Test
	public void testObtenerSugerenciaEspecifica() throws RemeraMalConstruida, PantalonMalConstruido, ZapatosMalConstruidos, AccesorioMalConstruido {
		
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
		/*Misma remera, mismo pantalon, todos los attr iguales
		, pero sin embargo cuando los comparo  me da bandera azul y no pasa el test
		*/
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
