import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class End extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color
        setBackground(Color.WHITE);

        // Set the font and color for the message
        Font font = new Font("Arial", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.RED);

        // Calculate the center position for the message
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw the "Game Over" message
        String message = "Game Over";
        int messageWidth = g.getFontMetrics().stringWidth(message);
        int messageHeight = g.getFontMetrics().getHeight();

        int messageX = centerX - messageWidth / 2;
        int messageY = centerY + messageHeight / 2;

        g.drawString(message, messageX, messageY);
    }
}
