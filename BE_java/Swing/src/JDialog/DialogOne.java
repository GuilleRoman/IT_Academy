package JDialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogOne {
	
	private JFrame frame;	
	private JDialog dialog;
	
	
	public DialogOne(String titol) {
		this.frame = new JFrame();
		this.dialog = new JDialog(frame,titol,true);
	}
	
	

}
