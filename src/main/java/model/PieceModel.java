/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GameBoardController;
import javax.swing.ImageIcon;
import utils.ImageUtils;
import utils.ResizedImageIconFactory;

/**
 *
 * @author gabardo
 * Define os modelos de peças do tabuleiro.
 * Os tipo correpondem a:
 * 1 - Tower: Fixo no local
 * 2 - Spin: Fixo e gira em torno de si
 * 3 - Walk: Anda para todas as direções
 * 4 - SpinWalk: Anda e gira
 * 
 * Também são definidos as quantidades de pinos que cada componente possui 
 * podendo vriar de 0 (nenhum pino) a 3 (quantidade máxima de pinos) distribuidos
 * na seguinte sequência left, top, right e bottom.
 */
public abstract class PieceModel {
    private int tipo;
    private int pinosLeft;
    private int pinosTop;
    private int pinosRight;
    private int pinosBottom;

    public PieceModel(int tipo, int pinosLeft, int pinosTop, int pinosRight, int pinosBottom) {
        this.tipo        = tipo;
        this.pinosLeft   = pinosLeft;
        this.pinosTop    = pinosTop;
        this.pinosRight  = pinosRight;
        this.pinosBottom = pinosBottom;
    }
    
    public PieceModel(String representacao){
       int[] data = new int[5];
       for (int i = 0; i < 5; i++) {
            data[i] = Integer.parseInt(representacao.substring(i, i + 1));
        }
        this.tipo        = data[0];
        this.pinosLeft   = data[1];
        this.pinosTop    = data[2];
        this.pinosRight  = data[3];
        this.pinosBottom = data[4];
    }

    public int getTipo() {
        return tipo;
    }

    protected void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getPinosLeft() {
        return pinosLeft;
    }

    protected void setPinosLeft(int pinosLeft) {
        this.pinosLeft = pinosLeft;
    }

    public int getPinosTop() {
        return pinosTop;
    }

    protected void setPinosTop(int pinosTop) {
        this.pinosTop = pinosTop;
    }

    public int getPinosRight() {
        return pinosRight;
    }

    protected void setPinosRight(int pinosRight) {
        this.pinosRight = pinosRight;
    }

    public int getPinosBottom() {
        return pinosBottom;
    }

    protected void setPinosBottom(int pinosBottom) {
        this.pinosBottom = pinosBottom;
    }
    
    /**
     * Retorna uma imagem a partir do seu controlador
     * @param controller
     * @return 
     */
    public ImageIcon getImagem(GameBoardController controller){
        int sizeIcon = (int)(this.iconSize(controller.getRowCount()));
        String path = this.getPathImageIcon();
        ImageIcon icon = ResizedImageIconFactory.create((String) path, sizeIcon, sizeIcon);
        return icon;
    }
    
    /**
     * Retorna a imagem do objeto a partir de um tamanho definido sem controlador
     * @param rowCount
     * @return 
     */
    public ImageIcon getImagem(int rowCount){
        int sizeIcon = (int)(this.iconSize(rowCount));
        String path = this.getPathImageIcon();
        ImageIcon icon = ResizedImageIconFactory.create((String) path, sizeIcon, sizeIcon);
        return icon;
    }
    
    public ImageIcon getPin(){
        return ResizedImageIconFactory.create(ImageUtils.createImagePath("Pin"), 40, 40);
    }
    
    public abstract String getPathImageIcon();
    
    private int iconSize(int countLinhas){
        final int maximo = 550;
        return (int)(maximo / countLinhas);
    }   
    
}
