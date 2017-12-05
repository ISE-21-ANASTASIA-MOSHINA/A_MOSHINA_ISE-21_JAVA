package labs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Planet {
	
	ArrayList<ClassArray<ITransport>> parking; //ОБъект параметризованного класса (дженерика) 
	private int countPlaces = 20;
	private int placeSizeWidth = 220;
	private int placeSizeHeight = 160;
	private int curentLvl;
	
	public Planet(int lvls) {
		parking = new ArrayList<ClassArray<ITransport>>();
		curentLvl = 0;
		for(int i = 0;i<lvls;i++) {
			parking.add(new ClassArray<ITransport>(countPlaces,null));
		} 
	}
	
	public int putShipInParking(ITransport ship) {
		return parking.get(curentLvl).addShip(ship);
	}
	
	public ITransport getShipInParking(int ticket) {
		return parking.get(curentLvl).getShip(ticket);
	}
	
	public void drawShips(Graphics g) {
		for(int i = 0;i<countPlaces;i++) {
			ITransport ship = parking.get(curentLvl).popShip(i);
			if(ship!=null) {
				ship.setPosition(5 + i /5 * placeSizeWidth + 2, i % 5 * placeSizeHeight + 60);
				ship.drawCar(g);
			}
		}
	}

	public void drawMarking(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("L" + (curentLvl+1), (countPlaces/5)*placeSizeWidth - 70, 830);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 800);
		for(int i = 0; i < countPlaces / 5; i++) {
			for(int j = 0; j< 6;j++) {
				g.drawLine(i * placeSizeWidth, j*placeSizeHeight,
						i*placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i*placeSizeWidth, 0, i*placeSizeWidth, 800);
		}
	}
	
	//Метод повышающий уровень
	public void lvlUp() {
		if(curentLvl + 1 < parking.size()) {
			curentLvl++;
		}
	}
	//Метод понижающий уровень
	public void lvlDown() {
		if(curentLvl > 0) {
			curentLvl--;
		}
	}

	public int getCurentLvl() {
		return curentLvl;
	}
	
	
}
