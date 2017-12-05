package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class SimpleUfo extends Ufo{
	
	public SimpleUfo(int maxSpeed,int maxCountPassengers, float weight,Color color) {
		this.colorBody = color;
		this.setWeight(weight);
		this.setMaxCountPassengers(maxCountPassengers);
		this.maxSpeed = maxSpeed;
		
		Random r = new Random();
		this.posX = (r.nextInt(190) +10);
		this.posY = (r.nextInt(190) +10);
		
	}

	@Override
	public void moveCar() {
		posX +=
				(maxSpeed * 50 / weight) / 
				(countPassengers == 0 ? 1 : countPassengers);
		
	}

	@Override
	public void drawCar(Graphics g) {
		drawMotorShip(g);
		
	}
	
	protected void drawMotorShip(Graphics g) {
        //отрисовка плохой летающей тарелки
		g.setColor(Color.BLUE);
        g.fillOval(posX, posY, 200, 50);
        g.setColor(colorBody);
        g.drawLine(posX + 60, posY + 45, posX + 40, posY + 75);
        g.drawLine(posX + 130, posY + 45, posX + 150, posY + 75);
        g.setColor(Color.RED);
        g.drawLine(posX , posY+25, posX +60, posY + 30);
        g.drawLine( posX + 60, posY + 30, posX+130, posY + 30);
        g.drawLine( posX + 129, posY + 30, posX + 200, posY + 25);
		
	}

	protected void setMaxCountPassengers(int value) {
		if(value>0 && value<5) {
			super.maxCountPassengers = value;
		} else {
			super.maxCountPassengers = value;
		}
	}
	
	protected void setWeight(float value){
		if(value>500 && value<1500) {
			super.weight = value;
		} else {
			super.weight = 1000;
		}
	}

}
