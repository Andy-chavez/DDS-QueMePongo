package domain;

import java.time.LocalDate;

public class Evento {
	private String nombre;
	private String lugar;
	private LocalDate fecha;
        private String tipo;
	
	public void setNombre(String unNombre){this.nombre=unNombre;}
	public String getNombre(){return this.nombre;}
	
	public void setLugar(String unLugar){this.lugar=unLugar;}
	public String getLugar(){return this.lugar;}
	
	public void setFecha(int anio,int  mes,int dia){this.fecha= LocalDate.of(anio, mes, dia);}
	public LocalDate getFecha(){return this.fecha;}
       
        public void setTipo(String tipo){this.tipo = tipo;}
        public String getTipo(){return this.tipo;}
}
