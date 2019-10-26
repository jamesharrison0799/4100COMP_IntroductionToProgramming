package chessboard;

public class Chessboard {

	public static void main(String[] args) {
		
		int dimension = 8;
		
		for(int c = 0; c < dimension; c++) {
			for(int r = 0; r < dimension; r++) {
				if(c % 2 == r % 2 ) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
