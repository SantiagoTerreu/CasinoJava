import java.applet.Applet;
import java.awt.*;

public class Baraja{
	
   public static final int CARTAS=52;
	public static Carta cartas[];
	public static int proxima=0;
   

    public Baraja(Image[] img) {  
    	 cartas= new Carta[CARTAS];
    	for(int i=0; i<CARTAS; i++)
    		cartas[i]= new Carta(img[i],(i%13 +1));

    }
    
    public static void barajar(){
    	Carta intermedia;
    	for (int i=0;i<100;i++){
	    	int pos1 =(int)(Math.random()*CARTAS);  	
	    	int pos2 =(int)(Math.random()*CARTAS);
	    	
	    	intermedia=cartas[pos1];
	    	cartas[pos1]=cartas[pos2];
	    	cartas[pos2]=intermedia;
    	}
    	
    }
    
    public static Carta sacaCarta(){
    	
    	return cartas[proxima++];
    	
    }
}

    