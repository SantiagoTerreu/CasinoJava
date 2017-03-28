import java.applet.Applet;
import java.awt.*;

public class Carta{

	Image imagen;
	int valor;
	int x,y;
	int altura=100;
	int anchura=70;

    public Carta(Image imgs, int v) {  	
    	imagen = imgs;
    	valor=(v>10)?10:v;
    		x=y=-200;
    	
    }
    
    public void dibujar(Graphics gg, Applet a){
    	gg.drawImage(imagen, x, y, anchura, altura, a);
    }   
    
}

    
    
