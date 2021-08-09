package rockets.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rockets.app.ActualitzaVelocitat;
import rockets.app.PropulsorAccelerar;
import rockets.app.PropulsorFrenar;
import rockets.domain.Coet;
import rockets.domain.Propulsor;

public class PanelControl extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton accelerar = new JButton("accelerar");
	private JButton frenar = new JButton("frenar");
	private JButton parar = new JButton("parar");
	
	private JLabel velocitatLabel;
	private JLabel velocitatInLabel;
	private JLabel accelerarLabel;
	private JTextField velocitat;
	
	private JTextField velocitatIn;
	private JTextField accelerarText;
	
	private Coet coet;
	private int cadencia = 1;		// Cadència en l'acceleració o frenada del coet
	private int potNecessaria;	   // Potència necessaria per assolir la velocitat indicada al textField
	

	public PanelControl(Coet coet) {
		this.coet = coet;		
		setLayout(null);
		frenar.setEnabled(false);
		
		// Definició i configuració dels controls del control panel.  
		velocitatLabel = new JLabel("Velocitat : ");
		velocitatLabel.setBounds(10, 10, 90, 20);
				
		velocitat = new JTextField();
		velocitat.setBounds(110, 10, 90, 20);		
				
		velocitatInLabel = new JLabel("Velocitat inicial : ");
		velocitatInLabel.setBounds(10, 40, 110, 20);
				
		velocitatIn = coet.getVelocitatActual();
		velocitatIn.setBounds(110, 40, 90, 20);
		
		accelerarLabel = new JLabel("Acceleració :");
		accelerarLabel.setBounds(10, 70, 110, 20);
		
		accelerarText = new JTextField();
		accelerarText.setBounds(110,70,40,20);
		
		this.velocitat.setText("0");
		this.velocitatIn.setText("0");
		this.velocitatIn.setEditable(false);
		this.accelerarText.setText("1");
		
		accelerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accelerar.setEnabled(false);
				frenar.setEnabled(true);
				parar.setEnabled(true);
				accioBotonera(e);
			}
		});

		frenar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accelerar.setEnabled(true);
				frenar.setEnabled(false);
				parar.setEnabled(true);
				accioBotonera(e);
			}
		});
		
		parar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accelerar.setEnabled(true);
				frenar.setEnabled(true);
				parar.setEnabled(false);
				accioBotonera(e);
			}
		});
		
				
		
		// Accions, events  sobre la caixa de text velocitat ---------------
		velocitat.addActionListener(new ActionListener() {
			   //En pulsar Enther al JtextField de velocitat calcula la potència dels propulsors per assolir la
			  // la nova velocitat.
			   public void actionPerformed(ActionEvent e) {
				   int valor = rockets.app.Utilitats.esSencerPositiu(velocitat.getText());
				   if(valor !=-1) { 
					  calcularPotenciaNecessaria(valor);					  
			   	  }else{
			   		JOptionPane.showMessageDialog(null,
			 		  "Error: La velocitat ha de ser un nombre sencer positiu", "Error Message",
			 		  JOptionPane.ERROR_MESSAGE);
			      }
			   }	   
			});
		
		// Accions, events  sobre la caixa de text cadencia acceleració-frenada. ---------------
		accelerarText.addActionListener(new ActionListener() {
					   //En pulsar Enther al JtextField de cadència modifica la cadencia en el progrés dels propulsors.
					   public void actionPerformed(ActionEvent e) {
						   int valor = rockets.app.Utilitats.esSencerPositiu(accelerarText.getText());
						   if(valor !=-1) { 
							  cadencia = valor;
							  calcularPotenciaNecessaria(Integer.parseInt(velocitat.getText()));
					   	  }else{
					   		JOptionPane.showMessageDialog(null,
					 		  "Error: La cadencia ha de ser un nombre sencer positiu", "Error Message",
					 		  JOptionPane.ERROR_MESSAGE);
					      }
					   }	   
					});
		
		
		
		
		
		accelerar.setBounds(10, 100, 90, 40);
		frenar.setBounds(110, 100, 70, 40);	
		parar.setBounds(190, 100, 80, 40);
		
		
		add(velocitatLabel);
		add(velocitat);
		add(velocitatInLabel);
		add(velocitatIn);
		add (accelerarLabel);
		add (accelerarText);
		
		add(accelerar);
		add(frenar);
		add(parar);
		
		setVisible(true);
		
		calcularVelocitatActual();
	}
	
	
	public void calcularVelocitatActual() {		
		Runnable av = new ActualitzaVelocitat(coet);
		Thread trVelAct;
		
		trVelAct = new Thread (av);
		trVelAct.start();
	}
	
	/**
	 * accioBotonera
	 * 
	 * Determina les accions dels botons accelerar, frenar i parar
	 * 
	 * @param 	e		ActionEvent
	 */
	public void accioBotonera(ActionEvent e) {
		
		// ----- ACCELERAR ------------------------------
		if(e.getSource() == accelerar) {
			accelerar();
		}
		
		// ----- FRENAR----------------------------------
		if(e.getSource() == frenar) {
			frenar();
		}
		
		// ----- PARAR ----------------------------------
		if (e.getSource() == parar) {
			
			for(Propulsor prop : coet.getPropulsors()) {
				if (prop.getFil() != null) {
					prop.getFil().interrupt();
				}		
			}
		}
	}
	
	public void accelerar() {
		for(Propulsor prop : coet.getPropulsors()) {
			
			// Si el fil no és null el reinicialitzem
			if(prop.getFil()!=null) {
				System.out.println("Fil interromput en l'acceleració  ");
				prop.getFil().interrupt();				
			}
			
			Runnable r = new PropulsorAccelerar(prop, cadencia);
			prop.setFil(r);
			prop.getFil().start();
			
		}
	}
	
	public void frenar() {
		for(Propulsor prop : coet.getPropulsors()) {
			
			// Si el fil no és null el reinicialitzem
			if(prop.getFil()!=null) {
				System.out.println("Fil interromput en la frenada ");
				prop.getFil().interrupt();
			}
			
			Runnable r = new PropulsorFrenar(prop,cadencia);
			prop.setFil(r);
			prop.getFil().start();
			
		}
	}
	
	/**
	 * calcularPotenciaTotal
	 * 
	 * Calcula la potencia total del propulsors i
	 * el nombre de propulsors del coet.
	 * 
	 * @return	respost	int[2]   potenciaTotal, nombre propulsors
	 */
	public int[] calculPotenciaTotal(){
		int[] resPot = new int[2];		
		
		for(Propulsor prop : coet.getPropulsors()) {
			resPot[0] += prop.getPotenciaMax();
			resPot[1]+=1;
		}
		
	  return resPot;
	}
	
	
	
	public void calcularPotenciaNecessaria(int valor) {
		int potNecessaria=0;		   // Potència necessaria per assolir la velocitat valor
		int potCoet=0;				  // Potència de tots els propulsors del coet
		int nombrePropulsors=0;		 // Nombre de propulsors del coet
		
		// Calculem la potència necessaria per assolir la velocitat passada per paràmetre.
		
		potNecessaria = (int) Math.pow((valor-Double.parseDouble(velocitatIn.getText())/100), 2);
		
		//Determinem si amb els propulsors del coet podem assolir la velocitat inserida.		
		potCoet = calculPotenciaTotal()[0];
		nombrePropulsors = calculPotenciaTotal()[1];
		
		if(potCoet < potNecessaria) {
			
			JOptionPane.showMessageDialog(null,
	 		          "Error: El coet no pot assolir la velocitat inserida", "Error Message",
	 		          JOptionPane.ERROR_MESSAGE);
			
		}else {
			System.out.println(" ------------------------------------- ");
			System.out.println("Velocitat inicial    : "+velocitatIn.getText());
			System.out.println("Velocitat a assolir  : "+velocitat.getText());
			System.out.println("Potencia necessaria  : "+potNecessaria);
			System.out.println("Nombre de propulsors : "+nombrePropulsors);			
			int potenciaRestant =potNecessaria;
			
			// Assignem la potència objectiu als propulsors.
			for(Propulsor prop : coet.getPropulsors()) {
				System.out.println("Potencia Restant : "+potenciaRestant);
				
				// Si la potència a assolir és positiva -----
				if(potNecessaria >0) {				
					if(potenciaRestant > 0) {
						if (prop.getPotenciaMax() < potenciaRestant) {
							prop.setPotenciaObjectiu(prop.getPotenciaMax());
							potenciaRestant -=prop.getPotenciaMax();
						}else {
							prop.setPotenciaObjectiu(potenciaRestant);
							potenciaRestant = 0;
						}						
						System.out.println("propulsor : "+prop.getPotenciaObjectiu());
					}else {
						prop.setPotenciaObjectiu(0);
					}
				}else { //Si la potència a assolir és negativa -----
					if(Math.abs(potenciaRestant) > 0) {
						if(prop.getPotenciaMax() < Math.abs(potenciaRestant)){
							potenciaRestant+=prop.getPotenciaMax();
							prop.setPotenciaObjectiu(prop.getPotenciaMax());
							
						}else {
							prop.setPotenciaObjectiu(Math.abs(potenciaRestant));
							potenciaRestant = 0;
						}
					}else { // Si no hi ha increment de potència llavors igualo els propulsors a zero.					
						prop.setPotenciaObjectiu(0);
					}
					
					System.out.println("propulsor : "+prop.getPotenciaObjectiu());
				}
			}
			
			// Ordenem a cada propulsor que acceleri o freni per tal
			// d'assolir la velocitat indicada.
			for(Propulsor prop : coet.getPropulsors()) {
				
				// Si el propulsor té més potència de la necessaria frenem fins a potència objectiu
				if(prop.getPotenciaActual() > potNecessaria) {
					// Si el fil no és null el reinicialitzem
					if(prop.getFil()!=null) {
						prop.getFil().interrupt();
					}
					
					Runnable r = new PropulsorFrenar(prop, cadencia);
					prop.setFil(r);
					prop.getFil().start();
				}
				
				// Si el propulsor té menys potència de la necessaria accelerem fins a potència objectiu
				if(prop.getPotenciaActual() < potNecessaria) {
					// Si el fil no és null el reinicialitzem
					if(prop.getFil()!=null) {
						prop.getFil().interrupt();
					}
					
					Runnable r = new PropulsorAccelerar(prop, cadencia);
					prop.setFil(r);
					prop.getFil().start();
				}				
			}
		}		
	}	
}
