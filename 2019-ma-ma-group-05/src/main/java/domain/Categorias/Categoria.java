package domain.Categorias;

import domain.Atuendo;

public abstract class Categoria {
	private String nombre;
	private int numeroCapa;
	public int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo();
	}
	public Categoria(String nombre, int numeroCapa){
		this.nombre = nombre;
		this.numeroCapa = numeroCapa;
	}
}
