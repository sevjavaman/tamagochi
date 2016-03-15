import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tamagochi extends JPanel {
	JFrame f;
	JPanel p;
	int action;

	public static void main(String[] args) {
		new Tamagochi();
	}

	Tamagochi() {
		f = new JFrame();
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createGridBagLayout();

		f.setVisible(true);
	}

	public void createGridBagLayout() {
		// создать объект менеджера компоновки
		GridBagLayout gbl = new GridBagLayout();
		f.setLayout(gbl);

		// создать вспомогательный объект для размещения отдельных компонент
		GridBagConstraints c = new GridBagConstraints();

		// значения полей для отдельных компонент
		// выравнивание компоненты внутри пространства
		c.anchor = GridBagConstraints.NORTH;
		// как компонента занимает отведенное пространство
		c.fill = GridBagConstraints.HORIZONTAL;
		// сколько ячеек займет компонента по высоте
		c.gridheight = 1;
		// сколько ячеек займет компонента по ширине
		c.gridwidth = 1;
		// отступы компоненты от полей
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 4;// для кнопки "b7"
		this.setPreferredSize(new Dimension(300, 300));
		this.setMinimumSize(new Dimension(300, 300));
		gbl.setConstraints(this, c);
		f.add(this);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		JButton b1 = new JButton("Играть");
		gbl.setConstraints(b1, c);
		f.add(b1);

		c.gridx = 0;
		c.gridy = 1;
		JButton b2 = new JButton("Туалет");
		gbl.setConstraints(b2, c);
		f.add(b2);

		c.gridx = 0;
		c.gridy = 2;
		JButton b3 = new JButton("Стричь когти");
		gbl.setConstraints(b3, c);
		f.add(b3);

		c.gridx = 0;
		c.gridy = 3;
		JButton b7 = new JButton("Говорить");
		b7.addActionListener(new B7Listener());
		gbl.setConstraints(b7, c);
		f.add(b7);

		c.gridx = 5;
		c.gridy = 0;
		JButton b4 = new JButton("Читать");
		b4.addActionListener(new B4Listener());
		gbl.setConstraints(b4, c);
		f.add(b4);

		c.gridx = 5;
		c.gridy = 1;
		JButton b5 = new JButton("Охотиться");
		gbl.setConstraints(b5, c);
		f.add(b5);

		c.gridx = 5;
		c.gridy = 2;
		JButton b6 = new JButton("Праздновать");
		gbl.setConstraints(b6, c);
		f.add(b6);
		
		
		c.gridx = 5;
		c.gridy = 3;
		JButton b8 = new JButton("Праздновать");
		gbl.setConstraints(b8, c);
		f.add(b8);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 5;
		JLabel lm = new JLabel("Привет! Я твой питомец, позаботься обо мне :)");
		gbl.setConstraints(lm, c);
		f.add(lm);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 200);

		ImageIcon i1 = new ImageIcon(getClass().getResource(
				"img/chihuahua-icon.png"));
		Image tam = i1.getImage();
		g.drawImage(tam, getWidth() / 2, getHeight() / 2, 90, 90, null);

		// какая кнопка была нажата
		switch (action) {
		case 4:
			ImageIcon i4 = new ImageIcon(getClass().getResource(
					"img/books-icon.png"));
			Image img4 = i4.getImage();
			g.drawImage(img4, getWidth() / 2 - 50, getHeight() / 2 - 50, 50,
					50, null);
			break;
			
		case 7:
			g.setColor(Color.BLACK);
			g.drawString("ГАВ_ГАВ", getWidth() / 2 - 50, getHeight() / 2 - 50);
			break;
		}

	}

	// слушатель кнопки "Читать"
	class B4Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			action = 4;
			repaint();
		}

	}

	// слушатель кнопки "Говорить"
	class B7Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			action = 7;
			repaint();
		}

	}

}
