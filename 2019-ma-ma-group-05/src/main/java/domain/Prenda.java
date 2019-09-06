package domain;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import domain.Tipo;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.TelaIncompatibleException;
import domain.Excepciones.ValidacionException;

public class Prenda implements Cloneable {
	private Color colorPrimario;
	private Color colorSecundario;
	private Tipo tipo;
	private String imagen;
	private ImgResizer resizer;
	private Tela tela;
	private List<LocalDate> fechasReservadas;

	public Prenda makeCopy(){
		Prenda prendaCopy = null;
		try {
			prendaCopy = (Prenda) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prendaCopy;
	}
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
	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(Color unColorSecundario) {
		if(unColorSecundario == this.colorPrimario) {
			throw new ColoresIgualesException("ERROR: Se ingresaron colores iguales"); 
		}
		else {
			this.colorSecundario = unColorSecundario;
		}
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public void setImage(String path) {
		this.resizer.copyImage(path,this);
	}
	public void setImagenResized(String path) {
		this.imagen = path;
	}
	public String getImagen() {
		return this.imagen;
	}
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public Color getColorPrimario() {
		return colorPrimario;
	}
	
	public Color getColorSecundario() {
		return colorSecundario;
	}
	
	public void validarAtributos() {
		if(Objects.isNull(colorPrimario) || this.tipo.validarAtributosDeTipo()) {
			throw new ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return this.tipo.esDeCategoria(unaCategoria);
	}
	
	public int getCapa() {
		return this.tipo.getCapa();
	}
	public Tela getTela() {	return this.tela;	}
	public void setTela(Tela unaTela) {
		if (this.tipo.estaTelaEsPosible(unaTela.getNombre())) {
			this.tela = unaTela;
		}
		else
			throw new TelaIncompatibleException("Tela no permitida");
	}
	public int getNivelAbrigo() {
		return this.tipo.getNivelAbrigo();
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
