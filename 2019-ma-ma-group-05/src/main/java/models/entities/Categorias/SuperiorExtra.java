package models.entities.Categorias;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
import models.entities.Prenda;
import models.entities.Tipo;
@Entity
public class SuperiorExtra extends Categoria{
	public SuperiorExtra(){
		this.setNombre("SuperiorExtra");
	}

	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo, int nivelAbrigoRequerido){
		return nivelAbrigoRequerido - atuendo.getAbrigoSuperior();
	}
	@Override
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
		atuendo.addAbrigoSuperior(prenda.getNivelAbrigo());
	}

	public void agregarPrendasDeParte(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		int margenAdmitido = 5;
		int nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo, nivelAbrigoRequerido);
		List<Prenda> prendasCapasSinUtilizar = prendas;
		while(nivelAbrigoFaltante > margenAdmitido && !prendasCapasSinUtilizar.isEmpty()){
			Prenda prendaSeleccionada = obtenerPrendaParaNivelAbrigo(prendasCapasSinUtilizar, nivelAbrigoFaltante);
			agregarPrenda(atuendo, prendaSeleccionada);
			prendasCapasSinUtilizar = filtrarCapaYaUsada(prendasCapasSinUtilizar, prendaSeleccionada.getCapa());
			nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo, nivelAbrigoRequerido);
		}
	}

	@Override
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){ // la parte comentada fue un intento de unificar base con extra, pero prefiero que la camisa quede mas random
		List<Prenda> prendasSuperiores = obtenerPrendasCategoria(prendas, this);

		// algorimo pedorro para decidir si el atuendo tiene remera, camisa, o ambas
		Random random = new Random();
		if(random.nextInt(2) == 0){
			List<Prenda> remeras = prendasSuperiores.stream().filter(p -> p.getCapa() == 0).collect(Collectors.toList());
			agregarPrenda(atuendo, remeras.get(random.nextInt(remeras.size())));
			prendasSuperiores = filtrarCapaYaUsada(prendasSuperiores, 0); // remuevo remeras
		}
		else{
			List<Prenda> camisas = prendasSuperiores.stream().filter(p -> p.getCapa() == 1).collect(Collectors.toList());
			agregarPrenda(atuendo, camisas.get(random.nextInt(camisas.size())));
			prendasSuperiores = filtrarCapaYaUsada(prendasSuperiores, 1); // remuevo camisas
		}
		agregarPrendasDeParte(atuendo, prendasSuperiores, nivelAbrigoRequerido);
	}
}