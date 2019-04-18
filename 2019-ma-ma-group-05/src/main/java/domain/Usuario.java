package domain;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private String nombre;
	
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this.nombre=unNombre;
		this.guardarropas=new ArrayList<Guardarropa>();
		this.agregarGuardarropa(guardarropa);
	}
	
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){
		this.nombre=unNombre;
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		armario.agregarPrenda(prenda);
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa) throws Exception{
		/*Ése throw que está en la firma es para que no rompa los huevos digamos.
		 * En realidad estaría burbujeando la excepción a tal punto que le explota en la cara
		 * al usuario. Como todavía no sabría que hacer si al usuario no le gusta ninguna sugerencia,
		 * lo dejo así y no hago ningun catch porque claramente no se que hacer con la excepción al atraparla.
		 * Cuando algún profe me conteste por el foro qué hacer, ahí vería donde meter el catch
		 * 
		 
		 */
		return guardarropa.obtenerSugerencia();
	}
	
}
