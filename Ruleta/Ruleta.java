
import java.applet.Applet;
import java.awt.*;

public class Ruleta extends Applet{
	public static final int filas=12;
	public static final int columnas=3;
	Image imagen;
	Image imagenes[];
	
	java.util.List<Ficha> fichas;
	int num;
	Ficha activa;
	Graphics noseve;
	Casilla casillas[][];
	public int rojos[]={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
	java.util.List<Integer> lRojos;
	Button boton;
	
	public void init() {
	   	imagen = createImage(700, 800);
	   	noseve = imagen.getGraphics();
    	imagenes = new Image[10];
    	for(int i=0; i<10; i++)
    			imagenes[i] = getImage(getCodeBase(), "fichas/ficha" + (i+1) + ".png");
    	fichas = new java.util.ArrayList<Ficha>();
   		for(int i=0; i<10; i++)
			fichas.add(new Ficha(imagenes[i]));
	   	lRojos=new java.util.ArrayList<Integer>();
	   	for(int i=0;i<rojos.length;i++)
	   		lRojos.add(new Integer(rojos[i]));
	   	
	   	for(int i=0; i<10; i++)
			fichas.add(new Ficha(imagenes[i]));
			
	   	casillas=new Casilla[filas][columnas];
	   	
	   	for(int i=0;i<casillas.length;i++)
	   		for(int j=0;j<casillas[i].length;j++)
	   			if(lRojos.contains(new Integer((i*columnas)+j+1)))
	   				casillas[i][j] = new Casilla((j*Casilla.DIM)+30,(i*Casilla.DIM)+50, (i*columnas)+j+1, Color.red);
	   			else
	   				casillas[i][j] = new Casilla((j*Casilla.DIM)+30,(i*Casilla.DIM)+50, (i*columnas)+j+1, Color.black);
	   	    	Panel panel= new Panel();
    	boton = new Button("Tirar");
    	panel.add(boton);
    	this.setLayout(new BorderLayout());
    	this.add("North",panel);
	}
	public void paint(Graphics g){
    	noseve.setColor(Color.green);
    	noseve.fillRect(0, 0, 700, 800);
    	for(int i=0;i<casillas.length;i++)
	   		for(int j=0;j<casillas[i].length;j++)
    			casillas[i][j].dibujar(noseve);

    	g.drawImage(imagen, 0, 0, this);
    	g.setColor(Color.black);
    	g.drawString(num+"", 20, 20);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	
    		for(int i=0; i<fichas.size(); i++)
    			if(fichas.get(i).contains(x, y)){
    				activa=fichas.get(i);
    			}
    	return true;
    }
    

    public boolean mouseDrag(Event ev, int x, int y){		  	
    	if (activa.colocada!=true){
    	for(int i=0; i<fichas.size(); i++)
    		if((fichas.get(i).contains(x, y))){
    			activa.setX(x);
    			activa.setY(y);
    			repaint();	
    		}}
    	return true;
    }
    
    public boolean action(Event ev, Object obj){
    	if(ev.target instanceof Button){
			int tirada= (int)(Math.random() * 37);
			num=tirada;	
    		repaint();
    		return true;
    	}
    	return false;
    }


}
