package domain;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConfigReader {
	public static Integer getIntValue(String configFile, String property){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream(configFile);
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuracion\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Integer.parseInt(archivoDeConfiguraciones.getProperty(property));
	}
	public static String getStringValue(String configFile, String property){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuracion\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return archivoDeConfiguraciones.getProperty(property);
	}
}
