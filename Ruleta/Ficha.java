import java.applet.Applet;
import java.awt.*;

public class Ficha extends Rectangle{

	public static final int DIM=65;
	Image imagen;
	int posicion;
	boolean colocada=false;
    public Ficha(Image imgs) {
    	super((int)(Math.random() * 300)+360, (int)(Math.random() * 540), DIM, DIM);
    	imagen = imgs;

    }
    
    public void dibujar(Graphics gg, Applet a){
    	gg.drawImage(imagen, x, y, width, height, a);
    }   
    
    public void setX(int posx){
		x = posx-35;
		
	}
	public void setY(int posy){
		y = posy-35;
		
	}
}

    
    
