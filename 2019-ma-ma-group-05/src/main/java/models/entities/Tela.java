package models.entities;

import javax.persistence.*;

@Entity
@Table(name = "tela")
public class Tela extends EntidadPersistente{//hacer que cada nombre de tela sea unico para no tener repetidos
	@OrderColumn(name = "nombre")
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
