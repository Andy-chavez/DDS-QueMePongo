package domain;

import domain.Prenda;

public class Atuendo {
	private Prenda parteSuperior;
	private Prenda parteInferior;
	private Prenda calzado;
	private Prenda accesorio;
	
	public Prenda getParteSuperior(){return this.parteSuperior;}
	public Prenda getParteInferior(){return this.parteInferior;}
	public Prenda getCalzado(){return this.calzado;}
	public Prenda getAccesorio(){return this.accesorio;}
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
	public boolean compararConOtroAtuendo(Atuendo atuendo){
		if((this.parteSuperior==atuendo.parteSuperior)
				&&(this.parteInferior==atuendo.parteInferior)
				&&(this.calzado==atuendo.calzado)
				&&(this.accesorio==atuendo.accesorio)){
			return true;
		}else{return false;}
	}
}
