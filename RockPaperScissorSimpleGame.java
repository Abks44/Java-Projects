import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorSimpleGame {
public static void main(String[]args) {
	
	Scanner scanner = new Scanner(System.in);

	
	while(true) {
	String [] rps = {"r", "p", "s"};
	String computerMove = rps[new Random().nextInt(rps.length)];
	
	String playerMove;
	
	while(true) {
		System.out.println("Please enter your move (r,p, or s)");
		playerMove = scanner.nextLine();
		if(playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
			break;
		}else {
			System.out.println(playerMove + " is not valid");
		}
	}
	
	System.out.println("Computer move: " + computerMove);
	
	if(playerMove.equals(computerMove)) {
		System.out.println("The game is tie!");
	}else if(playerMove.equals("r")) {
		if(computerMove.equals("p")) {
			System.out.println("You lose!");
		}else if(computerMove.equals("s")) {
			System.out.println("You Win!");
		}
	}
	else if(playerMove.equals("p")) {
		if(computerMove.equals("r")) {
			System.out.println("You Win!");
		}else if(computerMove.equals("s")) {
			System.out.println("You Lose!");
		}
	}
	else if(playerMove.equals("s")) {
		if(computerMove.equals("p")) {
			System.out.println("You Win!");
		}else if(computerMove.equals("r")) {
			System.out.println("You Lose!");
		}
	}
	
	System.out.println("Play again? (y/n)");
	String yn = scanner.next();
	if(yn.equals("n")) {
		break;
	}else if(yn.equals("y")) {
		continue;
	}
	else {
		while(true) {
			if(!yn.equals("y") || yn.equals("n")) {
				System.out.println("Not valid");
				break;
			}
		}
	}
	}
	scanner.close();
}
}
