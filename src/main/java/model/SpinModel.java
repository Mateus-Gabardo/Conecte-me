
package model;

import utils.ImageUtils;



public class SpinModel extends PieceModel{

    public SpinModel(int tipo, int pinosLeft, int pinosTop, int pinosRight, int pinosBottom) {
        super(tipo, pinosLeft, pinosTop, pinosRight, pinosBottom);
    }
    
    public SpinModel(String representacao){
        super(representacao);
    }

    @Override
    public String getPathImageIcon() {
       return ImageUtils.createImagePath("Spin"); 
    }
    
}
