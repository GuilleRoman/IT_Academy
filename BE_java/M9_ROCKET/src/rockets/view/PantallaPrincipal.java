package rockets.view;

import java.awt.Color;

import javax.swing.JFrame;

import rockets.domain.Coet;

public class PantallaPrincipal extends JFrame {
		
	private static final long serialVersionUID = 1L;
	CoetPantalla coetPant1,coetPant2;
	PanelControl panelControl1, panelControl2;
	
	Coet coet1,coet2;
	
	public PantallaPrincipal(Coet coet1, Coet coet2) {
		this.setBounds(50, 50, 670, 560);
		setTitle("Plataforma de llançament de coets");
		
		coetPant1 = new CoetPantalla(coet1);
		coetPant1.setBounds(20, 20, 280, 300);
		coetPant1.setBackground(Color.lightGray);
		
		coetPant2 = new CoetPantalla(coet2);
		coetPant2.setBounds(360, 20, 280, 300);
		coetPant2.setBackground(Color.lightGray);
		
		panelControl1 = new PanelControl(coet1);
		panelControl1.setBounds(20,325,280,160);
		panelControl1.setBackground(Color.LIGHT_GRAY);
		
		panelControl2 = new PanelControl(coet2);
		panelControl2.setBounds(360,325,280,160);
		panelControl2.setBackground(Color.LIGHT_GRAY);
		
		add(coetPant1);
		add(coetPant2);
		
		add(panelControl1);
		add(panelControl2);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}

	public CoetPantalla getCoetPant1() {
		return coetPant1;
	}

	public void setCoetPant1(CoetPantalla coetPant1) {
		this.coetPant1 = coetPant1;
	}

	public CoetPantalla getCoetPant2() {
		return coetPant2;
	}

	public void setCoetPant2(CoetPantalla coetPant2) {
		this.coetPant2 = coetPant2;
	}
	
	

}
