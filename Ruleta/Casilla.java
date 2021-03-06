import java.awt.*;

public class Casilla extends Rectangle{
	public static final int DIM = 60;
	int valor;
	Color color;
    public Casilla(int posx, int posy, int v, Color color) {
		super(posx, posy, DIM, DIM);
    	valor = v;
    	this.color = color;
    }

    public void dibujar(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.orange);
    	g.drawRect(x, y, width, height);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		g.setColor(Color.white);
		g.drawString("" + valor, x+20, y+40);
    }
    
}