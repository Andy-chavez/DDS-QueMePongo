package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COMPLETAR")
public class SensibilidadFrio extends EntidadPersistente {
	@Column(name = "COMPLETAR")
	private int incremento = 5;
	@Column(name = "COMPLETAR")
	private int superior;
	@Column(name = "COMPLETAR")
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
