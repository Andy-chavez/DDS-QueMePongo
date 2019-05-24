package domain;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import domain.Excepciones.*;
import domain.TiposDePrenda.*;

public class testPrendas{
	
	@Test
	public void seCreaPrendaSatisfactoriamente() throws PrendaMalConstruida{
		List<Color> colores=new ArrayList<Color>();
		colores.add(Color.NEGRO);
		Remera unaRemera=new Remera(colores,Tela.SEDA);
		assertNotNull(unaRemera);
	}
	@Test
	public void seAgregaPrendaSatisfactoriamente() throws PrendaMalConstruida{
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		Prenda prenda=new Remera(unosColores,Tela.SEDA);
		usuario.agregarPrenda(usuario.getGuardarropa("ropalinda"), prenda);
		assertTrue(usuario.getGuardarropa("ropalinda").getPrendas().contains(prenda));
	}
	@Test
	public void seAgregaGuardarropaSatisfactoriamente() throws PrendaMalConstruida {
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		List <Color> otrosColores = new ArrayList<Color>();
		otrosColores.add(Color.NEGRO);
		Prenda prenda1=new Remera(unosColores,Tela.SEDA);
		Prenda prenda2= new Pantalon(otrosColores,Tela.CUERO);
		
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(prenda1);
		prendas.add(prenda2);
		Guardarropa guardarropaNuevo = new Guardarropa("ropavieja",prendas);
		usuario.agregarGuardarropa(guardarropaNuevo);
		assertTrue(usuario.getGuardarropas().contains(guardarropaNuevo));
	}
	@Test(expected=PrendaMalConstruida.class)
	public void seRompeAlIntentarAgregarGuardarropaConPrendaMalConstruida() throws PrendaMalConstruida {
		Usuario usuario=Usuario.testGenerarUsuario();
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.AMARILLO);
		List <Color> otrosColores = new ArrayList<Color>();
		otrosColores.add(Color.NEGRO);
		Prenda prenda1=new Remera(unosColores,Tela.CUERO);
		Prenda prenda2= new Pantalon(otrosColores,Tela.CUERO);
		
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(prenda1);
		prendas.add(prenda2);
		Guardarropa guardarropaNuevo = new Guardarropa("ropavieja",prendas);
		usuario.agregarGuardarropa(guardarropaNuevo);
	}
	@Test(expected=PrendaMalConstruida.class)
	public void seRompeAlCrearPantalonInconsistente() throws PrendaMalConstruida{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Pantalon(unosColores,"un pantalon fisura",Tela.NYLON);
	}
	@Test(expected=PrendaMalConstruida.class)
	public void seRompeAlCrearRemeraInconsistente() throws PrendaMalConstruida{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Remera(unosColores,"una remera fisura",Tela.CUERO);
	}
	@Test(expected=PrendaMalConstruida.class)
	public void seRompeAlCrearCalzadoInconsistente() throws PrendaMalConstruida{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Zapatos(unosColores,"un pantalon fisura",Tela.SEDA);
	}
	@Test(expected=PrendaMalConstruida.class)
	public void seRompeAlCrearAccesorioInconsistente() throws PrendaMalConstruida{
		List<Color> unosColores= new ArrayList<Color>();
		unosColores.add(Color.NEGRO);
		Prenda prenda = new Accesorio(unosColores,"un accesorio fisura",Tela.ALGODON);
	}
	
}
