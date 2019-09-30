package entities;

import javax.persistence.*;

@Entity
@Table(name = "tela")
public class Tela extends EntidadPersistente{

	@Column(name = "nombre")
	protected String nombre;

	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return this.nombre;
	}
}
