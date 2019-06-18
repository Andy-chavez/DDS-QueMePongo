package domain.Suscripciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import domain.Guardarropa;
import domain.Prenda;
import domain.Suscripcion;
import domain.Usuario;
import domain.Excepciones.LimiteDePrendasAlcanzadoException;

public class Free implements Suscripcion {
	private int limiteDePrendas;
	public Free(){
		this.inicializarVariablesDesdeConfig();
	}
	public void inicializarVariablesDesdeConfig(){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	this.limiteDePrendas=Integer.parseInt(archivoDeConfiguraciones.getProperty("limiteDePrendas"));
	}
	public int getLimiteDePrendas(){return this.limiteDePrendas;}
	public void cambiarSuscripcion(Usuario usuario,Suscripcion unaSuscripcion) {
		usuario.setSuscripcion(unaSuscripcion);
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda,Usuario usuario) {
		if(armario.cantidadDePrendas()<this.limiteDePrendas){
			armario.agregarPrenda(prenda);
		}else{
			throw new LimiteDePrendasAlcanzadoException();
		}
	}
	public List<Prenda> filtrarPrendas(List<Prenda> prendas){return prendas.subList(0,this.limiteDePrendas);}
	
}
