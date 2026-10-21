import java.awt.*;
import javax.swing.*;

public class Flower extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        // Set a light gray background.
        setBackground(new Color(235, 235, 235));

        // Draw six red petals around the center.
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(1.5f));
        for (int i = 0; i < 6; i++) {
            // Calculate the position of each petal.
            double angle = Math.toRadians(60 * i);
            int px = (int) (200 + 40 * Math.cos(angle)) - 45;
            int py = (int) (210 + 40 * Math.sin(angle)) - 45;
            g2.drawOval(px, py, 90, 90);
        }

        // Draw the yellow center of the flower.
        g2.setColor(Color.YELLOW);
        g2.drawOval(165, 175, 70, 70);

        // Draw the dark green stem.
        g2.setColor(Color.GREEN.darker());
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(200, 265, 200, 430);

        // Draw the two green leaves.
        g2.setColor(Color.GREEN);
        g2.drawOval(140, 320, 45, 45);
        g2.drawOval(235, 345, 45, 45);

        g2.dispose();
    }

    public static void main(String[] args) {
        // Create the window and drawing panel.
        JFrame frame = new JFrame("Flower Drawing");
        Flower panel = new Flower();

        // Add the panel and set the window properties.
        frame.add(panel);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}