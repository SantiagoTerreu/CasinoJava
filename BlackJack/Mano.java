import java.applet.Applet;
import java.awt.*;

public class Mano{

	java.util.List<Carta> lista;

    public Mano() {
    	  	
   	lista = new java.util.ArrayList();
    	
    }
    
    public void mostrarLista(Graphics gg, Applet a, int x, int y){
      for(int i=0; i<lista.size(); i++){
		lista.get(i).setX(x+(i*30));
		lista.get(i).setY(y);
   		lista.get(i).dibujar(gg, a);}

    }
    
    public void aniadir(Carta nueva){
    		lista.add(nueva);
    }
    
    public int puntuacion(){
    	int acum=0;
    	boolean as=false;
    	
    	for(int i=0; i<lista.size(); i++){
    		acum += lista.get(i).valor;
    		if(lista.get(i).valor==1)
    			as=true;
    	}
    	if ((as) && acum <=11){
    		acum+=10;
    	}
    	return acum;
    }
    
    public boolean pasarse(){
    	return (puntuacion()>21)?true:false;
    	
    }
    
    public boolean plantcrup(){
    	return (puntuacion()>=17)?true:false;
    	
    }    
    
}

    
    
