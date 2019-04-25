package domain;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.CalzadoMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.TiposDePrenda.Remera;

public class testPrendas{
	
	@Test
	public void seAgregaPrendaSatisfactoriamente() throws RemeraMalConstruida, PantalonMalConstruido, CalzadoMalConstruido, AccesorioMalConstruido{
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		TipoDePrenda unTipo=new Remera(Tela.SEDA);
		Prenda prenda=new Prenda(unosColores,unTipo);
		usuario.agregarPrenda(usuario.getGuardarropa("ropalinda"), prenda);
		assertTrue(usuario.getGuardarropa("ropalinda").getPrendas().contains(prenda));
	}
	@Test
	public void seAgregaGuardarropaSatisfactoriamente() throws RemeraMalConstruida, PantalonMalConstruido, CalzadoMalConstruido, AccesorioMalConstruido {
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		TipoDePrenda unTipo=new Remera(Tela.SEDA);
		Prenda prenda=new Prenda(unosColores,unTipo);
		Guardarropa guardarropaNuevo = new Guardarropa("ropavieja");
		guardarropaNuevo.agregarPrenda(prenda);
		usuario.agregarGuardarropa(guardarropaNuevo);
		assertTrue(usuario.getGuardarropas().contains(guardarropaNuevo));
	}
	
}
