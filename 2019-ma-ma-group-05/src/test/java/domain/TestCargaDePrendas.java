package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import entities.Prenda;
import entities.SimpleFactoryPrendas;
import entities.Telas.Algodon;
import entities.Telas.Cuero;
import entities.Tipos.Antiparras;
import entities.Tipos.Musculosa;
import entities.Tipos.Ojotas;
import entities.Tipos.Remera;
import entities.Tipos.Short;
import entities.Tipos.Zapatillas;

public class TestCargaDePrendas {
	public static List<Prenda> init(){
		List<Prenda> listaDePrendas = new ArrayList<Prenda>();
		Algodon algodon=Algodon.getInstance();
		Cuero cuero = Cuero.getInstance();
		Prenda antiparras;
		Prenda unShort;
		Prenda musculosa;
		Prenda ojotas;
		Prenda zapatillas;
		Prenda remera;
		Prenda antiparras2;
		Prenda short2;
		Prenda musculosa2;
		Prenda ojotas2;
		Prenda zapatillas2;
		Prenda remera2;
		
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setColorPrimario(Color.BLACK);
		remera.setTela(algodon);
		
		antiparras = SimpleFactoryPrendas.crearPrenda("antiparras");
		antiparras.setColorPrimario(Color.BLACK);
		antiparras.setTela(algodon);
		
		unShort = SimpleFactoryPrendas.crearPrenda("short");
		unShort.setColorPrimario(Color.BLACK);
		unShort.setTela(algodon);
		
		musculosa = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa.setColorPrimario(Color.BLACK);
		musculosa.setTela(algodon);
		
		ojotas = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas.setColorPrimario(Color.BLACK);
		ojotas.setTela(cuero);
		
		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setColorPrimario(Color.BLACK);
		zapatillas.setTela(algodon);
		
		remera2 = SimpleFactoryPrendas.crearPrenda("remera");
		remera2.setColorPrimario(Color.BLACK);
		remera2.setTela(algodon);
		
		antiparras2 = SimpleFactoryPrendas.crearPrenda("antiparras");
		antiparras2.setColorPrimario(Color.BLACK);
		antiparras2.setTela(algodon);
		
		short2 = SimpleFactoryPrendas.crearPrenda("short");
		short2.setColorPrimario(Color.BLACK);
		short2.setTela(algodon);
		
		musculosa2 = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa2.setColorPrimario(Color.BLACK);
		musculosa2.setTela(algodon);
		
		ojotas2 = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas2.setColorPrimario(Color.BLACK);
		ojotas2.setTela(cuero);
		
		zapatillas2 = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas2.setColorPrimario(Color.BLACK);
		zapatillas2.setTela(algodon);
		
		listaDePrendas.add(remera);
		listaDePrendas.add(remera2);
		listaDePrendas.add(musculosa);
		listaDePrendas.add(musculosa2);
		listaDePrendas.add(unShort);
		listaDePrendas.add(short2);
		listaDePrendas.add(ojotas);
		listaDePrendas.add(ojotas2);
		listaDePrendas.add(antiparras);
		listaDePrendas.add(antiparras2);
		listaDePrendas.add(zapatillas2);
		listaDePrendas.add(zapatillas);
		
		return listaDePrendas;
	}
}
