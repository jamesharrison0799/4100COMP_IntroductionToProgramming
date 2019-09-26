package evaluation;

public class OrderOfEvaluation {
	public static void main(String[] args) {
		int x,y,z;
		x = 7+3*6/2-1;
		y = 2%2+2*2-2/2;
		z = (3*9*(3+(9*3)/(3)));
		
		System.out.println("X: "+x+"\nY: "+y+"\nZ: "+z);
	}
}
