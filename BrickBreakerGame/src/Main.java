import java.awt.FlowLayout;

import javax.swing.JFrame;
 
public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		GameFrame gameFrame = new GameFrame();
		frame.setLayout(new FlowLayout());
		frame.add(gameFrame);
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);		
	}
}