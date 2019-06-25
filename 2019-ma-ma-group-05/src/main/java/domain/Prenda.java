package domain;

import java.awt.Color;
import java.awt.Image;
import java.util.Objects;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import domain.Tipo;
import domain.Excepciones.ColoresIgualesException;
import domain.Excepciones.ValidacionException;

public class Prenda {
	private Color colorPrimario;
	private Color colorSecundario;
	private Tipo tipo;
	private Image imagen;
	//private GuardaRopa guardaRropa;
	//public Prenda() {}

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
		this.imagen = new ImageIcon(path).getImage();
	}
	public void normalizarImg(BufferedImage img, int height, int length ) {
		//todavia no se como hacer esto, va tampoco se muy bien a que se refiere
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
	
	public Boolean deCategoria(Categoria unaCategoria) {
		return this.tipo.esDeCategoria(unaCategoria);
	}
	
	public Capa getCapa() {
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
	
}
