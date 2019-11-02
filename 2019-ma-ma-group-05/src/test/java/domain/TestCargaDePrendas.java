package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import models.entities.ColorPersistible;
import models.entities.Prenda;
import models.entities.SimpleFactoryPrendas;
import models.entities.Tela;

public class TestCargaDePrendas {
	public static List<Prenda> init(){
		List<Prenda> listaDePrendas = new ArrayList<Prenda>();
		Tela algodon= new Tela("algodon");
		Tela cuero = new Tela("cuero");
		Prenda unShort;
		Prenda musculosa;
		Prenda ojotas;
		Prenda zapatillas;
		Prenda remera;
		Prenda short2;
		Prenda musculosa2;
		Prenda ojotas2;
		Prenda zapatillas2;
		Prenda remera2;
		
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setColorPrimario(ColorPersistible.black);
		remera.setTela(algodon);

		unShort = SimpleFactoryPrendas.crearPrenda("shorts");
		unShort.setColorPrimario(ColorPersistible.BLACK);
		unShort.setTela(algodon);
		
		musculosa = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa.setColorPrimario(ColorPersistible.BLACK);
		musculosa.setTela(algodon);
		
		ojotas = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas.setColorPrimario(ColorPersistible.BLACK);
		ojotas.setTela(cuero);
		
		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setColorPrimario(ColorPersistible.BLACK);
		zapatillas.setTela(algodon);
		
		remera2 = SimpleFactoryPrendas.crearPrenda("remera");
		remera2.setColorPrimario(ColorPersistible.BLACK);
		remera2.setTela(algodon);
		
		short2 = SimpleFactoryPrendas.crearPrenda("shorts");
		short2.setColorPrimario(ColorPersistible.BLACK);
		short2.setTela(algodon);
		
		musculosa2 = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa2.setColorPrimario(ColorPersistible.BLACK);
		musculosa2.setTela(algodon);
		
		ojotas2 = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas2.setColorPrimario(ColorPersistible.BLACK);
		ojotas2.setTela(cuero);
		
		zapatillas2 = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas2.setColorPrimario(ColorPersistible.BLACK);
		zapatillas2.setTela(algodon);
		
		listaDePrendas.add(remera);
		listaDePrendas.add(remera2);
		listaDePrendas.add(musculosa);
		listaDePrendas.add(musculosa2);
		listaDePrendas.add(unShort);
		listaDePrendas.add(short2);
		listaDePrendas.add(ojotas);
		listaDePrendas.add(ojotas2);
		listaDePrendas.add(zapatillas2);
		listaDePrendas.add(zapatillas);
		
		return listaDePrendas;
	}
}
