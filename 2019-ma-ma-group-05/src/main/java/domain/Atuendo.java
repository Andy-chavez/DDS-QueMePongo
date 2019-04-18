package domain;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
	private Prenda parteSuperior;
	private Prenda parteInferior;
	private Prenda calzado;
	private Prenda accesorio;
	
	public void setParteSuperior(Prenda unaPrenda){
		this.parteSuperior=unaPrenda;
	}
	public void setParteInferior(Prenda unaPrenda){
		this.parteInferior=unaPrenda;
	}
	public void setCalzado(Prenda unaPrenda){
		this.calzado=unaPrenda;
	}
	public void setAccesorio(Prenda unaPrenda){
		this.accesorio=unaPrenda;
	}
	
}
