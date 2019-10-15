package entities;

import javax.persistence.*;

@Entity
@Table(name = "tela")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminador")
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
