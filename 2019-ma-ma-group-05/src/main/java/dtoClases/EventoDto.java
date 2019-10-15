package dtoClases;

import models.entities.Guardarropa;
import models.entities.Usuario;
import models.entities.EstadosEvento.EstadoEvento;

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
    public Boolean repetir;
}
