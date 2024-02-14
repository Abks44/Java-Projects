import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FortuneSpinner extends JPanel implements ActionListener{
	
	JLabel topLabel;
	JButton restartButton, stopButton, startButton;
    int highlightedColorIndex = -1;
    int rectHeight;
    int stringHeight;
    Font font;
    int stopLine;
    static JFrame frame;
//    static MeteredScore obj;
    int x = 200;
    int y = 200;
    int size = 200;
    int arcAngle1;
    int arcAngle2;
    int initLineX = 300;
    int initLineY = 300;
    int endLineX = 400;
    int endLineY = 300;
    Timer timer;
    int endLineYI = 90;
    Random random;
    Color[] colors = {
        Color.green, Color.red, Color.orange, Color.blue, Color.gray, Color.cyan, Color.magenta, Color.WHITE
    };

    public FortuneSpinner () {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 700);
        setBackground(Color.black);
        setLayout(null);
//        setOpaque(false);
        
        topLabel = new JLabel("Fortune Wheel!");
        topLabel.setBounds(250, 40, 400, 50);
        topLabel.setFont(new Font("Consolas", Font.BOLD, 38));
        topLabel.setForeground(Color.green);
        
        frame.addKeyListener(new KeyListenerClass());
        
        restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        restartButton.setFocusable(false);
        restartButton.setBounds(100, 600, 90, 40);
        restartButton.setBackground(Color.black);

        
        stopButton = new JButton("Stop");       
        stopButton.addActionListener(this);
        stopButton.setFocusable(false);
        stopButton.setBounds(200, 600, 90, 40);
        stopButton.setBackground(Color.black);

        
        startButton = new JButton("Start");       
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setBounds(150, 500, 90, 40);
        startButton.setBackground(Color.black);
        
        font = new Font(null, Font.BOLD, 30);

        add(topLabel);
        add(restartButton);
        add(stopButton);
        add(startButton);

        frame.add(this);

        random = new Random();

        timer = new Timer(30, this);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        
        arcAngle1 = 0;
        arcAngle2 = 45;

        for (Color color : colors) {
            g.setColor(color);
            g.fillArc(x, y, size, size, arcAngle1, arcAngle2);
            arcAngle1 += arcAngle2;
        }

        g2d.setFont(new Font(null, Font.BOLD, 24));
        
        String names[] = {
        	    "Curious", "Tenacious", "Charismatic", "Resourceful", "Visionary", "Analytical", "Altruistic", "Ambitious"
        	};

        rectHeight = 200;
        stringHeight = 215;

        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);

            if (i == highlightedColorIndex) {
                g.fillRect(500, rectHeight, 30, 30); // Increase the width for highlighted color.
            } else {
                g.fillRect(500, rectHeight, 20, 20);
            }

            rectHeight += 50;

            g.setColor(Color.white);
            g.drawString(names[i], 550, stringHeight);
            stringHeight += 51;
        }

        g2d.setStroke(new BasicStroke(8));

        g2d.setColor(Color.black);
        g2d.drawLine(initLineX, initLineY, endLineX, endLineY);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	 
    	if(e.getSource() == startButton) {
    		timer.start();
    	}
        if(e.getSource() == restartButton) {
        	timer.restart();
        }else if(e.getSource() == stopButton) {
        	timer.stop();
        }     
        
        double angle = Math.toRadians(endLineYI);

        int centerX = x + size / 2;
        int centerY = y + size / 2;
        int radius = size / 2;

        endLineX = (int) (centerX + radius * Math.sin(angle));
        endLineY = (int) (centerY + radius * Math.cos(angle));

        endLineYI += 5;

        int stop = random.nextInt(360);

        if (endLineX == stop || endLineY == stop) {
            timer.stop();            

            // Find the index of the stopped color.
            int currentSegment = (int) (endLineYI % 360) / arcAngle2 + 15;
            highlightedColorIndex = currentSegment % colors.length - 1;

            repaint();
        }
        repaint();
    }
    
    class KeyListenerClass implements KeyListener{
    	@Override
    	public void keyTyped(KeyEvent e) {
    		
    	}
    	@Override
    	public void keyReleased(KeyEvent e) {
    		int key = e.getKeyCode();
        	
    		if(key == KeyEvent.VK_ENTER) 
    		{
    			timer.restart();
    		}
    	}
    	@Override
    	public void keyPressed(KeyEvent e) {
    		
    	}
    }
	
	public static void main(String[] args) {
		new FortuneSpinner();
	}
}