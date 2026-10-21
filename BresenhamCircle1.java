import java.awt.*;
import javax.swing.*;

public class BresenhamCircle1 extends JPanel{
    
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        drawShape(g,100,200,100);

    }

    public void drawShape(Graphics g ,int xc,int yc,int r){
        int x = 0;
        int y = r;
        int d = 3-2*r;

        plotPoints(g,xc,yc,x,y);

        while(x<y){
            if(d<0){
                d = d + 4*x+6;
            }else{
                d = d + 4*(x-y) + 10;
                y--;
            }
            x++;
            plotPoints(g, xc, yc, x, y);
        }
    }

    void plotPoints(Graphics g,int xc,int yc,int x,int y){
        g.fillRect(xc + x, yc + y, 2,2);
        g.fillRect(xc + x, yc - y, 2,2);

        g.fillRect(xc - x , yc + y, 2,2);
        g.fillRect(xc - x, yc - y, 2,2);

        g.fillRect(xc + y, yc + x,2,2);
        g.fillRect(xc + y , yc - x, 2,2);

        g.fillRect(xc - y, yc + x,2,2);
        g.fillRect(xc - y, yc - x, 2,2);
    }



    public static void main(String[]args){
        JFrame frame = new JFrame("Bresenham Circle Drawing practice 01");

        BresenhamCircle1 panel = new BresenhamCircle1();

        frame.add(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
