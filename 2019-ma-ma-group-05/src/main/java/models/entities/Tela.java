package models.entities;

import javax.persistence.*;

@Entity
@Table(name = "tela")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminador")
public class Tela extends EntidadPersistente{
	//TODO: hacer que cada nombre de tela sea unico para no tener repetidos
	@Column(name = "nombre")
	protected String nombre;

	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return this.nombre;
	}
}
