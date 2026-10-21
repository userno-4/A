import java.awt.*;
import javax.swing.*;

public class SmailFace extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setStroke(new BasicStroke(2.5f));

        // 1. Face (Gray circle)
        g2.setColor(new Color(130, 130, 130));
        g2.drawOval(-160, -160, 320, 320);

        // 2. Eyes (Black circles)
        g2.setColor(Color.BLACK);
        g2.drawOval(-72, -62, 34, 34);  // Left Eye
        g2.drawOval(38, -62, 34, 34);   // Right Eye

        // 3. Eyebrows
        g2.drawLine(-80, -75, -25, -58); // Left Eyebrow
        g2.drawLine(25, -58, 80, -75);   // Right Eyebrow

        // 4. Smile (Red arc)
        g2.setColor(Color.RED);
        g2.drawArc(-65, 10, 130, 110, 180, 180);

        g2.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image 4 - Smiley Face");
        SmailFace panel = new SmailFace();
        
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}