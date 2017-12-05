package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class UfoPanel extends JPanel {
	private ITransport ship;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(ship!=null) {
			ship.drawCar(g);
		}
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip() {
		return ship;
	}
}
