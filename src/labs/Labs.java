package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Labs {

	private JFrame frame;
	private JTextField maxSpeedField;
	private JTextField maxCountPassengerField;
	private JTextField weightField;
	private UfoPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labs window = new Labs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Labs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 949, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new UfoPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 902, 400);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Max speed:");
		lblNewLabel.setBounds(42, 455, 106, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMaxCountPassenger = new JLabel("Max count passenger:");
		lblMaxCountPassenger.setBounds(42, 480, 139, 14);
		frame.getContentPane().add(lblMaxCountPassenger);
		
		JLabel lblNewLabel_1 = new JLabel("Weight:");
		lblNewLabel_1.setBounds(260, 455, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(260, 477, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblColor_1 = new JLabel("Color:");
		lblColor_1.setBounds(372, 480, 46, 14);
		frame.getContentPane().add(lblColor_1);
		
		maxSpeedField = new JTextField();
		maxSpeedField.setText("50");
		maxSpeedField.setBounds(191, 452, 46, 20);
		frame.getContentPane().add(maxSpeedField);
		maxSpeedField.setColumns(10);
		
		maxCountPassengerField = new JTextField();
		maxCountPassengerField.setText("5");
		maxCountPassengerField.setColumns(10);
		maxCountPassengerField.setBounds(191, 477, 46, 20);
		frame.getContentPane().add(maxCountPassengerField);
		
		weightField = new JTextField();
		weightField.setText("100");
		weightField.setColumns(10);
		weightField.setBounds(316, 452, 46, 20);
		frame.getContentPane().add(weightField);
		
		JButton bodyColorSwitcher = new JButton("");
		bodyColorSwitcher.setBackground(Color.BLUE);
		bodyColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				bodyColorSwitcher.setBackground(tmp);
			}
		});
		bodyColorSwitcher.setBounds(316, 474, 46, 23);
		frame.getContentPane().add(bodyColorSwitcher);
		
		JButton dopColorSwitcher = new JButton("");
		dopColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				dopColorSwitcher.setBackground(tmp);
			}
		});
		dopColorSwitcher.setBackground(Color.BLUE);
		dopColorSwitcher.setBounds(417, 477, 46, 23);
		frame.getContentPane().add(dopColorSwitcher);
		
		JButton btnNewButton = new JButton("MotorShip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITransport s = new SimpleUfo(50,5,100,bodyColorSwitcher.getBackground());
				panel.setShip(s);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(530, 451, 214, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UltaMegaBuffSuperMotorShip");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITransport s = new MegaUfo(50,5,100,bodyColorSwitcher.getBackground(),
						true,true,dopColorSwitcher.getBackground());
				panel.setShip(s);
				panel.repaint();
			}
		});
		btnNewButton_1.setBounds(530, 476, 214, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MOVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.getShip().moveCar();
				panel.repaint();
			}
		});
		btnNewButton_2.setBounds(778, 450, 106, 44);
		frame.getContentPane().add(btnNewButton_2);
	}
}
