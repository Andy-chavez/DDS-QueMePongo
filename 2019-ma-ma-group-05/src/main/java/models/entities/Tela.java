package models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tela")
public class Tela extends EntidadPersistente{

	@Column(name = "nombre")
	protected String nombre;

	public Tela(String unNombre) {
        this.setNombre(unNombre);
    }
	public Tela() {	}
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return this.nombre;
	}
}
