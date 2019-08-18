package domain;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImgResizer {

	private static int MAX_ANCHO=800;
	private static int MAX_ALTO=800;
	private static String pathEnSistema; //habria que obtenerlo del sistema?
	
	public void copyImage(String filePath, Prenda prenda) { //guarda la imagen resizeada
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
        saveImage(bimage, pathEnSistema);
        prenda.setImagenResized(bimage);
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
	 
	 public static void saveImage(BufferedImage bufferedImage, String pathName) { //guarda imagen a disco
	        try {
	            String format = (pathName.endsWith(".png")) ? "png" : "jpg";
	            File file =new File(pathName);
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
