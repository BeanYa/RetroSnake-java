package beanya.snake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JFrame {

	private static final long serialVersionUID = 755319741165786278L;
	private static String path = "image\\800bg3.jpg";										//the path of the background 
	public static void setPath(String name){
		path="image\\"+name+"jpg";
	}
	public static String getPath(){
		return path;
		
	}
	
	public Map(){
		super("Retro Snake");																//initiate frame title	
		ImageIcon backgroundImage = new ImageIcon(path);									//load background image
		
		
		setLayout(null);
		setUndecorated(true);																//cancle the title
		setSize(800, 800);
//		setSize(backgroundImage.getIconWidth(),backgroundImage.getIconHeight());			//set the size of frame
		setLocationRelativeTo(null);														//set to center
		
//		line.paintLine(this.getGraphics());
		
		JLabel backgroundLabel = new JLabel(backgroundImage);  								// 把背景图片显示在一个标签里面
//		JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());  				// 把标签的大小位置设置为图片刚好填充整个面板  
        JPanel imagePanel = (JPanel) this.getContentPane();									// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false);  
   
        
        this.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));  		// 把背景图片添加到分层窗格的最底层作为背景  
        setFocusable(true);
       
        																	//设置可见  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  									//点关闭按钮时退出  
       
        

	}
	
	
}
