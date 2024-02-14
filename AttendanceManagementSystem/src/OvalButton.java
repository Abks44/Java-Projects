//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.SwingUtilities;
//
//public class OvalButton extends JFrame implements ActionListener{
//
//	JPanel panel;
//	JLabel label;
//	
//	public OvalButton() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(400, 400);
//		setLocationRelativeTo(null);
//		
//		panel = new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				
//				g.setColor(Color.green);
//				g.drawOval(10, 20, 100, 100);
//			}	
//		};
//		
//		add(panel);
//		setVisible(true);	
//		
//	} 
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//	}
//	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//			new OvalButton();
//		});
//	}
//	
//}


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class OvalButton extends JFrame implements ActionListener {

    JPanel panel;
    JLabel label;

    public OvalButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.green);
                g.drawOval(10, 20, 100, 100);
            }
        };

        // Add a MouseListener to the panel
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click event here
                handleClickEvent(e.getX(), e.getY());
            }
        });

        add(panel);
        setVisible(true);

    }

    private void handleClickEvent(int x, int y) {
        // Check if the click is within the bounds of the oval
        if (isPointInOval(x, y, 10, 20, 100, 100)) {
            // Handle the click action here
            System.out.println("Circle Clicked!");
        }
    }

    // Check if the point (x, y) is within the bounds of the oval
    private boolean isPointInOval(int x, int y, int ovalX, int ovalY, int ovalWidth, int ovalHeight) {
        double a = ovalWidth / 2.0; // = 50
        double b = ovalHeight / 2.0; // = 50
        double centerX = ovalX + a; // = 10 + 50 = 60
        double centerY = ovalY + b; // = 20 + 50 = 70

        return Math.pow((x - centerX) / a, 2) + Math.pow((y - centerY) / b, 2) <= 1;
    }
    // x = 10
    // y = 20
//    math.pow 10 - 60 / a = -50 / 50 = -1, 2 = '1' + 20 - 70/b = -50/50 = -1, 2 = 1

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle other action events if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OvalButton();
        });
    }
}
