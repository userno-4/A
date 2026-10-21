import java.awt.*;
import javax.swing.*;

public class StickFigure extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        // Set a light gray background.
        setBackground(new Color(235, 235, 235));

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        // Draw the head.
        g2.drawOval(160, 80, 70, 80);

        // Draw the body.
        g2.drawLine(195, 160, 195, 270);

        // Draw the left and right arms.
        g2.drawLine(195, 190, 140, 230);
        g2.drawLine(195, 190, 250, 230);

        // Draw the left and right legs.
        g2.drawLine(195, 270, 150, 350);
        g2.drawLine(195, 270, 240, 350);

        g2.dispose();
    }

    public static void main(String[] args) {
        // Create the window and drawing panel.
        JFrame frame = new JFrame("Stick Figure Drawing");
        StickFigure panel = new StickFigure();

        // Add the panel and set the window properties.
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}