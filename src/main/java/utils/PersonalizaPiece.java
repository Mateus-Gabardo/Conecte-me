/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.PieceModel;

public class PersonalizaPiece implements Icon{
    private PieceModel piece;
    private int pinWidth;
    private int pinHeight;
    private int iconWidth;
    private int iconHeight;
    private ImageIcon pieceIcone;
    
    private static final int LEFT   = 1;
    private static final int TOP    = 2;
    private static final int RIGHT  = 3;
    private static final int BOTTOM = 4;

    public PersonalizaPiece(PieceModel piece, int pinWidth, int pinHeight) {
        this.piece = piece;
        this.pinWidth = pinWidth;
        this.pinHeight = pinHeight;
        this.pieceIcone = this.piece.getImagem(4);
        this.iconWidth = this.pieceIcone.getIconWidth();
        this.iconHeight = this.pieceIcone.getIconHeight();
    }  
    

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        ImageIcon pieceImg = this.pieceIcone;
        Image newImagePiece = this.piece.getImagem(4).getImage();
        this.paintPin(g);
        g.drawImage(newImagePiece, 12, 12, pieceImg.getIconWidth(), pieceImg.getIconHeight(), pieceImg.getImageObserver());
    }
    
    private void paintPin(Graphics g){
        ImageIcon pino = this.piece.getPin();
        this.desenhaImagem(g, piece.getPinosLeft(), pino, LEFT);
        this.desenhaImagem(g, piece.getPinosTop(), pino, TOP);
        this.desenhaImagem(g, piece.getPinosRight(), pino, RIGHT);
        this.desenhaImagem(g, piece.getPinosBottom(), pino, BOTTOM);
    }
    
    private void desenhaImagem(Graphics g, int totalPinos, ImageIcon pino, int tipo){
        int walk = totalPinos;
        int altura = getLarguraForPosicao(tipo);
        int largura = getAlturaForPosicao(tipo);
        // a cada pino adicional deve se recuado 6px do centro e a cada interação conta-se mais 12px
        int recuo = 72 - ((totalPinos - 1) * 6);
        int x;
        int y;
        while(walk > 0){
            if(tipo == LEFT || tipo == RIGHT){
                x = this.getXY(tipo);
                y = recuo; // é o que muda
            } else {
               x = recuo;
               y = this.getXY(tipo);
            }
            Image newPino = pino.getImage();
            g.drawImage(newPino,x, y, largura, altura, pino.getImageObserver());
            recuo += 12;
            walk--;
        }
    }
    
    private int getAlturaForPosicao(int tipo){
        switch(tipo){
            case LEFT:
            case RIGHT:
                return 14;
            case TOP:
            case BOTTOM:
                return 7;
            default:
                return 0;
        }
    }
    
    private int getLarguraForPosicao(int tipo){
        switch(tipo){
            case LEFT:
            case RIGHT:
                return 7;
            case TOP:
            case BOTTOM:
                return 14;
            default:
                return 0;
        }
    }
    
    private int getXY(int tipo){
        switch(tipo){
            case LEFT:
                return 0;
            case BOTTOM:
                return 140;
            case RIGHT:
                return 145;
            case TOP:
                return 0;
            default:
                return 0;
        }
    }

    @Override
    public int getIconWidth() {
        return this.iconWidth;
    }

    @Override
    public int getIconHeight() {
        return this.iconHeight;
    }    
}
