package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="sensibilidad_frio")
public class SensibilidadFrio extends EntidadPersistente {
	@Transient
	private int incremento = 5;
	@Column(name = "superior")
	private int superior;
	@Column(name = "inferior")
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
