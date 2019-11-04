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
public class Superior extends Categoria{
	public Superior(){
		this.setNombre("Superior");
	}

	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo, int nivelAbrigoRequerido){
		return nivelAbrigoRequerido - atuendo.getAbrigoSuperior();
	}
	@Override
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
		atuendo.addAbrigoSuperior(prenda.getNivelAbrigo());
	}

	//
	public void agregarPrendasDeParte(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		int margenAdmitido = 5;
		int nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo, nivelAbrigoRequerido);
		while(nivelAbrigoFaltante > margenAdmitido && !prendas.isEmpty()){
			Prenda prendaSeleccionada = obtenerPrendaParaNivelAbrigo(prendas, nivelAbrigoFaltante);
			agregarPrenda(atuendo, prendaSeleccionada);
			prendas = filtrarCapaYaUsada(prendas, prendaSeleccionada.getCapa());
			nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo, nivelAbrigoRequerido);
		}
	}

	@Override
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){ // la parte comentada fue un intento de unificar base con extra, pero prefiero que la camisa quede mas random
		List<Prenda> prendasSuperiores = obtenerPrendasCategoria(prendas, this);
		List<Prenda> remeras = prendasSuperiores.stream().filter(p -> p.getCapa() == 0).collect(Collectors.toList());
		List<Prenda> camisas = prendasSuperiores.stream().filter(p -> p.getCapa() == 1).collect(Collectors.toList());

		// algorimo pedorro para decidir si el atuendo tiene remera, camisa, o ambas
		// si no tiene camisas, le agrego directamente una remera, sino queda en cuero :/
		Random random = new Random();
		if(camisas.isEmpty() || random.nextInt(2) == 0){
			if(!remeras.isEmpty()){
				agregarPrenda(atuendo, remeras.get(random.nextInt(remeras.size())));
				prendasSuperiores = filtrarCapaYaUsada(prendasSuperiores, 0); // remuevo remeras
			}
		}
		else{
			agregarPrenda(atuendo, camisas.get(random.nextInt(camisas.size())));
			prendasSuperiores = filtrarCapaYaUsada(prendasSuperiores, 1); // remuevo camisas

		}

		// luego de agregar una remera o camisa, agrego las prendas de abrigo
		agregarPrendasDeParte(atuendo, prendasSuperiores, nivelAbrigoRequerido);
	}
}