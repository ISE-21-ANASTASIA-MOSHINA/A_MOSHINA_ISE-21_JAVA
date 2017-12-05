package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
//Улучшенный класс
public class MegaUfo extends SimpleUfo {
	
	private boolean pipe;
	private boolean boat;
	private Color dopColor;
	public MegaUfo(int maxSpeed, int maxCountPassengers,
			float weight, Color color,boolean pipe,boolean boat,Color dopColor) {
		super(maxSpeed, maxCountPassengers, weight, color);
		this.pipe = pipe;
		this.boat = boat;
		this.dopColor = dopColor;
	}
	
	@Override
	protected void drawMotorShip(Graphics g) {
        super.drawMotorShip(g);
        if (pipe)
        {
            g.setColor(dopColor);
            g.drawOval(posX-5, posY+20, 10, 10);
            g.drawOval(posX+ 195, posY + 20, 10, 10);
            g.drawOval(posX + 90, posY + 45, 10, 10);
        }
        if (boat)
        {
            g.setColor(Color.GREEN);
            g.drawLine(posX + 95, posY , posX +110, posY -50);
            g.drawOval(posX + 105, posY -55, 10, 10);
            g.fillOval(posX + 40, posY - 20, 120, 50);
            g.setColor(dopColor);
            g.fillOval(posX + 50, posY - 10, 100, 30);
        }
	}

}
