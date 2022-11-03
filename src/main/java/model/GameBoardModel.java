
package model;

import controller.GameBoardController;
import javax.swing.table.AbstractTableModel;


public class GameBoardModel extends AbstractTableModel{
    private GameBoardController gameController;
    private int[][] state;

    public GameBoardModel(GameBoardController gameController) {
        this.gameController = gameController;
        this.state = gameController.getState();
    }
    
    /**
     * Retorna a matriz que armazena o estado do game
     * @return 
     */
    public int[][] getState(){
        return this.state;
    }

    @Override
    public int getRowCount() {
        return this.gameController.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return this.gameController.getColumnCount();
    }

    @Override
    public PieceModel getValueAt(int rowIndex, int columnIndex) {
       // retornamos o objeto a partir da String d matriz
       if(this.gameController.hasElementAt(rowIndex, columnIndex, this.state)){
           return this.gameController.getElementAt(this.state[rowIndex][columnIndex]);
       } else {
           return null;
       }
    }
    
}
