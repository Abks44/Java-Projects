import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScoredPaint extends JPanel implements ActionListener{

	GameFrame gameFrame;
	
	JFrame frame;
	JButton enterButton;
	Timer timer;
	Random random;
	int stop = 0;
	int x1 = 250, y1 = 250;
	int x2, y2;
	int xy = 0;
	
	public ScoredPaint() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		setBackground(Color.black);
		
		random = new Random();
		
		stop = random.nextInt(45);
//		score = score * 4; 
		
		enterButton = new JButton("Enter: ");
		enterButton.addActionListener(this);
		enterButton.setFocusable(false);
		
		add(enterButton);
		
		timer = new Timer(50,  this);
		System.out.println(stop);
		
		frame.add(this);
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
	  super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		int centerX = 250;
		int centerY = 250;
		int radius = 125;
		
		g2d.setStroke(new BasicStroke(4));
		
		 x2 = (int)(centerX + radius * Math.cos(Math.toRadians(180 - xy)));
		 y2 = (int)(centerY - radius * Math.sin(Math.toRadians(180 - xy)));
		 
		Color[] colors = {
				Color.red, Color.green, Color.blue, Color.gray
		};
		
		int arcAngle1 = 0; 
		int arcAngle2 = 45;
		
		for(int i = 0; i < colors.length; i++) {
			g.setColor(colors[i]);
				
			g.fillArc(100, 100, 300, 300, arcAngle1, arcAngle2);
			
			arcAngle1 += arcAngle2;
		}
		
//		g.setColor(new Color(102, 0, 255)); // Electric Purple.
		g.setFont(new Font(null, Font.BOLD, 13));
		
		g.setColor(new Color(255, 153, 102)); //Atomic Tangerine.
		
		g.drawString("Legend", 320, 220);
		g.drawString("Pro", 280, 160);
		g.drawString("Intermidiate", 165, 160);
		g.drawString("Bigginer", 120, 210);
		
		g.setColor(new Color(0x7DF9FF));
		
		g2d.fillOval(x2 - 5, y2 - 5, 15, 15); // ball at the end of line.noted		
		g2d.drawLine(x1, y1, x2, y2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == enterButton) {
			timer.start();
		}		
		
		if(xy == stop * 4)
			timer.stop();
			
		xy += 1;
		
		repaint();
	}
	public static void main(String[] args) {
		new ScoredPaint();
	}
}