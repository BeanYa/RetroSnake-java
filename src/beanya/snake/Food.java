package beanya.snake;

public class Food extends SnakeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1164596076098063687L;
	private static String foodName1 = "apple";				//ʳ������
	private static String foodName2 = "bear";				//ʳ������
	public static String getFood(int type) {				//����ʳ������
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
		// TODO �Զ����ɵĹ��캯�����
		super();
		setImage(getFood(1));								//Ĭ��Ϊ���ص�һ��ʳ���ƻ��
	}
	public Food(int x,int y){								//����������ʳ������
		super(x,y);
		setImage(getFood(1));								//Ĭ��Ϊ���ص�һ��ʳ���ƻ��
	}
	public Food(int type){
		super();
		setImage(getFood(type));							//������type��ʳ��Ľڵ�
	}
	public Food(int type,int x,int y){
		super(x,y);
		setImage(getFood(type));							//������type��ʳ��Ľڵ㣬������x,y����
	}
}
