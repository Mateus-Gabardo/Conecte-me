
package model;

import utils.ImageUtils;


public class TowerModel extends PieceModel{

    public TowerModel(int tipo, int pinosLeft, int pinosTop, int pinosRight, int pinosBottom) {
        super(tipo, pinosLeft, pinosTop, pinosRight, pinosBottom);
    }
    
    public TowerModel(String representacao){
        super(representacao);
    }

    @Override
    public String getPathImageIcon() {
        return ImageUtils.createImagePath("Tower"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
