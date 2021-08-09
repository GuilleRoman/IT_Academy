package rockets.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import rockets.domain.Coet;
import rockets.domain.Propulsor;


public class CoetPantalla extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private JLabel potenciaObjectiuLabel;
	private JLabel potenciaPropulsorsLabel;
	private JLabel potenciaActualLabel;
	private JLabel propulsorsLabel; 	
	private JLabel nomLabel;
	
	/**
	 * Constructor 
	 * 
	 * @param coet
	 */
	public CoetPantalla (Coet coet) {
		
		setLayout(null);				
		
		// Mostrem el nom del coet
		nomLabel = new JLabel( "COET : "+coet.getCodi(), SwingConstants.LEFT);
		nomLabel.setBounds(10, 0, 200, 100);
		this.add(nomLabel);
		
		//Mostrem el nombre de propulsor que té.
		propulsorsLabel = new JLabel("Nombre de propulsors : "+coet.getPropulsors().size());
		propulsorsLabel.setBounds(10, 50, 200, 100);			
		this.add(propulsorsLabel);
		
		// Mostrem les potències màximes.
		potenciaPropulsorsLabel = new JLabel("Potències màximes : "+coet.getPotencies());
		potenciaPropulsorsLabel.setBounds(10,80,250,100);
		this.add(potenciaPropulsorsLabel);
		
		//Mostrem les potències objectiu les quals no superarem mai.
		potenciaObjectiuLabel = new JLabel("Potències Objectiu  : "+coet.getPotenciesObjectiu());
		potenciaObjectiuLabel.setBounds(10,110,250,100);
		this.add(potenciaObjectiuLabel);
		
		//mostrem les potencies inicials al crear el coet.
		potenciaActualLabel = new JLabel("Potències Actuals inicials : "+coet.getPotenciesActuals());
		potenciaActualLabel.setBounds(10,140,250,100);
		this.add(potenciaActualLabel);
		
		
		// Creem un label per a cada propulsor del coet, que mostra la seva potència en temps real.
		int x =0; 
		for(Propulsor prop : coet.getPropulsors()) {
			JLabel  potActLabel = prop.getEtiqueta();	//label de l'objecte Propulsor
			potActLabel.setBounds(10+x,160,250,100);
			x = x+30;
			this.add(potActLabel);
		}
	}
}	
	

