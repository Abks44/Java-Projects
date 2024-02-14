import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {

	ScoredPaint sp;
	Image image;
	ImageIcon imageIcon1, imageIcon2;
	JLabel labelImage;
	int count = 0;
	YourScore scored;
	boolean flag = false;
	int score = 0;
	int scoreStored;
    int moveWidth = 350;
    int paddleHeight = 630;
    int ballX = 100;
    int ballY = 100;
    int velocityX = 40;
    int velocityY = 40;
    int height;
    int width;
    int numberOfBricks = 32; 
    int brickWidth = 80;
    int brickHeight = 30;
    int brickPositionX;
    int brickPositionY;
    int bricksInRow;
    int brickRows;
    boolean[][] bricks; // 2D array to track the presence of bricks
    Timer timer, delay, paddleTimer;
    YourScore yScore;
    GameOver gameOver;
    boolean isLeftKeyPressed = false;
    boolean isRightKeyPressed = false;
    JLayeredPane layeredPane;
    
    GameFrame() {  
//    	setLayout(null);
        setPreferredSize(new Dimension(800, 700));
        timer = new Timer(10, this);
        delay = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				
				if(count > 2) {
		    		delay.stop();
		        	gameEnd();
		        	getScore();
		    	}
			}
		});
      
      imageIcon1 = new ImageIcon("Game Win.jpg");
      image = imageIcon1.getImage().getScaledInstance(800, 700, image.SCALE_SMOOTH);
      imageIcon2 = new ImageIcon(image);
      
      layeredPane = new JLayeredPane();
      layeredPane.setBounds(0, 0, 800, 700);
      
      labelImage = new JLabel(imageIcon2);
      labelImage.setBounds(0, 0, 800, 700);
      labelImage.setVisible(false);
      layeredPane.add(labelImage);

      
        paddleTimer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(isLeftKeyPressed && moveWidth > 0) {
				moveWidth -= 10;
			}
			
			if(isRightKeyPressed && moveWidth <= width - 100) {
				moveWidth += 10;
			}
			
			repaint();
			}
		});
        setBackground(Color.black);
        
        // Initialize the bricks array
        brickRows = 5;
        bricksInRow = 9;
        bricks = new boolean[brickRows][bricksInRow];
        for (int row = 0; row < brickRows; row++) {
            for (int col = 0; col < bricksInRow; col++) {
                bricks[row][col] = true; // All bricks are initially present
            }
        }

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
//                handleKeyEvent(e);
            	int key = e.getKeyCode();
            	
            	switch(key) {
            	case KeyEvent.VK_LEFT:
            	isLeftKeyPressed = true;
            	break;
            	
            	case KeyEvent.VK_RIGHT:
            		isRightKeyPressed = true;
            		break;
            	}
            }

            public void keyReleased(KeyEvent e) {
            	int key = e.getKeyCode();
            	
            	switch(key) {
            	case KeyEvent.VK_LEFT:
            		isLeftKeyPressed = false;
                	break;
                	
            	case KeyEvent.VK_RIGHT:
            		isRightKeyPressed = false;
            		break;
            	}
            }
        });
        labelImage.setIcon(imageIcon2);
        
        
        setFocusable(true);
        timer.start();
        paddleTimer.start();
        
        // Add winLabel and set its layout and bounds
//        winLabel = new JLabel();
//        winLabel.setBounds(300, 300, 700, 100);
//        winLabel.setForeground(new Color(0, 255, 0));
//        winLabel.setFont(new Font(null, Font.BOLD, 105));
        setLayout(null);
//        add(winLabel);
        add(layeredPane);
//        setComponentZOrder(winLabel, 0);
    }
        
    public void gameEnd() {
//    	((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
    	((JFrame)SwingUtilities.getWindowAncestor(this)).setVisible(false);
    }
    
    public void gameWon() {

    	labelImage.setVisible(true);    	
    	
    	//Remove bricks.
    	for(int row = 0; row < brickRows; row++) {
    		for(int col = 0; col < bricksInRow; col++) {
    			bricks[row][col] = false;
    		}
    	}
    	
//    	Hiding paddle.
    	moveWidth = -100;
    	
//    	Hiding ball.
    	ballX = -100;
    	ballY = -100;
    	
//    	update them.
    	
//    	winLabel.setText("You win");    	
    	delay.start();	
    	
    	repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        height = getHeight();
        width = getWidth();

        brickPositionX = (width - (bricksInRow * (brickWidth + 10) - 10)) / 2;
        brickPositionY = 50;

        // Bricks.
        for (int row = 0; row < brickRows; row++) {
            for (int col = 0; col < bricksInRow; col++) {
                if (bricks[row][col]) {
                    g.setColor(Color.orange);
                    g.fillRect(brickPositionX + col * (brickWidth + 10), brickPositionY + row * (brickHeight + 5), brickWidth, brickHeight);
                }
            }
        }

        // Red paddle.
        g.setColor(Color.red);
        g.fillRect(moveWidth, paddleHeight, 100, 50);

        // Green ball.
        g.setColor(Color.green);
        g.fillOval(ballX, ballY, 40, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ball position changes.
        ballX += velocityX;
        ballY += velocityY;

        // Ball conflict with paddle.
        if (ballX >= moveWidth && ballX <= moveWidth + 100 && ballY + 40 >= paddleHeight && ballY <= paddleHeight + 50) {
            velocityY *= -1;
            ballY = paddleHeight - 40;
        }

        // Check collision with wall.
        if (ballX <= 0 || ballX >= width - 20) {
            velocityX *= -1;
        }
        if (ballY <= 0) {
            velocityY *= -1;
        }
      
        // Ball vs Bricks
        for (int row = 0; row < brickRows; row++) {
            for (int col = 0; col < bricksInRow; col++) {
                if (bricks[row][col]) {
                    int brickX = brickPositionX + col * (brickWidth + 10);
                    int brickY = brickPositionY + row * (brickHeight + 5);

                    if (ballX + 40 >= brickX && ballX <= brickX + brickWidth && ballY + 40 >= brickY && ballY <= brickY + brickHeight) {
                        velocityX *= -1;
                        velocityY *= -1;
                        bricks[row][col] = false; // Mark the brick as destroyed
                        score++; // Increase score when a brick is removed.
//                        velocityX += 1;
//                        velocityY += 1;
                        
                        if(score == 45) {
                        	gameWon();
                        }
                        return; // Return early to avoid further collision checks in this frame.
                    }	
                }
            }
        }
       
        repaint();
        if (ballY >= height - 20) {
        	gameEnd();
        	gameOver = new GameOver(this);
//        	getScore();
        	timer.stop();
        }
    }
    
    public void getScore() {
    	int stored = score;
    	yScore = new YourScore(stored, this);
    }
    
    public void resetGame() {    
        score = 0;
        count = 0;
        moveWidth = 350;
        ballX = 200;
        ballY = 300;
        velocityX = 4;
        velocityY = 4;
        
        // Reset bricks to initial state.
        for (int row = 0; row < brickRows; row++) {
            for (int col = 0; col < bricksInRow; col++) {
                bricks[row][col] = true;
            }
        }

        timer.stop();
        delay.stop();
        paddleTimer.stop();
    }

}
