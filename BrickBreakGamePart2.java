import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class MapGenerator{
	
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int col) {
		map = new int [row][col];
		for(int i = 0;i<map.length;i++) {
			for(int j = 0;j<map[0].length;j++) {
				map[i][j] = 1;
			}
		}
		brickWidth = 540/col;
		brickHeight = 150/row;		
	}
	
	public void draw(Graphics2D g) {
		for(int i = 0;i<map.length;i++) {
			for(int j = 0;j<map[0].length;j++) {
				if(map[i][j] > 0) {
					g.setColor(new Color(0XFF8787));
					g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(4));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}
}
class GamePlay extends JPanel implements ActionListener, KeyListener{
		private boolean play = true;
		private int score = 0;
		
		private int totalBricks = 21;
		
		private Timer timer;
		private int delay = 8;
		
		private int playerX = 310;
		
		private int ballposX = 120;
		private int ballposY = 350;
		private int ballXdir = -1;
		private int ballYdir = -2;
		
		private MapGenerator map;
		
		public GamePlay() {
			map = new MapGenerator(3, 7);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer = new Timer(delay, this);
			timer.start();
		}
		
		public void paint(Graphics g) {
			g.setColor(Color.yellow);
			g.fillRect(1, 1, 692, 592);
			
				map.draw((Graphics2D)g);
				g.fillRect(0, 0, 3, 592);
				g.fillRect(0, 0, 692, 3);
				g.fillRect(691, 0, 3, 592);
				
				g.setColor(Color.blue);
				g.fillRect(playerX, 550, 100, 12);
				
				g.setColor(Color.red);
				g.fillOval(ballposX, ballposY, 20, 20);
				
				g.setColor(Color.black);
				g.setFont(new Font("MV boli", Font.BOLD,25));
				g.drawString("Score: " + score, 520,30);
				
				if(totalBricks <= 0) {
					play = false;
					ballXdir = 0;
					ballYdir = 0;
					g.setColor(new Color(0xff6464));
					g.setFont(new Font("MV boli", Font.BOLD,30));
					g.drawString("you Won, Score: " + score, 190, 300);
					
					g.setFont(new Font("MV boli", Font.BOLD, 20));
					g.drawString("Press enter to  Restart.", 230, 350);
				}
				
				if(ballposY > 570) {
					play = false;
					ballXdir = 0;
					ballYdir = 0;
					g.setColor(Color.black);
					g.setFont(new Font("MV boli", Font.BOLD, 30));
					g.drawString("Game Over, Score: " + score, 190, 300);
					
					g.setFont(new Font("MV boli", Font.BOLD, 20));
					g.drawString("Press Enter to Restart", 230, 350);
				}
				g.dispose();
		}
		
		@Override

		public void actionPerformed(ActionEvent arg0) {
			timer.start();
			if(play) {
				if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
					ballYdir = -ballYdir;
				}
				for(int i = 0;i<map.map.length;i++) {
					for(int j =0;i<map.map[0].length;j++) {
						if(map.map[i][j] > 0) {
							int brickX = j * map.brickWidth + 80;
							int brickY = i * map.brickHeight + 50;
							int brickWidth = map.brickHeight;
							int brickHeight = map.brickHeight;
							
							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20 );
							Rectangle brickRect = rect;
							
							if(ballRect.intersects(brickRect)) {
								map.setBrickValue(0, i, j);
								totalBricks--;
								score+=5;
								
								if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width);
								ballXdir = -ballXdir;}// delete may.
								else {
									ballYdir = -ballYdir;
								}
							}
						}
					}
				}
				
				ballposX += ballXdir;
				ballposY += ballYdir;
				if(ballposX < 0) {
					ballXdir = -ballXdir;
				}if(ballposY < 0) {
					ballYdir = -ballYdir;
				}if(ballposX > 670) {
					ballXdir = -ballXdir;
				}
				
				repaint();
			}
		
		@Override
		public void keyTyped(KeyEvent arg0) {

		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(playerX >= 600) {
					playerX = 600;
				}else {
					moveRight();
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				if(playerX < 10) {
					playerX = 10;
				}else {
					moveLeft();
				}
			}
			
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				if(!play) {
					play = true;
					ballposX = 120;
					ballposY = 350;
					ballXdir = -1;
					ballYdir = -2;
					score = 0;
					totalBricks = 21;
					map = new MapGenerator(3, 7);
					
					repaint();
				}
			}
		}
		
		public void moveRight() {
			play = true;
			playerX +=50;
		}
		public void moveLeft() {
			play = true;
			playerX -= 50;
		}
			
		
		@Override
		public void keyRealeased(KeyEvent arg0) {
		}
		
		}

		

public class BrickBreakGamePart2 {
public static void main(String[]args) {
	JFrame obj = new JFrame();
	GamePlay gameplay = new GamePlay();
	obj.setBounds(10, 10, 700, 700);
	obj.setTitle("Brick breaker");
	obj.setResizable(false);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	obj.add(gameplay);
	
}
}
