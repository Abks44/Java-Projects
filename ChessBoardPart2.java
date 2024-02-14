
public class ChessBoardPart2 {
public static void main(String []args) {
	String [][] board = new String[8][8];
	
	for(int i = 0; i < 8;i++) {
		for(int j = 0; j<8;j++) {
			board[i][j] = " ";
		}
	}
	
	
	//set up the Pieces.
	
	board[0][0] = "R";
	board[0][1] = "K";
	board[0][2] = "B";
	board[0][3] = "Q";
	board[0][4] = "K";
	board[0][5] = "B";
	board[0][6] = "K";
	board[0][7] = "R";
	
	for(int i = 0;i<8;i++) {
		board[1][i] = "P";
		board[6][i] = "P";
	}
	
	board[7][0] = "R";
	board[7][1] = "K";
	board[7][2] = "B";
	board[7][3] = "Q";
	board[7][4] = "K";
	board[7][5] = "B";
	board[7][6] = "K";
	board[7][7] = "R";

	
	for(int i = 0;i<8;i++) {
		System.out.print(8- i + "  ");
		for(int j = 0;j < 8;j++ ) {
			System.out.print("|" + board[i][j] );
		}
		System.out.println("|");
	}
	
	
	
	
	
}
}
