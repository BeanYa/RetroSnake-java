package beanya.snake;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SnakeNode extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925137521670857598L;
	private String path = "image\\40sn2.png";						//节点图像路径
	public void setPath(String path) {
		this.path = path;
	}
	private Icon nodeImage = new ImageIcon(path);				//节点图像
	
	public SnakeNode() {										//初始化
		// TODO 自动生成的构造函数存根
		super();												
		setIcon(nodeImage);										//设置图像
		setSize(nodeImage.getIconWidth(), nodeImage.getIconHeight());	//设置图像大小
		setLocation(0, 0);										//默认位置(0,0)
	}
	
	public SnakeNode(int x,int y){								//在(x,y)创建节点
		this();
		setLocation(x, y);
	}
	
	public SnakeNode(String otherName) {						//以其他图像初始化节点
		this();
		setImage(otherName);
	}
	
	public SnakeNode(int x,int y,String otherName) {			//设置坐标且改变默认图像
		this(x, y);
		setImage(otherName);
	}
	
	public void setImage(String name) {							//根据图像名字设置节点图像  参数为 40+文件名+.png 40为图像尺寸
		setPath("image\\40"+name+".png");
		nodeImage = new ImageIcon(path);
		setIcon(nodeImage);
	}
	
	public void setImage(String name,int x,int y) {				//设置图像并改变坐标 ,调用setImage
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
	
	
	//节点向各方向单位（40个像素）移动
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
	
	public boolean touch(SnakeNode other) {						//判断一节点是否与另一节点重合
		return (this.getX()==other.getX()) && (this.getY()==other.getY());		
	}
}
