
package model;

import utils.ImageUtils;

public class SpinWalkModel extends PieceModel{

    public SpinWalkModel(int tipo, int pinosLeft, int pinosTop, int pinosRight, int pinosBottom) {
        super(tipo, pinosLeft, pinosTop, pinosRight, pinosBottom);
    }
    
    public SpinWalkModel(String representacao){
        super(representacao);
    }

    @Override
    public String getPathImageIcon() {
        return ImageUtils.createImagePath("SpinWalk");
    }
    
}
