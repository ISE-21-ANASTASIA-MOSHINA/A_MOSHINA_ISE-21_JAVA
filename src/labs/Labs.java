package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JList;


public class Labs {

	private JFrame frame;
	private UfoPanel panel;
	private JFormattedTextField formattedTextField;
	private JList list;
	
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
		frame.setBounds(100, 100, 1225, 970);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new UfoPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 910, 857);
		frame.getContentPane().add(panel);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(470, 901, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblColor_1 = new JLabel("Color:");
		lblColor_1.setBounds(572, 901, 46, 14);
		frame.getContentPane().add(lblColor_1);
		
		JButton bodyColorSwitcher = new JButton("");
		bodyColorSwitcher.setBackground(Color.BLUE);
		bodyColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				bodyColorSwitcher.setBackground(tmp);
			}
		});
		bodyColorSwitcher.setBounds(509, 892, 46, 23);
		frame.getContentPane().add(bodyColorSwitcher);
		
		JButton dopColorSwitcher = new JButton("");
		dopColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				dopColorSwitcher.setBackground(tmp);
			}
		});
		dopColorSwitcher.setBackground(Color.BLUE);
		dopColorSwitcher.setBounds(610, 892, 46, 23);
		frame.getContentPane().add(dopColorSwitcher);
		
		JButton btnNewButton = new JButton("MotorShip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITransport s = new SimpleUfo(50,5,100,bodyColorSwitcher.getBackground());
				panel.setShip(s);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(10, 897, 214, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UltaMegaBuffSuperMotorShip");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setShip(new MegaUfo(50,5,100,bodyColorSwitcher.getBackground(),
						true,true,dopColorSwitcher.getBackground()));
				panel.repaint();
			}
		});
		btnNewButton_1.setBounds(235, 897, 214, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		SmallShipPanel panel_1 = new SmallShipPanel();
		panel_1.setBorder(new TitledBorder(null, "\u041A\u043E\u0440\u0430\u0431\u043B\u044C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(941, 251, 244, 221);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 66, 224, 144);
		panel_1.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setShip(panel.getShip(Integer.parseInt(formattedTextField.getText())-1));
				panel_1.repaint();
				panel.repaint();
			}
		});
		btnNewButton_2.setBounds(138, 30, 83, 25);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(10, 35, 46, 14);
		panel_1.add(label);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(56, 29, 46, 20);
		panel_1.add(formattedTextField);
		//Начало создания листа с уровнями
		String[] str = new String[5];
		for(int i = 1;i<6;i++) {
			str[i-1] = "Уровень " + i; //Подготовка строк для записи в лист
		}
		list = new JList(str); //Создание объекта листа
		list.enable(false); //Отключение активности листа (чтобы можно было управлять только кнопками)
		list.setSelectedIndex(0); //Устанавливает "Уровень 1" по умолчанию
		list.setBounds(964, 47, 140, 115); //Задает размеры и позицию
		frame.getContentPane().add(list); //Добавляет на форму
		//Конец создания листа с уровнями
		
		JButton btnNewButton_3 = new JButton("<<");
		btnNewButton_3.addActionListener(new ActionListener() {
			//Метод вызывающий понижение уровня
			public void actionPerformed(ActionEvent e) {
				int select = list.getSelectedIndex();
				if(select>0) {
					list.setSelectedIndex(select - 1);
					panel.lvlDown();
					panel.repaint();
				}
			}
		});
		btnNewButton_3.setBounds(974, 173, 49, 37);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			//Метод вызывающий повышение уровня
			public void actionPerformed(ActionEvent e) {
				int select = list.getSelectedIndex();
				if(select<5) {
					list.setSelectedIndex(select + 1);
					panel.lvlUp();
					panel.repaint();
				}
				
			}
		});
		button.setBounds(1055, 173, 49, 37);
		frame.getContentPane().add(button);
	}
}
