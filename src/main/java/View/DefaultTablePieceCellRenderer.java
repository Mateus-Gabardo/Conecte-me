
package View;

import controller.GameBoardController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.PieceModel;
import utils.PersonalizaPiece;


public class DefaultTablePieceCellRenderer extends DefaultTableCellRenderer{
    private final Integer SQUARE_SIZE;
    private GameBoardController gameController;
    
    public DefaultTablePieceCellRenderer(Integer squareSize, GameBoardController gameController) {
        this.SQUARE_SIZE = squareSize;
        this.gameController = gameController;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        this.setOpaque(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.defineIcon(value, row, column);
        this.defineSize(table, column);
        Color gridColor = new Color(42, 94, 157);
        this.setBorder(BorderFactory.createLineBorder(gridColor, 1));
        return this;
    }

    private void defineIcon(Object value, int row, int column) {
        if(value != null && value instanceof PieceModel){
           PieceModel newPiece = (PieceModel) value;
           PersonalizaPiece iconePersonalizado = new PersonalizaPiece(newPiece, 337, 337);
           this.setIcon(iconePersonalizado);
        } else {
            this.setIcon(null);
        }
    }

    protected void defineSize(JTable table, int column) {
       if(this.SQUARE_SIZE != null) {
            int columnSize = this.SQUARE_SIZE;
            TableColumnModel tableColumnModel = table.getColumnModel();
            TableColumn columnModel = tableColumnModel.getColumn(column);
            columnModel.setWidth(columnSize);
            columnModel.setMinWidth(columnSize);
            columnModel.setMaxWidth(columnSize);
            columnModel.setPreferredWidth(columnSize);
        } 
    }    
    
}
