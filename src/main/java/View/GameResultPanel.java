
package View;

import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gabardo
 */
public class GameResultPanel extends JPanel {
    private String status;
    private JTextField jtext;

    public GameResultPanel(String status) {
        this.status = status;
        this.init();
    }
    
    public void setStatus(String status){
       this.status = status; 
    }
    
    private void init(){
       this.addComponents();
    }
       
    private void addComponents(){
        jtext = createJTextField();
        this.add(jtext);
    }
    
    public void refresh(){
        this.remove(jtext);
        this.init();
        
    }

    private JTextField createJTextField() {
        JTextField status = new JTextField();
        status.setText(this.status);
        status.setEditable(false);
        status.setMargin(new Insets(5, 10, 5, 10));
        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        return status;
    }
}
