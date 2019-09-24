package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import domain.Tipo;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.TelaIncompatibleException;
import domain.Excepciones.ValidacionException;

@Entity
@Table(name="prenda")
public class Prenda extends EntidadPersistente  implements Cloneable {
	@Column(name = "COMPLETAR")
	private Color colorPrimario;
	@Column(name = "COMPLETAR")
	private Color colorSecundario;
	@ManyToOne
	@JoinColumn(name = "COMPLETAR", referencedColumnName = "id")
	private Tipo tipo;
	@Column(name = "COMPLETAR")
	private String imagen;
	@Transient
	private ImgResizer resizer;
	@ManyToOne
	@JoinColumn(name = "COMPLETAR", referencedColumnName = "id")
	private Tela tela;
	//TODO preguntar
	private List<LocalDate> fechasReservadas;

	public Prenda(Tipo unTipo) {
		this.setTipo(unTipo);
		this.fechasReservadas = new ArrayList<LocalDate>();
	}
	public Prenda(Tipo unTipo, Color colorPrim) {
		this(unTipo);
		this.setColorPrimario(colorPrim);
	}
	public Prenda(Tipo unTipo, Color colorPrim, Color colorSecun) {
		this(unTipo, colorPrim);
		this.setColorSecundario(colorSecun);
	}
	// --- GETTERS Y SETTERS ---
	public void setColorPrimario(Color colorPrimario) { this.colorPrimario = colorPrimario;	}
	public void setColorSecundario(Color unColorSecundario) {
		if(unColorSecundario == this.colorPrimario) {
			throw new ColoresIgualesException("ERROR: Se ingresaron colores iguales"); 
		}
		else { this.colorSecundario = unColorSecundario; }
	}
	public void setTipo(Tipo tipo) { this.tipo = tipo;	}
	public void setImage(String path) { this.resizer.copyImage(path,this);	}
	public void setImagenResized(String path) { this.imagen = path;	}
	public String getImagen() {  return this.imagen; }
	public Tipo getTipo() {	return this.tipo; 	}
	public Color getColorPrimario() { return colorPrimario;	}
	public Color getColorSecundario() {	return colorSecundario;	}
	public int getCapa() { return this.tipo.getCapa();	}
	public Tela getTela() {	return this.tela; }
	public int getNivelAbrigo() { return this.tipo.getNivelAbrigo(); }
	public void setTela(Tela unaTela) {
		if (this.tipo.estaTelaEsPosible(unaTela.getNombre())) {
			this.tela = unaTela;
		}
		else
			throw new TelaIncompatibleException("Tela no permitida");
	}
	
	public void validarAtributos() {
		if(Objects.isNull(colorPrimario) || this.tipo.validarAtributosDeTipo()) {
			throw new ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return this.tipo.esDeCategoria(unaCategoria);
	}
	
	
	// Para tests(?
	public Boolean esIgualA(Prenda otraPrenda) {
		return otraPrenda.todosLosAtributosSonIgualesA(this.tipo, this.colorPrimario, this.colorSecundario);
	}
	
	public Boolean todosLosAtributosSonIgualesA(Tipo unTipo, Color unColorPrimario, Color unColorSecundario) {
		return this.tipo.esIgualAOtro(unTipo) && unColorPrimario == this.colorPrimario && unColorSecundario == this.colorSecundario;
	}

	public Boolean esDeTipo(Tipo tipo) {
		return this.tipo.getClass() == tipo.getClass();
	}
	public Boolean noEsDeTipo(Tipo tipo){ //hago este metodo pedorro porque estaba teniendo problemas usando el de arriba en las lambda
		return !esDeTipo(tipo);
	}
	public void reservarFecha(Instant fecha){
		// casteo Instant a LocalDate porque sino es un quilombo comparar Instants porque tienen hasta milisegundos
		this.fechasReservadas.add(fecha.atZone(ZoneId.systemDefault()).toLocalDate());
	}
	public void liberarFecha(Instant fecha){
		LocalDate fechaLocalDate = fecha.atZone(ZoneId.systemDefault()).toLocalDate();
		this.fechasReservadas.removeIf(f -> f.compareTo(fechaLocalDate) == 0);
	}
	public Boolean estaReservada(Instant fecha){
		LocalDate fechaLocalDate = fecha.atZone(ZoneId.systemDefault()).toLocalDate();
		return this.fechasReservadas.contains(fechaLocalDate);
	}
}
