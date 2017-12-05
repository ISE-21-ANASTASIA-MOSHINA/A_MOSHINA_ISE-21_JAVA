package labs;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SmallUfoPanel extends JPanel {
	
	private ITransport ship;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(ship!=null) {
			ship.setPosition(15, 120);
			ship.drawCar(g);
		}
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
}
