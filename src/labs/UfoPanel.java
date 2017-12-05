package labs;

import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UfoPanel extends JPanel {
	private ITransport ship;
	private Planet parking;
	private Logger logger;
	
	public UfoPanel() {
		super();
		parking = new Planet(5);
		logger = Logger.getGlobal();
		
	}
	//Обрабока исключения переполнения
	@Override
	public void paint(Graphics g) {
		if(ship!=null) {
			try {
				parking.putShipInParking(ship);
				logger.info("Корабль добавлен в доки");
			} catch (PlanetOverflowException e) {
				logger.info(e.getMessage());
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    e.getMessage(),
					    JOptionPane.ERROR_MESSAGE);
			} catch(Exception e) {
				logger.info(e.getMessage());
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    e.getMessage(),
					    JOptionPane.ERROR_MESSAGE);
			}
			ship = null;
		}
		super.paint(g);
		parking.drawMarking(g);
		parking.drawShips(g);
	}
	
	public void lvlUp() {
		parking.lvlUp();
	}
	
	public void lvlDown() {
		parking.lvlDown();
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	//Обработка исключения отсутсвия тарелки по индексу
	public ITransport getShip(int index) {
		try {
			ITransport ship = parking.getShipInParking(index);
			logger.info("Взята тарелка под номером: " + index);
			return ship;
		} catch (PlanetIndexOutOfRangeException e) {
			logger.info(e.getMessage());
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    e.getMessage(),
				    JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			logger.info(e.getMessage());
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    e.getMessage(),
				    JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	public void loadParking(String fileName) {
		this.parking.loadData(fileName);
		repaint();
	}
	
	
	public void saveParking(String fileName) {
		this.parking.saveData(fileName);
		repaint();
	}
}
