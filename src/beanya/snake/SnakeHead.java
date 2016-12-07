package beanya.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class SnakeHead extends SnakeNode implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8576735112348964686L;

	private static int displacement = 40;
	
	private static String headName = "sh1-";							//�ڵ�ͼ������
	public SnakeHead() {
		// TODO �Զ����ɵĹ��캯�����
		super();								//�����ڵ�
		setImage(headName+3,0,0);				//�ı�ڵ�ͼ��Ĭ��Ϊ3-up
	}
	public SnakeHead(int direction) {			//������ĳ�ʼ��
		super();			
		setImage(headName+direction);
	}

	public SnakeHead(int x, int y) {			//�������ʼ��
		super(x, y);							//�����ڵ�
		setImage(headName+3);					//�ı�ڵ�ͼ��Ĭ��Ϊ3-up
	}
	public SnakeHead(int x, int y,int direction ) {
		super();
		setImage(headName+direction,x,y);
	}
	
	//��ͷ��4�����ƶ����������۾����򣨸ı�ͼƬ��
	public void right(){
		setLocation(this.getX()+40,this.getY());
		setImage(headName+1);
	}
	public void left(){
		setLocation(this.getX()-40,this.getY());
		setImage(headName+2);
	}
	public void up(){
		setLocation(this.getX(),this.getY()-40);
		setImage(headName+3);
	}
	public void down(){
		setLocation(this.getX(),this.getY()+40);
		setImage(headName+4);
	}
	
	public void borderBack(){					//��Ե����
		switch (Game.firstDirection) {
		case 1:
			setLocation(0, getY());
			break;
		case 2:
			setLocation(800-displacement,getY());
			break;
		case 3:
			setLocation(getX(), 800-displacement);
			break;
		case 4:
			setLocation(getX(), 0);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		if(Game.borderJugde(this))
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				// right();
				if (Game.firstDirection != 2)
					Game.firstDirection = 1;
				break;
			case KeyEvent.VK_UP:
				// up();
				if (Game.firstDirection != 4)
					Game.firstDirection = 3;
				break;
			case KeyEvent.VK_LEFT:
				// left();
				if (Game.firstDirection != 1)
					Game.firstDirection = 2;
				break;
			case KeyEvent.VK_DOWN:
				// down();
				if (Game.firstDirection != 3)
					Game.firstDirection = 4;
				break;
		case KeyEvent.VK_A:
			if(Game.speed>40)
			Game.speed-=20;
			break;
		case KeyEvent.VK_D:
			if(Game.speed<400)
				Game.speed+=20;
			break;

		case KeyEvent.VK_Q:
			
			break;
		default:
			break;
		}
		Game.sleep(10);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
