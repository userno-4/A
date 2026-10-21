import java.awt.*;
import javax.swing.*;


public class DDAAlgorithm extends JPanel{
    
    public void DDA(Graphics g,int x1,int y1,int x2,int y2){
        int dx = Math.abs(x2-x1);
        int dy= Math.abs(y2-y1);

        double step,xinc,yinc,x,y;

        if(dx > dy){
            step = dx;
        }else{
            step = dy;
        }

        xinc = (double)(x2-x1)/ step;
        yinc = (double)(y2-y1) / step;

        x= x1;
        y= y1;

        for(int i=0; i<=step; i++){

            g.fillRect((int)Math.round(x),
                        (int)Math.round(y),
                        2,2);

            x=x+xinc;
            y=y+yinc;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        DDA(g,200,200,400,200);
        DDA(g,400,200,400,400);
        DDA(g,400,400,200,400);
        DDA(g,200,400,200,200);

    }


    public static void main(String[]args){
        JFrame frame = new JFrame("DDA algorithm");

        DDAAlgorithm panel = new DDAAlgorithm();

        frame.add(panel);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DDA Algorithm");
        frame.setLocationRelativeTo(null);
    }
}
