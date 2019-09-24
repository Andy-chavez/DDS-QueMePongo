package entities;

import javax.persistence.Column;

public class Tela extends EntidadPersistente{
	@Column(name = "COMPLETAR")
	protected String nombre;
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return this.nombre;
	}
}
