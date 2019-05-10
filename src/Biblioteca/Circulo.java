package Biblioteca;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Circulo extends JFrame {
    private static int WINDOW_WIDTH = 450;
    private static int WINDOW_HEIGHT = 400;
    
    @Override public void paint(Graphics g){
        super.paint(g);
        
        BufferedImage imagem = new BufferedImage (WINDOW_WIDTH,WINDOW_HEIGHT,BufferedImage.TYPE_INT_BGR);
        drawCircleImage(imagem,200,200,180,1000,Color.GREEN);
        drawCircleImage(imagem,200,200,150,2000,Color.GREEN);
        drawCircleImage(imagem,200,200,100,2000,Color.GREEN);
        drawCircleImage(imagem,200,200,80,1000,Color.GREEN);
        g.drawImage(imagem, 0, 0, null);
    }
    
    public void drawCircleImage(BufferedImage imagem,int posicaoCentroX,int posicaoCentroY,int raio,int quantidadeDePontos,Color cor){
        double distaciaEntrePontos = 2 * Math.PI / quantidadeDePontos;
        
        for(int i = 0; i<quantidadeDePontos;i++){
            double cos = Math.cos(i* distaciaEntrePontos);
            double sin = Math.sin(i * distaciaEntrePontos );
            
            int x = (int) (cos * raio + posicaoCentroX);
            int y = (int) (sin * raio + posicaoCentroY);
            
            imagem.setRGB(x,y,cor.getRGB());   
        }
        //repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame =  new Circulo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
}
