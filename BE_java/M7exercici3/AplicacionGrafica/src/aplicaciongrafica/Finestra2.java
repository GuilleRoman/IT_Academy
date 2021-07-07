/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Aplicació Gràfica
 */
package aplicaciongrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author juan J. Campos
 */
public class Finestra2 extends JFrame{
    
   JPanel panel;
   JLabel label;
   JButton boto;
   
   public Finestra2(){
    
       panel = new JPanel();
       label = new JLabel();
       boto = new JButton(); 
       
       this.add(panel);
       panel.add(label);
       panel.add(boto);
       
       label.setText("Hola mon mundial ......");
       boto.setText("Accionar ...");
       
   } 
    
    
}
