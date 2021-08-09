package Text;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Text extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta;
	private JTextField caixaText;
	private JTextField caixaText1;
	
	public Text() {
		this.setLayout(null);
		this.setBounds(10, 10, 400, 400);
		afegirComponents();
	}
	
	public void afegirComponents() {
		
		etiqueta = new JLabel("Dades :");
		etiqueta.setBounds(10, 10, 90, 20);
		
		caixaText = new JTextField(4);
		caixaText.setText("1230");
		caixaText.setBounds(100, 10, 80, 20);
		caixaText.setBackground(Color.magenta);
		
		caixaText1 = new JTextField(4);
		caixaText1.setText("1230");
		caixaText1.setBounds(10, 40, 80, 20);
		caixaText1.setBackground(Color.magenta);
		/*
		caixaText.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			      System.out.println("Pulsado enter");
			      System.out.println(((JTextField)e.getSource()).getText());
			   }
			});
		*/
		caixaText.addFocusListener((FocusListener) new FocusListener() {
			   public void focusLost(FocusEvent e) {
			      System.out.println("Perdido foco");
			      System.out.println(((JTextField)e.getSource()).getText());
			   }
			   public void focusGained(FocusEvent e) {
			      caixaText.selectAll();
			   }
			});
		
		
		// Listen for changes in the text
		caixaText.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void removeUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void insertUpdate(DocumentEvent e) {
		    //warn();
		  }

		  public void warn() {
			  try {
		            Integer.parseInt(caixaText.getText());
		            
		            if (Integer.parseInt(caixaText.getText())<0){
		 		       JOptionPane.showMessageDialog(null,
		 		          "Error: La velocitat no pot ser negativa", "Error Message",
		 		          JOptionPane.ERROR_MESSAGE);
		 		     }else {
		 		    	JOptionPane.showMessageDialog(null,
				 		          "valor : "+ caixaText.getText(),
				 		          getTitle(), JOptionPane.INFORMATION_MESSAGE); 
		 		     }
		            
		        } catch (NumberFormatException excepcion) {
		        	JOptionPane.showMessageDialog(null,
		   		          "Error: La velocitat inserida no és un nombre sencer", "Error Message",
		   		          JOptionPane.ERROR_MESSAGE);
		        	caixaText.setFocusable(true);
		        }
		     
		     
		  }
		});
		
		
		
		
		
		
		
		
		add(etiqueta);
		add(caixaText);
		add(caixaText1);
	}

}
