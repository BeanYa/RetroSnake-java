package beanya.snake;

public class Food extends SnakeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1164596076098063687L;
	private static String foodName1 = "apple";				//食物名称
	private static String foodName2 = "bear";				//食物名称
	public static String getFood(int type) {				//返回食物名称
		switch (type) {
		case 1:
			return foodName1;
		case 2:
			return foodName2;
		default:
			return null;
		}
	}
	public Food() {
		// TODO 自动生成的构造函数存根
		super();
		setImage(getFood(1));								//默认为返回第一种食物，即苹果
	}
	public Food(int x,int y){								//创建并设置食物坐标
		super(x,y);
		setImage(getFood(1));								//默认为返回第一种食物，即苹果
	}
	public Food(int type){
		super();
		setImage(getFood(type));							//创建第type种食物的节点
	}
	public Food(int type,int x,int y){
		super(x,y);
		setImage(getFood(type));							//创建第type种食物的节点，并设置x,y坐标
	}
}
