package beanya.snake;

import java.awt.Font;

import javax.swing.JTextField;

public class Score extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3998755777506516071L;
	public Score() {
		// TODO �Զ����ɵĹ��캯�����
		super();
		setFont(new Font("΢���ź�",Font.BOLD,30));
		setText("Score : "+Game.score);
		setSize(200,40);
		setLocation(650, 0);
		setEditable(false);
		setBorder(null);
		setOpaque(false);
	}
	public void setScore(){
		setText("Score : "+Game.score);
	}
}