import java.awt.*;
import javax.swing.*;

public class TranslationEx1 extends JPanel{
    
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int [][]squre = {
            {10,10},
            {210,10},
            {210,210},
            {10,210},
            {10,10}
        };

        // int [][]hexagon = {
        //     {200,100},
        //     {300,100},
        //     {350,200},
        //     {300,300},
        //     {200,300},
        //     {150,200},
        //     {200,100}
        // };


        g.setColor(Color.BLUE);
        drawPolygon(squre, g);

        int [][] translatedSquare = translate(squre,250,250);

        g.setColor(Color.RED);
        drawPolygon(translatedSquare,g);

        int[][] rotatedSqure = rotate(squre,30);
        g.setColor(Color.YELLOW);
        drawPolygon(rotatedSqure, g);

        // g.setColor(Color.CYAN);
        // drawPolygon(hexagon, g);

        // int [][] translateHexagon = translate(hexagon,40,40);

        // g.setColor(Color.BLACK);
        // drawPolygon(translateHexagon,g);

    }



    private void drawPolygon(int[][]points,Graphics g){
        for(int i=0; i<points.length-1; i++){
            ddaLine(
                points[i][0],
                points[i][1],
                points[i+1][0],
                points[i+1][1],
                g
            );
        }
    }

    private void ddaLine(int x1,int y1,int x2,int y2,Graphics g){
        int dx = x2-x1;
        int dy = y2-y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        if(steps == 0){
            g.fillRect(x1,y1,2,2);
            return;
        }

        float xInc = (float)dx / steps;
        float yInc = (float)dy / steps;

        float x = x1;
        float y = y1;
        
        for(int i=0; i<=steps;i++){
            g.fillRect(Math.round(x), Math.round(y), 2,2);

            x += xInc;
            y += yInc;
        }
        
    }

    
    private int[][] translate(int[][] points, int tx, int ty){

        int[][] newPoints = new int[points.length][2];

        for(int i=0; i<points.length; i++){
            newPoints[i][0] = points[i][0] + tx;
            newPoints[i][1] = points[i][1] + ty;
        }

        return newPoints;
    }

    private int[][] rotate(int[][] points, double angle){

        int[][] rotated = new int[points.length][2];

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        double cx = getWidth() / 2;
        double cy = getHeight() / 2;

        for(int i=0; i<points.length; i++){

            double x = points[i][0] - cx;
            double y = points[i][1] - cy;

            rotated[i][0] = (int)Math.round(x * cos - y * sin + cx);

            rotated[i][1] = (int)Math.round(x * sin + y * cos + cy);

        }
        return rotated;
    }


    public static void main(String[]args){
        JFrame frame = new JFrame("Translation Exersize");

        TranslationEx1 panel = new TranslationEx1();
        frame.add(panel);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
