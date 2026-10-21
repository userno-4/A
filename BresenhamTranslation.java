import java.awt.*;
import javax.swing.*;

public class BresenhamTranslation extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.translate(getWidth()/2, getHeight()/2);
		
		int[][]base = {
				{-100,100},
				{100,100},
				{100,300},
				{-100,300},
				{-100,100}
		};
		
		int[][]roof = {
				{-100,100},
				{0,0},
				{100,100},
				{-100,100}
		};
		
		int[][]door = {
				{-30,300},
				{30,300},
				{30,220},
				{-30,220},
				{-30,300}
		};
		
		int[] angle = {0,90,180,270};
		
		Color[] colors = {
				Color.RED,
				Color.GREEN,
				Color.YELLOW,
				Color.PINK
		};
		
		
		for(int i=0; i<4; i++) {
			
//			Graphics2D houseG = (Graphics2D) g2.create();
			
			int[][]sBase = scaleShape(base,0.6,0.6);
			int[][]sRoof = scaleShape(roof,0.6,0.6);
			int[][]sDoor = scaleShape(door,0.6,0.6);
			
			int[][]tBase = translateShape(sBase,0,-250);
			int[][]tRoof = translateShape(sRoof,0,-250);
			int[][]tDoor = translateShape(sDoor,0,-250);
			
			int[][]rBase = rotateShape(tBase,angle[i]);
			int[][]rRoof = rotateShape(tRoof,angle[i]);
			int[][]rDoor = rotateShape(tDoor,angle[i]);
			
			
			
			g2.setColor(colors[i]);
			drawShape(g2,rBase);
			drawShape(g2,rRoof);
			drawShape(g2,rDoor);
			
		}
		
		
		g2.dispose();
		
	}
	
	public void drawShape(Graphics g, int[][]points) {
		
		for(int i=0; i<points.length-1; i++) {
			
			bresenhamPractice(g,
					points[i][0],
					points[i][1],
					points[i+1][0],
					points[i+1][1]
			);
		}
	}
	
	//SCALE METHOD
	public int[][] scaleShape(int[][]points , double sx, double sy){
		int[][] scaled = new int[points.length][2];
		
		for(int i=0; i<points.length; i++) {
			scaled[i][0] = (int)Math.round(points[i][0] * sx);
			scaled[i][1] = (int)Math.round(points[i][1] * sy);
		}
		
		return scaled;
	}
	
	
	//ROTATE METHOD
	public int[][] rotateShape(int[][]points, double angle) {
		int[][] rotated = new int[points.length][2];
		
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		for(int i=0; i<points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			
			rotated[i][0] = (int)Math.round(x * cos - y * sin);
			rotated[i][1] = (int)Math.round(x * sin + y * cos);
		}
		
		return rotated;
	}
	
	
	//TRANSLATE METHOD
	public int[][] translateShape(int[][]points, int dx, int dy ) {
		int[][] translated = new int[points.length][2];
		
		
		for(int i=0; i<points.length; i++) {
			translated[i][0] = points[i][0] + dx;
			translated[i][1] = points[i][1] + dy;
		}
		
		return translated;
	}
	
	
	public void bresenhamPractice(Graphics g, int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		
		int sx = (x1<x2) ? 1 : -1;
		int sy = (y1<y2) ? 1 : -1;
		
		int p = dx - dy;
		
		while(true) {
			g.fillRect(x1, y1, 2, 2);
			
			if(x1 == x2 && y1 == y2) {
				break;
			}
			
			int p2 = 2 * p;
			
			if(p2 > -dy) {
				p = p -dy;
				x1 = x1 + sx;
			}
			
			if(p2 < dx) {
				p = p + dx;
				y1 = y1 + sy;
			}
		}
	}
	
	public static void main(String[]args) {
		BresenhamTranslation panel = new BresenhamTranslation();
		JFrame frame = new JFrame("Bresenham Practice");
		
		frame.add(panel);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}