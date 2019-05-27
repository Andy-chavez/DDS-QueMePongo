package domain;

import java.awt.Color;
import java.util.Objects;

public class C_Prenda {
	private Color colorPrimario;
	private Color colorSecundario;
	private Tipo tipo;
	//private GuardaRopa guardaRropa;
	//public Prenda() {}

	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(Color unColorSecundario) {
		if(unColorSecundario == this.colorPrimario) {
			throw new C_ColoresIgualesException("ERROR: Se ingresaron colores iguales"); 
		}
		else {
			this.colorSecundario = unColorSecundario;
		}
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
			throw new C_ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	public Boolean deCategoria(Categoria unaCategoria) {
		return this.tipo.esDeCategoria(unaCategoria);
	}
	
	
	// Para tests(?
	public Boolean esIgualA(C_Prenda otraPrenda) {
		return otraPrenda.todosLosAtributosSonIgualesA(this.tipo, this.colorPrimario, this.colorSecundario);
	}
	
	public Boolean todosLosAtributosSonIgualesA(Tipo unTipo, Color unColorPrimario, Color unColorSecundario) {
		return this.tipo.esIgualAOtro(unTipo) && unColorPrimario == this.colorPrimario && unColorSecundario == this.colorSecundario;
	}
	
}
