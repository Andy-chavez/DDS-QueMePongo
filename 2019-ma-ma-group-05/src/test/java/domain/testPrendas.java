package domain;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.Excepciones.ZapatosMalConstruidos;
import domain.TiposDePrenda.Accesorio;
import domain.TiposDePrenda.Pantalon;
import domain.TiposDePrenda.Remera;
import domain.TiposDePrenda.Zapatos;

public class testPrendas{

	@Test
	public void seAgregaPrendaSatisfactoriamente() throws RemeraMalConstruida, PantalonMalConstruido, ZapatosMalConstruidos, AccesorioMalConstruido{
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		TipoDePrenda unTipo=new Remera(Tela.SEDA);
		Prenda prenda=new Prenda(unosColores,unTipo);
		usuario.agregarPrenda(usuario.getGuardarropa("ropalinda"), prenda);
		assertTrue(usuario.getGuardarropa("ropalinda").getPrendas().contains(prenda));
	}
	@Test
	public void seAgregaGuardarropaSatisfactoriamente() throws RemeraMalConstruida, PantalonMalConstruido, ZapatosMalConstruidos, AccesorioMalConstruido {
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		Prenda prenda=new Prenda(unosColores,new Remera(Tela.SEDA));
		Guardarropa guardarropaNuevo = new Guardarropa("ropavieja");
		guardarropaNuevo.agregarPrenda(prenda);
		usuario.agregarGuardarropa(guardarropaNuevo);
		assertTrue(usuario.getGuardarropas().contains(guardarropaNuevo));
	}
	@Test(expected=PantalonMalConstruido.class)
	public void seRompeAlCrearPantalonInconsistente() throws PantalonMalConstruido{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Prenda(unosColores,"un pantalon fisura",new Pantalon(Tela.NYLON));
	}
	@Test(expected=RemeraMalConstruida.class)
	public void seRompeAlCrearRemeraInconsistente() throws RemeraMalConstruida{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Prenda(unosColores,"una remera fisura",new Remera(Tela.CUERO));
	}
	@Test(expected=ZapatosMalConstruidos.class)
	public void seRompeAlCrearCalzadoInconsistente() throws ZapatosMalConstruidos{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Prenda(unosColores,"un pantalon fisura",new Zapatos(Tela.SEDA));
	}
	@Test(expected=AccesorioMalConstruido.class)
	public void seRompeAlCrearAccesorioInconsistente() throws AccesorioMalConstruido{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Prenda(unosColores,"un accesorio fisura",new Accesorio(Tela.ALGODON));
	}
	
}
