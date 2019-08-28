package domain.Categorias;

import domain.Atuendo;

public class SuperiorBase extends Categoria{

	public SuperiorBase(String nombre, int numeroCapa) {
		super(nombre, numeroCapa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo() + atuendo.getSensibilidadFrio().getSuperior();
	}
}
