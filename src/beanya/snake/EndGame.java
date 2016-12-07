package beanya.snake;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EndGame extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9221386811257252895L;
	private static String path = "image\\800bg3.jpg";
	public static void setPath(String name){
		path="image\\"+name+"jpg";
	}
	public static String getPath(){
		return path;
		
	}
	public EndGame() {
		// TODO �Զ����ɵĹ��캯�����
		
		super(new ImageIcon(getPath()));
		setSize(800,800);
		setOpaque(false);
		
		JButton restart =new JButton("Restart");
		JButton quit = new JButton("Quit");
		
		restart.setSize(300, 50);
		restart.setFont(new Font("΢���ź�",Font.BOLD,30));
		restart.setHorizontalAlignment(JTextField.CENTER);
		restart.setLocation(getWidth()/2-150,getHeight()/2-100);
		restart.setOpaque(false);
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				Game.start=true;
//				Game.start();
				Game.sleep(100);
				Game.map.dispose();
				Game.endMusic.stop();
//				try {
//					Game.endMusic.join();
//				} catch (InterruptedException e) {
//					// TODO �Զ����ɵ� catch ��
//					e.printStackTrace();
//				}
//				Game.start();
			}
		});
		
		quit.setSize(300, 50);
		quit.setFont(new Font("΢���ź�",Font.BOLD,30));
		quit.setHorizontalAlignment(JTextField.CENTER);
		quit.setLocation(restart.getX(),restart.getY()+70);
		quit.setOpaque(false);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				System.exit(0);
			}
		});
		add(restart);
		add(quit);
	}
}