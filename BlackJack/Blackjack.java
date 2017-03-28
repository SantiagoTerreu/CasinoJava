import java.applet.Applet;
import java.awt.*;

public class Blackjack extends Applet{
    
    public static final int PALOS=4; 
    public static final int CARTAS=52;

	Graphics noseve;
	Baraja baraja;
	Image imagen;
	Image imagenes[];
	String nombres[]={"_of_clubs.png","_of_spades.png","_of_diamonds.png","_of_hearts.png"};
	
    public void init() {
    	
	   	imagen = createImage(700, 800);
	   	noseve = imagen.getGraphics();
    	   
    	imagenes= new Image[CARTAS];   	
    	for(int j=0; j<PALOS; j++)
    		for(int i=0; i<13; i++)
    			imagenes[(j*13)+i] = getImage(getCodeBase(), "Baraja/" + ((i%13)+1) + nombres[j]);
    			
  		baraja= new Baraja(imagenes);
  		baraja.barajar();


	}
	
	public void paint(Graphics g){
    	noseve.setColor(Color.green);
    	noseve.fillRect(0, 0, 700, 800); 
    	g.setColor(Color.black);
    	baraja.cartas[8].dibujar(g, this);
        }
    
    
}