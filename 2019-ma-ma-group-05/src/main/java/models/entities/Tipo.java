package models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import javax.persistence.*;

import converters.GenericAttributeConverter;
import models.entities.Categoria;

@Entity
@Table(name = "tipo")
public class Tipo extends EntidadPersistente{
	@Column(name = "nombre")
	protected String nombre;
	@Column(name = "capa")
	protected int capa;
	@Column(name = "nivel_abrigo")
	protected int nivelAbrigo;
	@ManyToOne(cascade = {CascadeType.ALL})
	protected Categoria categoria;
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "tela_id", referencedColumnName = "id")
	protected List<Tela> telasPosibles;

	public Tipo() {
		telasPosibles = new ArrayList<>();
	}
	public Tipo(String nombre, Categoria c,List<Tela> telaList, int capa, int abrigo){
		this.categoria = c;
		this.telasPosibles = telaList;
		this.nombre = nombre;
		this.capa = capa;
		this.nivelAbrigo = abrigo;
	}

    public Tipo(String nombre) {
        this.setNombre(nombre);
		this.telasPosibles = new ArrayList<>();
    }

    // --- GETTERS Y SETTERS ---
	public void setNivelAbrigo(int nivelAbrigo){ this.nivelAbrigo = nivelAbrigo; }
	public int getNivelAbrigo() { return this.nivelAbrigo;	}
	public int getCapa() { return this.capa;}
	public void setCapa(int capa) {	this.capa=capa; }
	public String getNombre() { return nombre;	}
	public void setNombre(String nombre) { 	this.nombre = nombre; }
	public Categoria getCategoria() { return categoria;	}
	public void setCategoria(Categoria categoria) {	this.categoria = categoria;	}
	public List<Tela> getTelasPosibles() {	return telasPosibles;	}
	public void setTelasPosibles(List<Tela> telas) {	this.telasPosibles = telas;	}

	
	public boolean estaTelaEsPosible(String nombreTela) {
		return this.getTelasPosibles().stream().anyMatch(t -> t.getNombre().equals(nombreTela));
	}
	
	public Boolean validarAtributosDeTipo() {
		return Stream.of(categoria, nombre).anyMatch(Objects::isNull);
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return this.categoria.getClass() == unaCategoria.getClass();
	}

	public boolean todosLosAtributosDeTipoSonIgualesA(String tipo) {//, Categoria unaCategoria) {
		return tipo == this.nombre;// && unaCategoria == this.categoria;
	}
	
	public boolean esIgualAOtro(Tipo otroTipo) {
		return otroTipo.todosLosAtributosDeTipoSonIgualesA(this.nombre);//, this.categoria);
	}
}
