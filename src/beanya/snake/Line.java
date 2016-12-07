package beanya.snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class Line extends JLabel {
	public Line() {
		super();
		setSize(800, 800);
		setOpaque(false);
		setLocation(0, 0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1.0f));
		g2.setColor(Color.getHSBColor(0, 0, 0));
		

		for (int i = 0; i < 800; i += 40) {
			g2.drawLine(i , 0, i , 800);
		}
		// 画横线
		for (int i = 0; i < 800; i += 40) {
			g2.drawLine(0, i , 800, i );
		}
	}

}
