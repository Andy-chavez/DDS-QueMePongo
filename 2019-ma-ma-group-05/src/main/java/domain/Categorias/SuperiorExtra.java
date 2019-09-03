package domain.Categorias;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Atuendo;
import domain.Categoria;
import domain.Prenda;
import domain.Tipo;

public class SuperiorExtra extends Categoria{
	
	private List<Prenda> filtrarTipoYaUsado(List<Prenda> prendas, Tipo tipo){
		List<Prenda> prendasFiltradas =  prendas.stream().filter(p -> !p.esDeTipo(tipo)).collect(Collectors.toList());
		return prendasFiltradas;
	}
	
	@Override
	protected int calcularNivelAbrigoRequerido(Atuendo atuendo){
		int nivelAbrigoActual = atuendo.getNivelAbrigoDeCategoria(this) + atuendo.getNivelAbrigoDeCategoria(new SuperiorBase());
		return atuendo.getNivelAbrigo() + atuendo.getSensibilidadFrio().getSuperior() - nivelAbrigoActual;
	}
	
	@Override
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		atuendo.printPrendas();
		int margenAdmitido = 5;
		int nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo);
		List<Prenda> prendasDeEstaCategoria =  prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
		List<Prenda> prendasConAbrigoOk = obtenerPrendasParaNivelAbrigo(prendasDeEstaCategoria, nivelAbrigoFaltante);
		Prenda prendaElegida = elegirPrendaRandom(prendasConAbrigoOk);
		while(nivelAbrigoFaltante > margenAdmitido && prendaElegida != null){
			atuendo.agregarPrenda(prendaElegida);
			atuendo.printPrendas();
			// despues de agregar la primer capa, filtro todas las de ese tipo para no volver a agregarla
			nivelAbrigoFaltante = calcularNivelAbrigoRequerido(atuendo);
			prendasDeEstaCategoria = filtrarTipoYaUsado(prendasDeEstaCategoria, prendaElegida.getTipo());
			prendasConAbrigoOk = obtenerPrendasParaNivelAbrigo(prendasDeEstaCategoria, nivelAbrigoFaltante);
			prendaElegida = elegirPrendaRandom(prendasConAbrigoOk);
		}
	}
}