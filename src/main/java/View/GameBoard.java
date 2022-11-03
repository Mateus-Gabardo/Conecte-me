package View;



import View.DefaultTablePieceCellRenderer;
import controller.GameBoardController;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import model.GameBoardModel;


public class GameBoard extends JTable{
    private int tamanhoArea;
    private TableModel model;
    private TableCellRenderer celula;
    private GameBoardController gameController;
    
    public GameBoard(GameBoardController gameController) {
        this.gameController = gameController;
        init();
    }
    
    private void init(){
       this.tamanhoArea = 157;
       this.defineProperties();
       this.iniciaComponentes();
       this.addComponentes();
    }

    private void defineProperties() {
        this.setOpaque(false);
        this.setRowHeight(this.tamanhoArea);
        this.setBackground(new Color (92, 142, 203));
        Color gridColor = new Color(42, 94, 157);
        this.setBorder(BorderFactory.createLineBorder(gridColor));
        this.setGridColor(gridColor);
    }
    
    private void iniciaComponentes(){
       this.model  = new GameBoardModel(this.gameController);
       this.celula = new DefaultTablePieceCellRenderer(this.calculateTamanhoEsquadro(), this.gameController);
    }
    
    private void addComponentes(){
        this.setModel(this.model);
        this.setDefaultRenderer(Object.class, this.celula);
    }

    
    private int calculateTamanhoEsquadro() {
        final int maximo = 650;
        return (int) (maximo / gameController.getRowCount());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public void refresh(){
        this.init();
    }
}
