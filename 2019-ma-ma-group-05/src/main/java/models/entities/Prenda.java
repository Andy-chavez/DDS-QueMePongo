package models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import models.domain.Excepciones.*;
import models.domain.ImgResizer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Table(name="prenda")
public class Prenda extends EntidadPersistente  implements Cloneable{
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ColorPersistible> colores;
	@Column(name = "imagen")
	private String imagen;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
	private Tipo tipo;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
	@JoinColumn(name = "tela_id", referencedColumnName = "id")
	private Tela tela;
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Reserva> reservas;
	
	public Prenda() {}
	public Prenda(Tipo unTipo) {
		this.setTipo(unTipo);
		this.reservas = new ArrayList<Reserva>();
		this.colores = new ArrayList<ColorPersistible>();
        this.colores.add(0,null);
		this.colores.add(1,null);
	}
	public Prenda(Tipo unTipo, ColorPersistible colorPrim) {
		this(unTipo);
		this.setColorPrimario(colorPrim);
	}
	public Prenda(Tipo unTipo, ColorPersistible colorPrim, ColorPersistible colorSecun) {
		this(unTipo, colorPrim);
		this.setColorSecundario(colorSecun);
	}
	// --- GETTERS Y SETTERS ---
    public List<ColorPersistible> getColores(){ return this.colores;}
    public void setColores(List<ColorPersistible> nuevaLista){
	    this.colores.clear();
	    this.colores.addAll(nuevaLista);
	}
	public void setColorPrimario(ColorPersistible colorPrimario) { this.colores.add(0,colorPrimario); }
	public void setColorSecundario(ColorPersistible unColorSecundario) {
		if(unColorSecundario == this.getColorPrimario()) {
			throw new ColoresIgualesException("ERROR: Se ingresaron colores iguales");
		}
		else { this.colores.add(1,unColorSecundario); }
	}
	public void setTipo(Tipo tipo) { this.tipo = tipo;	}
	public void setImage(String path) { ImgResizer.copyImage(path,this);	}
	public void setImagenResized(String path) { this.imagen = path;	}
	public String getImagen() {  return this.imagen; }
	public Tipo getTipo() {	return this.tipo; 	}
	public ColorPersistible getColorPrimario() { return this.colores.get(0);	}
	public ColorPersistible getColorSecundario() {
	    if(this.getColores().size()>1)
            return this.colores.get(1);
	    else
	        return null;
	}
	public int getCapa() { return this.tipo.getCapa();	}
	public Tela getTela() {	return this.tela; }
	public int getNivelAbrigo() { return this.tipo.getNivelAbrigo(); }
	public void setTela(Tela unaTela) {
		if (this.tipo.estaTelaEsPosible(unaTela.getNombre())) {
			this.tela = unaTela;
		}
		else
			throw new TelaIncompatibleException("Tela no permitida");
	}
	
	public void validarAtributos() {
		if(Objects.isNull(this.getColorPrimario()) || this.tipo.validarAtributosDeTipo()) {
			throw new ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return this.tipo.esDeCategoria(unaCategoria);
	}

	public void agregarAbrigoCategoria(Atuendo atuendo){
		this.getCategoria().agregarAbrigoCategoria(atuendo, this);
	}
	
	// Para tests(?
	public Boolean esIgualA(Prenda otraPrenda) {
		return otraPrenda.todosLosAtributosSonIgualesA(this.tipo, this.getColorPrimario(), this.getColorSecundario());
	}

	public Boolean todosLosAtributosSonIgualesA(Tipo unTipo, ColorPersistible unColorPrimario, ColorPersistible unColorSecundario) {
		return this.tipo.esIgualAOtro(unTipo) && unColorPrimario == this.getColorPrimario() && unColorSecundario == this.getColorSecundario();
	}

	public Boolean esDeTipo(Tipo tipo) {
		return this.tipo.getClass() == tipo.getClass();
	}
	public Boolean noEsDeTipo(Tipo tipo){ //hago este metodo pedorro porque estaba teniendo problemas usando el de arriba en las lambda
		return !esDeTipo(tipo);
	}
	public void reservarFecha(Instant fecha,Usuario us){
		// casteo Instant a LocalDate porque sino es un quilombo comparar Instants porque tienen hasta milisegundos
		//this.fechasReservadas.add(fecha.atZone(ZoneId.systemDefault()).toLocalDate());
		this.reservas.add(new Reserva(fecha.atZone(ZoneId.systemDefault()).toLocalDate(),this,us));
	}
	public void liberarFecha(Instant fecha){
		LocalDate fechaLocalDate = fecha.atZone(ZoneId.systemDefault()).toLocalDate();
		//this.fechasReservadas.removeIf(f -> f.compareTo(fechaLocalDate) == 0);
		this.reservas.removeIf(reserva -> reserva.getFechaReserva().compareTo(fechaLocalDate)==0);
	}
	public Boolean estaReservada(Instant fecha){
		LocalDate fechaLocalDate = fecha.atZone(ZoneId.systemDefault()).toLocalDate();
		//return this.fechasReservadas.contains(fechaLocalDate);
		return this.reservas.stream().anyMatch(reserva -> reserva.getFechaReserva().equals(fechaLocalDate));
	}
	public Categoria getCategoria(){
		return this.getTipo().getCategoria();
	}
}