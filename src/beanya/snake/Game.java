package beanya.snake;

import java.util.ArrayList;


public class Game {
	
	public static int speed = 100;
	
	public static ArrayList<SnakeNode> snakeNodes =null;
	public static Food food = null;
	public static Wall wall = null;
	public static int score = 0;
	public static int firstDirection = 0;
	
	public static boolean start = false;
	public static boolean started=false;
	static Map map = null;
	
	static Thread startMusic = null;
	static Thread backgroundSound = null;
	static Thread endMusic = null;

	
	public static void main(String[] args) {
		do{
		
		startMenu();
		
		start();
		endMenu();
		}while(true);
		
	}
//		
	public static void startMenu(){	
		startMusic = new Thread(new Runnable(){
			public void run(){
				while(true){
					sleep(500);
					Music.Play("music\\mlbgm.wav");
				}	
				//call method 1
			}
			});
		if (!started) {		
			//初始菜单
			map = new Map();
			map.setVisible(true);
			Menu menu = new Menu();
			map.add(menu);
			startMusic.start();
		}
	}
	
	public static void endMenu(){
		endMusic = new Thread(new Runnable(){
			public void run(){
				sleep(2000);
				Music.Play("music\\GameOver.wav");
				while (true) {
					sleep(3000);
					Music.Play("music\\end.wav");
				}
			//call method 1
			}
			});
		map=new Map();
		EndGame end = new EndGame();
		map.add(end);
		map.setVisible(true); 
		endMusic.start();
	}

	public static void start(){
		while(!start){
			sleep(1);
		}
//		sleep(500);
		startMusic.stop();
		
		backgroundSound = new Thread(new Runnable(){
			public void run(){
				while(true){
				sleep(1000);
					Music.Play("music\\stat.wav");
				}
			//call method 1
			}
			});
		started =true;
		score = 0;
		snakeNodes = new ArrayList<SnakeNode>();
		map = new Map();
		sleep(100);
		
		Score scoreBord = new Score();
		initSnake();
		map.add(scoreBord);

        Line line = new Line();
        map.getLayeredPane().add(line,100);
		
		
		backgroundSound.start();
		map.setVisible(true); 
		while (true) {
			move();
			snakeNodes.get(0).moveNode();
			sleep(speed);
			if(headTouch()){
				sleep(100);
				backgroundSound.stop();
				new Thread(new Runnable(){
					public void run(){
						Music.Play("music\\dead.wav");
						sleep(5000);
					//call method 1
					}
					}).start();
				sleep(2000);
				map.dispose();
				break;
			}
			if(touchWall())
			{
				sleep(100);
				backgroundSound.stop();
				new Thread(new Runnable() {
					public void run() {
						Music.Play("music\\dead.wav");
						sleep(5000);
						// call method 1
					}
				}).start();
				sleep(2000);
				map.dispose();
				break;
			}
			if (isEat()) {
				eaten();
				new Thread(new Runnable(){
					public void run(){
//						sleep(500);
						Music.Play("music\\eat.wav");
					//call method 1
					}
					}).start();
				score++;
				scoreBord.setScore();
			}
			if (!borderJugde(snakeNodes.get(0))) {
				SnakeHead head = ((SnakeHead) snakeNodes.get(0));
				head.borderBack();
				sleep(speed);
			}
			
		}
		start=false;
	}
	
	public static void eaten(){
		map.remove(food);
		sleep(1);
		reflashFood();
		food.repaint();
		int num = (int)(Math.random()*2+2);
		snakeNodes.add(new SnakeNode(snakeNodes.get(snakeNodes.size()-1).getX(),snakeNodes.get(snakeNodes.size()-1).getY(),"sn"+num));
		map.add(snakeNodes.get(snakeNodes.size()-1));
	}
	public static void initSnake(){
		firstDirection = (int)(Math.random()*4+1);
		int headX = (int)(Math.random()*11+3)*40;
		int headY = (int)(Math.random()*11+3)*40;
		int num1 = (int)(Math.random()*2+2);
		int num2 = (int)(Math.random()*2+2);
		SnakeHead head = new SnakeHead(headX,headY);
		snakeNodes.add(head);
		switch (firstDirection){
		case 1:
			snakeNodes.add(new SnakeNode(headX-40,headY,"sn"+num1));
			snakeNodes.add(new SnakeNode(headX-80,headY,"sn"+num2));
			break;
		case 2:
			snakeNodes.add(new SnakeNode(headX+40,headY,"sn"+num1));
			snakeNodes.add(new SnakeNode(headX+80,headY,"sn"+num2));
			break;
		case 3:
			snakeNodes.add(new SnakeNode(headX,headY+40,"sn"+num1));
			snakeNodes.add(new SnakeNode(headX,headY+80,"sn"+num2));
			break;
		case 4:
			snakeNodes.add(new SnakeNode(headX,headY-40,"sn"+num1));
			snakeNodes.add(new SnakeNode(headX,headY-80,"sn"+num2));
			break;
		default:
			break;
		}
		reflashFood();
		reflashWall();
		for(SnakeNode t:snakeNodes){
			map.add(t);
		}
		map.addKeyListener(head);
	}
	public static boolean isEat(){
		sleep(1);
		return snakeNodes.get(0).touch(food);
	}
	
	public static void move(){
		for(int i=snakeNodes.size()-1;i>0;i--){
			snakeNodes.get(i).setLocation(snakeNodes.get(i-1).getLocation());
			snakeNodes.get(i).repaint();
		}
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void reflashWall(){
		do{
		int wallX = (int)(Math.random()*19)*40;
		int wallY = (int)(Math.random()*19)*40;
		wall = new Wall(wallX,wallY);
		}while(!touchBody()&&!food.touch(wall));
		map.add(wall);
	}
	
	public static void reflashFood(){
		do{
		int foodX = (int)(Math.random()*19)*40;
		int foodY = (int)(Math.random()*19)*40;
		food = new Food(foodX,foodY);
		}while(!touchBody());
		map.add(food);
	}
	public static boolean headTouch(){
		for(int i=1;i<snakeNodes.size();i++)
			if(snakeNodes.get(0).touch(snakeNodes.get(i)))
				return true;
		return false;
	}
	public static boolean touchBody(){
		for(SnakeNode t:snakeNodes)
			if(food.touch(t))
				return false;
		return true;
	}
	
	public static boolean touchWall(){
		SnakeNode head = snakeNodes.get(0);
		if(head.touch(wall))
				return true;
		return false;
	}
	
	static boolean borderJugde(SnakeNode head){
		return head.getX()>=0&&head.getY()>=0&&head.getX()<=760&&head.getY()<=760;
	}
}
