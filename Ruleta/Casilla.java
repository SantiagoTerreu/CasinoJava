
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.text.AttributedCharacterIterator;

public class Casilla extends Rectangle{
	public static final int DIM=60;
	int valor;
	Color color;
	public Casilla(int posX,int posY,int v,Color color){
		super(posX,posY,DIM,DIM);
		valor=v;
		this.color=color;
	}
	
	public void dibujar(Graphics g){	
		g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		g.setColor(color);
		g.fillRect(x, y, width,height);//van heredados del super
		g.setColor(Color.orange);
		g.drawRect(x, y, width,height);//van heredados del super
		g.setColor(Color.white);
		g.drawString("" + valor,x+20, y+40); 
			
	}
}
