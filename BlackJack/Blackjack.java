import java.applet.Applet;
import java.awt.*;

public class Blackjack extends Applet{
    
    public static final int PALOS=4; 
    public static final int CARTAS=52;

	Graphics noseve;
	Button boton;
	Image fondo;
	Baraja baraja;
	Mano j1;
	Image imagen;
	Image imagenes[];
	String nombres[]={"_of_clubs.png","_of_spades.png","_of_diamonds.png","_of_hearts.png"};

	
    public void init() {
    
	   	imagen = createImage(700, 800);
	   	fondo = getImage(getCodeBase(), "Baraja/tapete.jpg");
    	   
    	imagenes= new Image[CARTAS];   	
    	for(int j=0; j<PALOS; j++)
    		for(int i=0; i<13; i++)
    			imagenes[(j*13)+i] = getImage(getCodeBase(), "Baraja/" + ((i%13)+1) + nombres[j]);
    			
  		baraja= new Baraja(imagenes);
  		baraja.barajar();
  		
		j1 = new Mano();
  		
  		Panel panel= new Panel();
    	boton = new Button("Pedir");
    	panel.add(boton);
    	this.setLayout(new BorderLayout());
    	this.add("South",panel);


	}
	
	public void paint(Graphics g){
    	g.drawImage(fondo, 0, 0,this.getWidth(), this.getHeight(), this);
    	g.setColor(Color.white);   	
		g.drawString(""+ j1.puntuacion(), 100,100);
		j1.mostrarLista(g, this);
       }
    
    public boolean action(Event ev, Object obj){
    	if(ev.target instanceof Button){
    		j1.aniadir(baraja.sacaCarta());
    		repaint();
    		return true;
    	}
    	return false;
    }
}