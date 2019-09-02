package dtoClases;

import java.time.Instant;
import domain.Guardarropa;
import domain.Usuario;
import domain.EstadosEvento.EstadoEvento;

public class EventoDto {
	public Usuario usuario;
	public String nombre;
	public String lugar;
	public String fecha;
	public Guardarropa guardarropa;
	public String tipo;
    public Integer repeticionDias;
    public Integer anticipacionHoras;
    public EstadoEvento estado;
}
