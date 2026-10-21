import java.awt.*;
import javax.swing.*;

public class House extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        // Set the background color.
        setBackground(new Color(235, 235, 235));
        g2.setStroke(new BasicStroke(2));

        // Draw the roof.
        g2.setColor(new Color(255, 193, 7));
        int[] roofX = {90, 200, 310};
        int[] roofY = {200, 90, 200};
        g2.drawPolygon(roofX, roofY, 3);

        // Draw the walls.
        g2.setColor(Color.RED);
        g2.drawRect(100, 200, 200, 150);

        // Draw the door.
        g2.setColor(Color.MAGENTA);
        g2.drawRect(175, 280, 50, 70);

        // Draw the two windows.
        g2.setColor(Color.GREEN);
        g2.drawOval(135, 225, 30, 30);
        g2.drawOval(235, 225, 30, 30);

        g2.dispose();
    }

    public static void main(String[] args) {
        // Create the window and drawing panel.
        JFrame frame = new JFrame("House Drawing");
        House panel = new House();

        // Add the panel and set the window properties.
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}