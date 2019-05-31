package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ObtenerSugerencia {
	private Prenda prenda1;
	private Prenda prenda2;
	private Prenda prenda3;
	private Prenda prenda4;
	private Prenda prenda5;
	private Tipo tipo1;
	private Tipo tipo2;
	private Tipo tipo3;
	private Tipo tipo4;
	private Tipo tipo5;
	private Guardarropa guardarropa;
	private Usuario usuario;
	private List<Prenda> prendas=new ArrayList<Prenda>();
	@Before
	public void init() {
		prenda1 = new Prenda();
		tipo1 = new Tipo();
		tipo1.setCategoria(Categoria.CALZADO);
		tipo1.setNombre("Zapatos");
		tipo1.setTela(Tela.CUERO);
		prenda1.setColorPrimario(Color.black);
		prenda1.setTipo(tipo1);
		
		prenda2 = new Prenda();
		tipo2 = new Tipo();
		tipo2.setCategoria(Categoria.INFERIOR);
		tipo2.setNombre("Pantalon");
		tipo2.setTela(Tela.ALGODON);
		prenda2.setColorPrimario(Color.black);
		prenda2.setTipo(tipo2);
		
		prenda3 = new Prenda();
		tipo3 = new Tipo();
		tipo3.setCategoria(Categoria.SUPERIOR);
		tipo3.setNombre("Remera");
		tipo3.setTela(Tela.SEDA);
		prenda3.setColorPrimario(Color.pink);
		prenda3.setTipo(tipo3);
		
		prenda4 = new Prenda();
		tipo4 = new Tipo();
		tipo4.setCategoria(Categoria.ACCESORIO);
		tipo4.setNombre("Reloj");
		tipo4.setTela(Tela.CUERO);
		prenda4.setColorPrimario(Color.black);
		prenda4.setTipo(tipo4);
		
		prenda5= new Prenda();
		tipo5 = new Tipo();
		tipo5.setCategoria(Categoria.SUPERIOR);
		tipo5.setNombre("Remera");
		tipo5.setTela(Tela.ALGODON);
		prenda5.setColorPrimario(Color.blue);
		prenda5.setTipo(tipo5);
		
		
		prendas.add(prenda1);
		prendas.add(prenda2);
		prendas.add(prenda3);
		prendas.add(prenda4);
		prendas.add(prenda5);
		guardarropa= new Guardarropa("ropacheta",prendas);
		usuario= new Usuario("usuario",guardarropa);
	}
	
	@Test
	public void obtenerSugerencia(){
		
		Guardarropa guardarropa2=usuario.getGuardarropa("ropacheta");
		Atuendo atuendoSugerido=new Atuendo();
		atuendoSugerido=usuario.obtenerSugerencia(guardarropa2);
		atuendoSugerido.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));
		assertNotNull(atuendoSugerido);
	}
	@Test
	public void compararAtuendosDaTrue(){
		
		Guardarropa guardarropa2=usuario.getGuardarropa("ropacheta");
		Atuendo atuendoSugerido=new Atuendo();
		atuendoSugerido=usuario.obtenerSugerencia(guardarropa2);
		atuendoSugerido.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		Atuendo otroAtuendo=new Atuendo();
		otroAtuendo.agregarPrenda(prenda1);
		otroAtuendo.agregarPrenda(prenda2);
		otroAtuendo.agregarPrenda(prenda3);
		otroAtuendo.agregarPrenda(prenda4);
		otroAtuendo.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		assertTrue(!atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
}

