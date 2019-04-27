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
		Guardarropa guardarropa=usuario.getGuardarropa("ropalinda");
		Atuendo atuendoObtenido=usuario.obtenerSugerencia(guardarropa);
		
		List<Atuendo> atuendossugeridos=new ArrayList<Atuendo>();
		atuendossugeridos=usuario.getGuardarropa("ropalinda").obtenerTodasLasSugerencias();
		Atuendo atuendoEsperado = atuendossugeridos.get(0);
		assertTrue(atuendoEsperado.compararConOtroAtuendo(atuendoObtenido));
	}
	@Test
	public void testObtenerOtraSugerenciaEspecifica() throws RemeraMalConstruida, PantalonMalConstruido, ZapatosMalConstruidos, AccesorioMalConstruido {
			
		Usuario usuario=Usuario.testGenerarUsuario();
		Guardarropa guardarropa= usuario.getGuardarropa("ropalinda");
		Atuendo atuendo2=new Atuendo();
		atuendo2.setAccesorio(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.ACCESORIO)).get(0));
		atuendo2.setParteInferior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_INFERIOR)).get(0));
		atuendo2.setCalzado(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.CALZADO)).get(0));
		atuendo2.setParteSuperior(guardarropa.filtrarPrendasSegunCondicion(guardarropa.esDeCategoria(Categoria.PARTE_SUPERIOR)).get(1));
		
		List<Atuendo> atuendossugeridos=new ArrayList<Atuendo>();
		atuendossugeridos=usuario.getGuardarropa("ropalinda").obtenerTodasLasSugerencias();
		Atuendo atuendoEsperado = atuendossugeridos.get(1);
		assertTrue(atuendoEsperado.compararConOtroAtuendo(atuendo2));
}
}
