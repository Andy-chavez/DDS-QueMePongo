package domain;

public class SensibilidadFrio {
	private int incremento = 5;
	private int superior;
	private int inferior;
	
	public SensibilidadFrio(){
		this.superior = 0;
		this.inferior = 0;
	}
	public int getSuperior(){
		return this.superior;
	}
	public int getInferior(){
		return this.inferior;
	}
	public void aumentarSuperior(){
		this.superior += incremento;
	}
	public void aumentarInferior(){
		this.inferior += incremento;
	}
	public void disminuirSuperior(){
		this.superior -= incremento;
	}
	public void disminuirInferior(){
		this.inferior -= incremento;
	}
}
