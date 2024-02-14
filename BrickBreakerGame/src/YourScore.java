import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class YourScore extends JFrame implements ActionListener{

	JLabel label, playLabel, imageLabel;
	JButton restartButton, exitButton;
	Image image;
	JLayeredPane layeredPane;
	GameFrame gameFrame;
	
	public YourScore(int score, GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.black);
		setLayout(null);
	
		try {
			image = ImageIO.read(new File("bgThanks.jpg"));
			image = image.getScaledInstance(800, 700, image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 700);
		
		
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 800, 700);
		imageLabel.setIcon(new ImageIcon(image));
		layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
		
		restartButton = new JButton("Restart");
		restartButton.addActionListener(this);
		restartButton.setFocusable(false);
		restartButton.setBounds(450, 500, 150, 60);
		restartButton.setFont(new Font(null, Font.BOLD, 20));
		restartButton.setBackground(new Color(150, 0, 255));
		restartButton.setForeground(new Color(255, 0, 0));
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setBounds(150, 500, 150, 60);
		exitButton.setFont(new Font(null, Font.BOLD, 20));
		exitButton.setBackground(new Color(150, 0, 255));
		exitButton.setForeground(new Color(255, 0, 0));
		
		label = new JLabel();
		label.setFont(new Font(null, Font.BOLD, 45));
		label.setForeground(new Color(0, 255, 0));
		label.setBounds(300, 50, 300, 40);
		
		playLabel = new JLabel();
		playLabel.setFont(new Font(null, Font.BOLD, 45));
		playLabel.setForeground(new Color(0, 255, 0));
		playLabel.setBounds(220, 150, 400, 60);
		
		label.setText("Score: " + String.valueOf(score));
		playLabel.setText("Thanks for playing");
		
		add(restartButton);
		add(exitButton);
		add(label);
		add(playLabel); 
		
		add(layeredPane);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == restartButton) {
			((JFrame)SwingUtilities.getWindowAncestor(gameFrame)).setVisible(true);
			gameFrame.resetGame();
			gameFrame.paddleTimer.restart();
			gameFrame.timer.restart();			
			dispose();
		}
		
		if(e.getSource() == exitButton)
			System.exit(0);
	}
}
