package beanya.snake;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8475625062865823572L;
	private static String path = "image\\800bg3.jpg";
	public static void setPath(String name){
		path="image\\"+name+"jpg";
	}
	public static String getPath(){
		return path;
		
	}
	public static JButton newButton(String thing){
		JButton t =new JButton(thing);
		t.setSize(300, 50);
		t.setFont(new Font("微软雅黑",Font.BOLD,30));
		t.setHorizontalAlignment(JTextField.CENTER);
		t.setOpaque(false);
		return t;
	}
	public Menu() {
		// TODO 自动生成的构造函数存根
		
		super(new ImageIcon(getPath()));
		setSize(800,800);
		setOpaque(false);
		
		JButton start =newButton("Start Game");
		JButton quit = newButton("Quit");
		

		start.setLocation(getWidth()/2-150,getHeight()/2-100);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				Game.start=true;
				Game.map.dispose();
				System.out.println("restart");
//				Game.backgroundSound.stop();
			}
		});
		quit.setLocation(start.getX(),start.getY()+70);
		quit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		add(start);
		add(quit);
	}
}