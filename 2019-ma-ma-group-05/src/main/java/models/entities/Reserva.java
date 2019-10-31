package models.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva extends EntidadPersistente{
	@Column(name = "fecha_reserva")
	private LocalDate fechaReserva;
	
	@ManyToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "prenda_id", referencedColumnName = "id")
	private Prenda prendaReservada;
	
	@ManyToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public Reserva(){};
	public Reserva(LocalDate fecha, Prenda prenda,Usuario us){
		this.fechaReserva=fecha;
		this.prendaReservada=prenda;
		this.usuario=us;
	}
	public LocalDate getFechaReserva(){return this.fechaReserva;}
	public Prenda getPrendaReservada(){return this.prendaReservada;}
	public Usuario getUsuario(){return this.getUsuario();}
	public void setFechaReserva(LocalDate fecha){this.fechaReserva=fecha;}
	public void setPrendaReservada(Prenda prenda){this.prendaReservada=prenda;}
	public void setUsuario(Usuario us){this.usuario=us;}
	
}
