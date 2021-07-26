package JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reproductor extends JFrame implements Runnable,ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelInferior;
	private JPanel panelCentral;
	
	private JLabel videoNom;
	private JLabel tempsTotal;
	private JLabel tempsParcial;
		
	private JButton reproduir;
	private JButton aturar;
	private JButton pausar;
	private JButton sortir;
	
	private String videoTempsTotal = "01:52:37";
	private String videoTempsParcial = "01:51:30";
	
	private Boolean reproduint = false;
	private Thread fil;
	
	public Reproductor() {
		super();
		configurarFinestra();
		inicialitzarComponents();
	}
	
	public void  configurarFinestra() {
		this.setTitle("REPRODUCTOR DE VIDEO"+"    Video : "+videoNom);
		this.setSize(450,150);
		this.setLocationRelativeTo(null);  //Centrar la pantalla
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}	
	
	private void inicialitzarComponents() {
		
		panelCentral();
		add(panelCentral, BorderLayout.CENTER);
		
		panelInferior();
		add(panelInferior, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	public void panelCentral() {
		panelCentral = new JPanel();
		
		tempsTotal = new JLabel("Durada del video : "+videoTempsTotal);		
		tempsParcial = new JLabel("    Temps de reproducció : "+videoTempsParcial);
				
		panelCentral.setLayout(new FlowLayout());
				
		panelCentral.add(tempsTotal);
		panelCentral.add(tempsParcial);
			
	}
	
	
	public void panelInferior() {
		panelInferior = new JPanel();
		
		reproduir = new JButton("Reproduir");
		aturar = new JButton("Aturar");
		pausar = new JButton("Pausar");
		sortir = new JButton("Sortir");
		
		panelInferior.setLayout(new FlowLayout());
		panelInferior.setBackground(Color.cyan);
		
		panelInferior.add(reproduir);
		panelInferior.add(aturar);
		panelInferior.add(pausar);
		panelInferior.add(sortir);
		
		reproduir.addActionListener(this);
		aturar.addActionListener(this);
		pausar.addActionListener(this);
		sortir.addActionListener(this);
		
	}
	
	@Override 
    public void actionPerformed( ActionEvent evt ) {
        
    	Object obj = evt.getSource();
        
    	
        if( obj instanceof JButton ){
        
        	JButton btn = (JButton)obj;
            
        	// Iniciar Reproducció ---------------------
            if( btn.getText().equals("Reproduir") ){
            	iniciarReproduccio();
            }
            
            //PausarReproduccio -------------------------
            if(btn.getText().equals("Pausar")) {
            	pausarReproduccio();
            }
            
          //Aturar Reproduccio -------------------------
            if(btn.getText().equals("Aturar")) {
            	aturarReproduccio();
            }
            
          //Sortir del reproductor -------------------------
            if(btn.getText().equals("Sortir")) {
            	setVisible(false); 
            	dispose(); 

            }  
        }
    }
	
	public void iniciarReproduccio() {
		reproduint =true;		
		fil = new Thread(this);
		fil.start();
	}
	
	public void pausarReproduccio() {
		reproduint = false;
	}
	
	public void aturarReproduccio() {
		reproduint = false;
		reinciarTempsReproduccio();
	}
    
	public void reinciarTempsReproduccio() {
		videoTempsParcial="00:00:00";
		tempsParcial.setText("    Temps de reproducció : "+videoTempsParcial);
	}
	
	@Override
	public void run() {
			System.out.println("Entro a run  "+videoTempsParcial);
			
			String h=null,m = null,s=null;
			int hores,minuts,segons;
			
			int[] parcial = horaInteger(videoTempsParcial);
			int[] llargaria = horaInteger(videoTempsTotal);
			
			hores = parcial[0];
			minuts = parcial[1];
			segons = parcial[2];
			System.out.println("abans del while  "+videoTempsParcial);
		
		while(reproduint) {
			
			// Si el temps de reproducció iguala al temps total del video. 
			//aturem reproducció, inicialitzem temps de reproducció
			if(hores==llargaria[0] & minuts==llargaria[1] & segons==llargaria[2]) {
				reproduint = false;				
				reinciarTempsReproduccio();				
			}else {
				
				if(segons == 59) {
					segons = 0;
					minuts++;
				}else if(minuts == 59) {
					minuts = 0;
					hores++;
				}else if(hores == 24) {
					hores = 0;
				}
				
				segons++;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				
				if(reproduint) {
				tempsParcial.setText("    Temps de reproducció : "+hores+":"+minuts+":"+segons);
				
				// donem format string al nou temps de reproducció.
				if(segons<10) {
					s="0"+segons;
				}else {
					s = Integer.toString(segons);
				}
					
				if (minuts<10) {
					m="0"+minuts;
				}else {
					m = Integer.toString(minuts);
				}	
				
				if (hores<10) {
					h="0"+hores;
				}else {
					h = Integer.toString(hores);
				}
				
				//Actualitzem la variable de temps de reproducció del video.			
				videoTempsParcial = h+":"+m+":"+s;
				}
				
				System.out.println(videoTempsParcial);
			}
		}
		
	}
	
	
	
	
	
	
	public static int[] horaInteger (String tempsActual) {
		int hores,minuts,segons;
		int[] resultat = new int[3];
		
		try {
			hores = Integer.parseInt(tempsActual.substring(0,2));
			minuts = Integer.parseInt(tempsActual.substring(3,5));
			segons = Integer.parseInt(tempsActual.substring(6,8));
			
			System.out.println(tempsActual);
			System.out.println(hores+" - "+minuts+" - "+segons);
			resultat[0] = hores;
			resultat[1] = minuts;
			resultat[2] = segons;			
			
		}catch(NumberFormatException nfe) {
			System.out.println("Error en convertir les dates de string a integer");
			System.out.println(nfe.getMessage());
			
		}
		
		return resultat;
	}
	
	
	

}
