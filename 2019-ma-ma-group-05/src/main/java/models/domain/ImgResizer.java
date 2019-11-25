package models.domain;

import models.domain.ConfigReader;
import models.entities.Prenda;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

public class ImgResizer {

	private static int MAX_ANCHO = 500;
	private static int MAX_ALTO = 500;
	private static String pathEnSistema = "C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/img/";
	public ImgResizer(){
		this.MAX_ALTO = ConfigReader.getIntValue("configuraciones.properties","max_alto");
		this.MAX_ANCHO = ConfigReader.getIntValue("configuraciones.properties","max_ancho");
		this.pathEnSistema = ConfigReader.getStringValue("configuraciones.properties", "pathImagenes");
	}
	public static void copyImage(String filePath, Prenda prenda) { //guarda la imagen resizeada
        BufferedImage bimage = getImagen(filePath);
        if(bimage.getHeight()>bimage.getWidth()){
            int alto = (bimage.getHeight() * MAX_ANCHO) / bimage.getWidth();
            bimage = resize(bimage, MAX_ANCHO, alto);
            int width = (bimage.getWidth() * MAX_ALTO) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_ALTO);
        }else{
            int ancho = (bimage.getWidth() * MAX_ALTO) / bimage.getHeight();
            bimage = resize(bimage, ancho, MAX_ALTO);
            int alto = (bimage.getHeight() * MAX_ANCHO) / bimage.getWidth();
            bimage = resize(bimage, MAX_ANCHO, alto);
        }
		List<String> path = Arrays.asList(filePath.split("/"));
        String endPath = path.get((path.size()-1));
        saveImage(bimage, pathEnSistema, endPath);
        prenda.setImagenResized("/img/"+ endPath);
    }
	
	 public static BufferedImage getImagen(String pathName) { //agarra la imagen de disco
	        BufferedImage bimage = null;
	        try {
	            bimage = ImageIO.read(new File(pathName));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bimage;
	    }
	 
	 public static void saveImage(BufferedImage bufferedImage, String pathName, String endPath) { //guarda imagen a disco
	        try {
	            String format = (pathName.endsWith(".png")) ? "png" : "jpg";
	            File file =new File((pathEnSistema + endPath)); //todo
	            file.getParentFile().mkdirs();
	            ImageIO.write(bufferedImage, format, file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) { //redimensiona la imagen
	        int w = bufferedImage.getWidth();
	        int h = bufferedImage.getHeight();
	        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
	        Graphics2D g = bufim.createGraphics();
	        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
	        g.dispose();
	        return bufim;
	    }
}
