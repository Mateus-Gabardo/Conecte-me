
package model;

import utils.ImageUtils;

public class WalkModel extends PieceModel {

    public WalkModel(int tipo, int pinosLeft, int pinosTop, int pinosRight, int pinosBottom) {
        super(tipo, pinosLeft, pinosTop, pinosRight, pinosBottom);
    }
    
    public WalkModel(String representacao){
        super(representacao);
    }

    @Override
    public String getPathImageIcon() {
        return ImageUtils.createImagePath("Walk");
    }
    
}
