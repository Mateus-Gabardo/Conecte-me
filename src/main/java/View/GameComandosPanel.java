
package View;

import controller.GameBoardController;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GameComandosPanel extends JPanel{
    private static final int BUTTON_WIDTH = 155;
    private static final int BUTTON_HEIGHT = 30;
    private List<JButton> bottoes;
    private GameBoardController gameController;

    public GameComandosPanel(GameBoardController gameController) {
        this.bottoes = new ArrayList<>();
        this.gameController = gameController;
        this.init();
    }
    
    private void init(){
       this.initComponent();
       this.addComponents();
    }
    
    private void initComponent(){
      this.bottoes.add(this.createButton("Carregar", new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              gameController.carregar();
          }
      }));
      
      this.bottoes.add(this.createButton("Largura", new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               gameController.buscarLargura();
          }
      }));
      
      this.bottoes.add(this.createButton("Profundidade", new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  gameController.buscarProfundidade();
              } catch (Exception ex) {
                  Logger.getLogger(GameComandosPanel.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }));
      
      this.bottoes.add(this.createButton("Sobre", new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               gameController.sobre();
          }
      }));
      
      this.bottoes.add(this.createButton("Criar fase", new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               gameController.abreCriarFase();
          }
      }));
    }
    
    private void addComponents(){
        setLayout(new GridBagLayout());
        int x= 0;
        for(JButton button : this.bottoes){
            this.add(button, this.createConstraints(x++));
        }
    }
    
    private JButton createButton(String nome, ActionListener actionListener) {
        JButton button = new JButton();
        button.setText(nome);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.addActionListener(actionListener);
        return button;
    }
    
    	private GridBagConstraints createConstraints(int x) {
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridx = x;
            cons.anchor = GridBagConstraints.SOUTH;
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.insets = new Insets(5, 5, 5, 5);
            return cons;
	}
}
