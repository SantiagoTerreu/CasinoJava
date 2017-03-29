import java.applet.Applet;
import java.awt.*;

public class Blackjack extends Applet{
    
    public static final int PALOS=4; 
    public static final int CARTAS=52;

	Graphics noseve;
	Button boton;
	Image fondo;
	Baraja baraja;
	Mano j1,crupier;
	TextField apuesta;
	Image imagen;
	Image imagenes[];
	String nombres[]={"_of_clubs.png","_of_spades.png","_of_diamonds.png","_of_hearts.png"};
	Boolean victoria=null;
	
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
		crupier = new Mano();
  		
  		Panel panel2= new Panel();
  		apuesta = new TextField("",7);
  		panel2.add(apuesta);
  		this.setLayout(new BorderLayout());
    	this.add("North",panel2);
  		
  		
  		Panel panel= new Panel();
    	boton = new Button("Pasar");
    	panel.add(boton);
    	boton = new Button("Pedir");
    	panel.add(boton);
    	boton = new Button("Plantarse");
		panel.add(boton);
		
    	this.setLayout(new BorderLayout());
    	this.add("South",panel);
    	this.add("North",panel2);



	}
	
	public void paint(Graphics g){
    	g.drawImage(fondo, 0, 0,this.getWidth(), this.getHeight(), this);
    	g.setColor(Color.white);   	
		g.drawString("CRUPIER",420,60);	
		g.drawString("JUGADOR",420,760);
    	
    	  	
		g.drawString(""+ j1.puntuacion(), 500,580);
		g.drawString(""+ crupier.puntuacion(), 500,220);
		j1.mostrarLista(g, this,330,600);
		crupier.mostrarLista(g, this,330,80);
		
		if (victoria != null){
			if(victoria == true)
		    	g.drawString("VICTORIA PARA EL JUGADOR, GANAS " + apuesta.getText() , 300,400);
		    else
		    	g.drawString("VICTORIA PARA LA BANCA, PIERDES " + apuesta.getText() , 300,400);
		}
	
       }
    
    public boolean action(Event ev, Object obj){
    	if(ev.target instanceof TextField){
    		apuesta.setEditable(false);
    		
    		j1.aniadir(baraja.sacaCarta());
    		j1.aniadir(baraja.sacaCarta());
    		crupier.aniadir(baraja.sacaCarta());
    		repaint();
    		return true;
    	}
    	if(ev.target instanceof Button){
    			    		
    		if("Pedir".equals(ev.arg)){
	    		j1.aniadir(baraja.sacaCarta());
	    		if(j1.pasarse()==true){
	    			while (crupier.plantcrup()==false){
		    					crupier.aniadir(baraja.sacaCarta());
		    			}
		    		if((j1.puntuacion()>crupier.puntuacion()) && (j1.pasarse()==false) ){
		    			victoria=true;
		    			repaint();}
		    		else{
		    			if ((crupier.puntuacion()>j1.puntuacion()) && (crupier.pasarse()==false))
		    			victoria=false;
		    			repaint();
		    			}
		    	return true;}
	    		}}
	    		
	    		
	    		
	    	if("Plantarse".equals(ev.arg)){
	    		while (crupier.plantcrup()==false){
	    					crupier.aniadir(baraja.sacaCarta());
	    			}
	    		if((j1.puntuacion()>crupier.puntuacion()) && (j1.pasarse()==false) ){
	    			victoria=true;
	    			repaint();}
	    		else{
	    			if ((crupier.puntuacion()>j1.puntuacion()) && (crupier.pasarse()==false))
	    			victoria=false;
	    			repaint();
	    			}
	    	return true;}
	    		    	
    	return false;}
    }
    	