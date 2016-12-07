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
		
		JLabel backgroundLabel = new JLabel(backgroundImage);  								// �ѱ���ͼƬ��ʾ��һ����ǩ����
//		JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());  				// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        JPanel imagePanel = (JPanel) this.getContentPane();									// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
        imagePanel.setOpaque(false);  
   
        
        this.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));  		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        setFocusable(true);
       
        																	//���ÿɼ�  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  									//��رհ�ťʱ�˳�  
       
        

	}
	
	
}
