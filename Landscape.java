import java.awt.*;
import javax.swing.*;

public class Landscape extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        // Draw the sky.
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, 500, 400);

        // Draw the ground.
        g2.setColor(new Color(19, 109, 21));
        g2.fillRect(0, 320, 500, 80);

        // Draw the mountains using several points.
        g2.setColor(new Color(120, 63, 20));
        int[] xPoints = {35, 150, 185, 255, 330, 370, 465};
        int[] yPoints = {320, 200, 242, 130, 242, 200, 320};
        g2.fillPolygon(xPoints, yPoints, 7);

        // Draw the sun.
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(355, 28, 78, 78);

        // Draw twelve rays around the sun.
        g2.setColor(Color.YELLOW);
        for (int i = 0; i < 12; i++) {
            // Calculate the start and end points of each ray.
            double angle = Math.toRadians(30 * i);
            int x1 = (int) (394 + 43 * Math.cos(angle));
            int y1 = (int) (67 + 43 * Math.sin(angle));
            int x2 = (int) (394 + 57 * Math.cos(angle));
            int y2 = (int) (67 + 57 * Math.sin(angle));
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.dispose();
    }

    public static void main(String[] args) {
        // Create the window and drawing panel.
        JFrame frame = new JFrame("Landscape Drawing");
        Landscape panel = new Landscape();

        // Add the panel and set the window properties.
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}