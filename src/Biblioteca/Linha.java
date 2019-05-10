package Biblioteca;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Linha extends JFrame {

    private static int WINDOW_WIDTH = 400;
    private static int WINDOW_HEIGHT = 400;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage imagem = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_BGR);
        drawLine(imagem,Color.RED, 200,100, 200 , 150);
        g.drawImage(imagem, 0, 0, null);
    }

    public void drawLine(BufferedImage imagem,Color c, int x1, int y1, int width, int height) {
        int x2 = x1 + width;
        int y2 = y1 + height;
        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        int y = y1;
        int error = 0;
        for (int x = x1; x < x2; x++) {
            imagem.setRGB(x, y1, c.getRGB());
            error = error + deltay;
            if (2 * error >= deltax) {
                y = y + 1;
                error = error - deltax;
            }
        }
        //repaint();
    }

    public static void main(String[] args) {
        JFrame frame =  new Linha();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



/*int x0 = 60;
    int x1 = 50;
    int y0 = 10;
    int y1 = 20;

    int Dx = x0 - x1;
    int Dy = y0 - y1;

    int fraction, xstep, ystep;*/

/*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 30; x < canvas.getWidth(); x++) {
            for (int y = 20; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }*/

/*public void paint(Graphics g)  
    {  
        if(Dy < 0)  
        {  
            Dy = -Dy;  
            ystep = -1;  
        }  
        else  
        {  
            ystep = 1;  
        }  
        if(Dx < 0)  
        {  
            Dx = - Dx;  
            xstep = -1;  
        }  
        else  
        {  
            xstep = 1;  
        }  
          
        Dy <<= 1;   
        Dx <<= 1;  
      
        int array[] = {250,0,0,250};  
        raster.setPixel(x0,y0,array);  
        if(Dx > Dy)  
        {  
            fraction = Dy - (Dx >> 1);  
        }   
        while(x0 != x1)  
        {  
            if(fraction >= 0)  
            {  
                y0 += ystep;  
                fraction -= Dx;  
                x0 += xstep;  
                fraction += Dy;  
                raster.setPixel(x0,y0,array);  
            }  
            else  
            {  
                fraction = Dx-(Dy>>1);  
                while(y0 != y1)  
                {  
                    if(fraction >= 0)  
                    {  
                        x0 += xstep;  
                        fraction-=Dy;  
                    }  
                    y0 += ystep;  
                    fraction += Dx;  
                    raster.setPixel(x0,y0,array);  
                }  
            }  
            g.drawImage(image,x1,y1,null);  
        }  
    }*/
