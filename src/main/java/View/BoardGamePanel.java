
package View;

import controller.GameBoardController;
import controller.GameCreateLevelController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;


public class BoardGamePanel extends javax.swing.JFrame {
    private GameBoardController gameController;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    
    public static final int LINHAS = 4;
    public static final int COLUNAS = 4;

    /**
     * Creates new form BoardGame
     */
    public BoardGamePanel() {
        initComponents();
        this.gameController = new GameBoardController(LINHAS, COLUNAS);
        this.definePropriedades();
        this.addComponentes();
    }
    
    public void iniciar(){
        this.setVisible(true);
    }
    
    private void addComponentes(){
        GameBoard board = this.gameController.getGameBoard();
        setLocationRelativeTo(null);
        
        this.setLayout(new GridBagLayout());
        // distancia padrao entre os componentes
        Insets defaultInsets = new Insets(5, 5, 5, 5);
        GridBagConstraints cons;
        //definir o posicionamento do board
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 5;
        cons.gridheight = 5;
        cons.anchor = GridBagConstraints.PAGE_START;
        cons.insets = defaultInsets;
        add(board, cons);       
        
        GameComandosPanel comandos = new GameComandosPanel(this.gameController); 
        cons.gridy = GridBagConstraints.CENTER;
        cons.gridwidth = 5;
        cons.gridheight = 5;
        add(comandos, cons);
        
        GameResultPanel resul = this.gameController.getGameResult();
        cons.gridx = 0;
        cons.gridy = GridBagConstraints.SOUTH;
        cons.gridwidth = 5;
        cons.gridheight = 5;
        add(resul, cons); 
      
    }
    
    public void atualiza(){
        this.addComponentes();
    }
    
    private void definePropriedades(){
        this.setSize(WIDTH, HEIGHT);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCorpo = new javax.swing.JPanel();
        jpAreaBotoes = new javax.swing.JPanel();
        panelInterno = new javax.swing.JInternalFrame();

        javax.swing.GroupLayout jpAreaBotoesLayout = new javax.swing.GroupLayout(jpAreaBotoes);
        jpAreaBotoes.setLayout(jpAreaBotoesLayout);
        jpAreaBotoesLayout.setHorizontalGroup(
            jpAreaBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jpAreaBotoesLayout.setVerticalGroup(
            jpAreaBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpCorpoLayout = new javax.swing.GroupLayout(jpCorpo);
        jpCorpo.setLayout(jpCorpoLayout);
        jpCorpoLayout.setHorizontalGroup(
            jpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAreaBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCorpoLayout.setVerticalGroup(
            jpCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCorpoLayout.createSequentialGroup()
                .addGap(0, 501, Short.MAX_VALUE)
                .addComponent(jpAreaBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelInterno.setBorder(null);
        panelInterno.setVisible(true);

        javax.swing.GroupLayout panelInternoLayout = new javax.swing.GroupLayout(panelInterno.getContentPane());
        panelInterno.getContentPane().setLayout(panelInternoLayout);
        panelInternoLayout.setHorizontalGroup(
            panelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        panelInternoLayout.setVerticalGroup(
            panelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conecte-me");
        setName("boardGame"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpAreaBotoes;
    private javax.swing.JPanel jpCorpo;
    private javax.swing.JInternalFrame panelInterno;
    // End of variables declaration//GEN-END:variables
}
