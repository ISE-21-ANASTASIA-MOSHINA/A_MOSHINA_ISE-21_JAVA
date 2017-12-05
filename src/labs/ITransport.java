package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
//Объект который необходимо сериализовать должен имплементировать интерфейс Serializable
//В данном случае общий для всех тарелок интерфейс ITransport наследуется от Serializable
//Таким образом всё классы имплементирующие ITransport сразу же имплементируют Serializable
public interface ITransport extends Serializable {
	void moveCar();
	void drawCar(Graphics g);
	void setPosition(int x,int y);
	void loadPassenger(int count);
	int getPassenger();
	void setBodyColor(Color c);
}
