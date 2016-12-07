package beanya.snake;

public class Wall extends Food{
	public Wall(){
		super(2);
	}
	public Wall(int x,int y){
		super(2,x,y);
	}
}
