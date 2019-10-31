package models.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva extends EntidadPersistente{
	@Column(name = "fecha_reserva")
	private LocalDate fechaReserva;
	private Prenda prendaReservada;
	
	public LocalDate getFechaReserva(){return this.fechaReserva;}
	public Prenda getPrendaReservada(){return this.prendaReservada;}
	
}
