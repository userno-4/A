
import javax.swing.*;
import java.awt.*;

public class MidpointCircle extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		
		g.setColor(Color.RED);
		midPoint(g, cx, cy, 100);
		
		g.setColor(Color.BLUE);
		midPointSmile(g, cx, cy, 60);
		
		g.setColor(Color.ORANGE);
		midPoint(g, cx-50, cy-30, 20);
		
		g.setColor(Color.ORANGE);
		midPoint(g, cx+50, cy-30, 20);
	}
	
	void midPoint(Graphics g, int cx, int cy, int r) {
		int x = 0;
		int y = r;
		int p = 1 - r;
		
		plotPoint(g, cx, cy, x, y);
		
		while(x < y) {
			x++;
			if(p < 0) {
				p = p + 2 * x + 1;
			}else {
				y--;
				p = p + 2 * (x - y) + 1;
			}
			plotPoint(g, cx, cy, x, y);
		}
	}
	
	void midPointSmile(Graphics g, int cx, int cy, int r) {
		int x = 0;
		int y = r;
		int p = 1 - r;
		
		plotPointSmile(g, cx, cy, x, y);
		
		while(x < y) {
			x++;
			if(p < 0) {
				p = p + 2 * x + 1;
			}else {
				y--;
				p = p + 2 * (x - y) + 1;
			}
			plotPointSmile(g, cx, cy, x, y);
		}
	}
	
	void plotPoint(Graphics g, int cx, int cy, int x, int y) {
		g.fillRect(cx+x, cy+y, 2, 2);
		g.fillRect(cx-x, cy+y, 2, 2);
		g.fillRect(cx+x, cy-y, 2, 2);
		g.fillRect(cx-x, cy-y, 2, 2);
		g.fillRect(cx+y, cy+x, 2, 2);
		g.fillRect(cx-y, cy+x, 2, 2);
		g.fillRect(cx+y, cy-x, 2, 2);
		g.fillRect(cx-y, cy-x, 2, 2);
	}
	
	void plotPointSmile(Graphics g, int cx, int cy, int x, int y) {
		g.fillRect(cx+x, cy+y, 2, 2);
		g.fillRect(cx-x, cy+y, 2, 2);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Midpoint Circle Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.add(new MidpointCircle());
		frame.setVisible(true);
	}
}