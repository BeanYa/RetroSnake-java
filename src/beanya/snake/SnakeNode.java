package beanya.snake;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SnakeNode extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925137521670857598L;
	private String path = "image\\40sn2.png";						//�ڵ�ͼ��·��
	public void setPath(String path) {
		this.path = path;
	}
	private Icon nodeImage = new ImageIcon(path);				//�ڵ�ͼ��
	
	public SnakeNode() {										//��ʼ��
		// TODO �Զ����ɵĹ��캯�����
		super();												
		setIcon(nodeImage);										//����ͼ��
		setSize(nodeImage.getIconWidth(), nodeImage.getIconHeight());	//����ͼ���С
		setLocation(0, 0);										//Ĭ��λ��(0,0)
	}
	
	public SnakeNode(int x,int y){								//��(x,y)�����ڵ�
		this();
		setLocation(x, y);
	}
	
	public SnakeNode(String otherName) {						//������ͼ���ʼ���ڵ�
		this();
		setImage(otherName);
	}
	
	public SnakeNode(int x,int y,String otherName) {			//���������Ҹı�Ĭ��ͼ��
		this(x, y);
		setImage(otherName);
	}
	
	public void setImage(String name) {							//����ͼ���������ýڵ�ͼ��  ����Ϊ 40+�ļ���+.png 40Ϊͼ��ߴ�
		setPath("image\\40"+name+".png");
		nodeImage = new ImageIcon(path);
		setIcon(nodeImage);
	}
	
	public void setImage(String name,int x,int y) {				//����ͼ�񲢸ı����� ,����setImage
		setPath("image\\40"+name+".png");
		setImage(name);
		setLocation(x,y);
	}
	
	public void moveNode(){
		switch (Game.firstDirection) {
		case 1:
			right();
			break;
		case 2:
			left();
			break;
		case 3:
			up();
			break;
		case 4:
			down();
			break;
		default:
			break;
		}
	}
	
	
	//�ڵ��������λ��40�����أ��ƶ�
	public void right(){
		setLocation(this.getX()+40,this.getY());
	}
	public void left(){
		setLocation(this.getX()-40,this.getY());
	}
	public void up(){
		setLocation(this.getX(),this.getY()-40);
	}
	public void down(){
		setLocation(this.getX(),this.getY()+40);
	}
	
	public boolean touch(SnakeNode other) {						//�ж�һ�ڵ��Ƿ�����һ�ڵ��غ�
		return (this.getX()==other.getX()) && (this.getY()==other.getY());		
	}
}
