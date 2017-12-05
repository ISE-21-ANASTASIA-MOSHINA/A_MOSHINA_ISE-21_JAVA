package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class UfoPanel extends JPanel {
	private ITransport ship;
	private Planet parking;
	
	public UfoPanel() {
		super();
		parking = new Planet();
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		parking.drawMarking(g);
		if(ship!=null) {
			parking.putShipInParking(ship);
			ship = null;
		}
		parking.drawShips(g);
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip(int index) {
		return parking.getShipInParking(index);
	}
}
