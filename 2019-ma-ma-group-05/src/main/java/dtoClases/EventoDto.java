package dtoClases;

import java.time.LocalDate;

import domain.Guardarropa;
import domain.Usuario;

public class EventoDto {
	public Usuario usuario;
	public String nombre;
	public String lugar;
	public LocalDate fecha;
	public Guardarropa guardarropa;
	public String tipo;
}
