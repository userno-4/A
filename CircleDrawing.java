
import javax.swing.*;
import java.awt.*;

// Bresenham's Circle Drawing Algorithm
public class CircleDrawing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cx = getWidth() / 2;    // centre of the screen
        int cy = getHeight() / 2;

        g.setColor(Color.RED);
        drawCircle(g, cx, cy, 100);     // big circle   (centre x, centre y, radius)

        g.setColor(Color.BLUE);
        drawCircle(g, cx+40, cy-30, 20);      // small circle (same centre = concentric)
        
        g.setColor(Color.BLUE);
        drawCircle(g, cx-40, cy-30, 20);
    }

    // Bresenham's Circle Algorithm
    void drawCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;              // initial decision parameter

        plotPoints(g, xc, yc, x, y);    // first point

        while (x < y) {
            if (d < 0) {
                d = d + 4 * x + 6;              // choose (x+1, y)
            } else {
                d = d + 4 * (x - y) + 10;       // choose (x+1, y-1)
                y--;
            }
            x++;
            plotPoints(g, xc, yc, x, y);
        }
    }

    // One calculated point -> 8 points (8-way symmetry)
    void plotPoints(Graphics g, int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 2, 2);
        g.fillRect(xc - x, yc + y, 2, 2);
        g.fillRect(xc + x, yc - y, 2, 2);
        g.fillRect(xc - x, yc - y, 2, 2);
        g.fillRect(xc + y, yc + x, 2, 2);
        g.fillRect(xc - y, yc + x, 2, 2);
        g.fillRect(xc + y, yc - x, 2, 2);
        g.fillRect(xc - y, yc - x, 2, 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new CircleDrawing());
        frame.setVisible(true);
    }
}