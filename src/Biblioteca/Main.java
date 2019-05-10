/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main extends JFrame  {

    private static int WINDOW_WIDTH = 400;
    private static int WINDOW_HEIGHT = 400;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage imagem = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_BGR);
        drawCircleImage(imagem,200,200,180,1000,Color.WHITE);
        drawCircleImage(imagem,200,200,150,2000,Color.WHITE);
        drawCircleImage(imagem,200,200,105,2000,Color.WHITE);
        drawCircleImage(imagem,200,200,55,1000,Color.WHITE);
        drawLine(imagem,Color.RED, 200,200, 180 , 200);
        drawLine(imagem,Color.RED, 20,200, 180 , 150);
        drawLine(imagem,Color.GREEN, 20,20,0,120);
        g.drawImage(imagem, 0, 0, null);
        g.drawLine(WIDTH, WIDTH, WIDTH, WIDTH);
    }

    // Linha Horizontal
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
    
    //Linha Vertical
    
    
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
        JFrame lh =  new Main();
        lh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lh.setSize(800, 850);
        lh.setLocationRelativeTo(null);
        lh.setVisible(true);
    }
    
}
