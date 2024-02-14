import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameOver extends JFrame implements ActionListener{

	JLabel label, imageLabel;
	JButton getScoreButton;
	YourScore yScore;
	GameFrame gameframe;
	ImageIcon icon;
	JLayeredPane layeredPane;
	
	public GameOver(GameFrame gameframe) {

		this.gameframe = gameframe;
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800, 700);
		getContentPane().setBackground(Color.black);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 700);
		
        ImageIcon originalIcon = new ImageIcon("GameOver.jpg");
		
		Image image = originalIcon.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);

		
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 800, 700);
		imageLabel.setIcon(icon);
		layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
		
		getScoreButton = new JButton("Get Score");
		getScoreButton.addActionListener(this);
		getScoreButton.setFocusable(false);
		getScoreButton.setBounds(310, 600, 160, 50);
		getScoreButton.setBackground(Color.white);
		getScoreButton.setForeground(new Color(255, 215, 0));
		getScoreButton.setFont(new Font(null, Font.BOLD, 20));
		layeredPane.add(getScoreButton, JLayeredPane.PALETTE_LAYER);
		
		setContentPane(layeredPane);
		
		setVisible(true); 
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getScoreButton) {
			gameframe.getScore();
			dispose();
		}
	}
}
