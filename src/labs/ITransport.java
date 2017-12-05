package labs;

import java.awt.Graphics;

public interface ITransport {
	void moveCar();
	void drawCar(Graphics g);
	void setPosition(int x,int y);
	void loadPassenger(int count);
	int getPassenger();
}
