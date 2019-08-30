package domain;

import java.awt.Color;
import java.awt.Image;
import java.util.Objects;
import java.awt.image.BufferedImage;

import domain.Tipo;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.ValidacionException;

public class Prenda implements Cloneable {
	private Color colorPrimario;
	private Color colorSecundario;
	private Tipo tipo;
	private BufferedImage imagen;
	private ImgResizer resizer;


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
	
	public Prenda(Tipo unTipo, Color colorPrim) {
		this.setTipo(unTipo);
		this.setColorPrimario(colorPrim);
	}
	public Prenda(Tipo unTipo, Color colorPrim, Color colorSecun) {
		this.setTipo(unTipo);
		this.setColorPrimario(colorPrim);
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
	public void setImagenResized(BufferedImage b) {
		this.imagen = b;
	}
	public Image getImagen() {
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
	
}
