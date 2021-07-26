package com.video.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.video.application.Aturat;
import com.video.application.Pause;
import com.video.application.Reproduint_se;
import com.video.domain.Video;

public class Reproductor extends JFrame implements Runnable,ActionListener{

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
	
	private String videoTempsTotal;
	private String videoTempsParcial;
	
	private Boolean reproduint = false;
	private Thread fil;
	
	Video video;
	
	/**
	 * Constructor 
	 * 
	 * @param video
	 */
	public Reproductor(Video video) {
		super();
		this.video = video;
		videoTempsTotal = video.getDuradaVideo();
		videoTempsParcial = video.getTempsActual();
		configurarFinestra();
		inicialitzarComponents();
	}
	
	/**
	 * Paràmetres de confiració de la finestra jframe
	 * 
	 */
	public void  configurarFinestra() {
		this.setTitle("REPRODUCTOR DE VIDEO"+"    Video : "+videoNom);		
		this.setBounds(10, 20, 450, 150);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}	
	
	/**
	 * Inicialitza els panells del BorderLayout
	 */
	private void inicialitzarComponents() {
		
		panelCentral();
		add(panelCentral, BorderLayout.CENTER);
		
		panelInferior();
		add(panelInferior, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	/**
	 * Panell central del BorderLayout
	 */
	public void panelCentral() {
		panelCentral = new JPanel();
		
		tempsTotal = new JLabel("Durada del video : "+videoTempsTotal);		
		tempsParcial = new JLabel("    Temps de reproducció : "+videoTempsParcial);
				
		panelCentral.setLayout(new FlowLayout());
				
		panelCentral.add(tempsTotal);
		panelCentral.add(tempsParcial);
			
	}
	
	/**
	 * Panell inferior del BorderLayout
	 */
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
	
	/**
	 * Accions a fer via Buttons.
	 */
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
	
	/**
	 * Inicia la reproducció del video.
	 */
	public void iniciarReproduccio() {
		reproduint =true;
		video.setEstatus(new Reproduint_se(video));
		fil = new Thread(this);
		fil.start();
	}
	
	/**
	 * Pausar el video  	  
	 */
	public void pausarReproduccio() {
		video.setEstatus(new Pause(video));
		reproduint = false;
	}
	
	/**
	 * Aturar la reproducció i reiniciar el temps de reproducció
	 */
	public void aturarReproduccio() {
		reproduint = false;
		video.setEstatus(new Aturat(video));
		reinciarTempsReproduccio();
	}
    
	/**
	 * Reinicia el temps de reproducció a 00:00:00
	 */
	public void reinciarTempsReproduccio() {
		video.setTempsActual("00:00:00");		
		tempsParcial.setText("    Temps de reproducció : "+video.getTempsActual());
	}
	
	@Override
	public void run() {
			
			
			String h=null,m = null,s=null;
			int hores,minuts,segons;
			
			int[] parcial = horaInteger(video.getTempsActual());
			int[] llargaria = horaInteger(videoTempsTotal);
			
			hores = parcial[0];
			minuts = parcial[1];
			segons = parcial[2];
			
		
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
				
				// Esperem un segons i continuem l'execució
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				
				// Actualitzem el label amb el temps actual de reproducció
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
				
				// Actualitzem el valor del temps de reproducció a l'objecte video.8
				this.video.setDuradaVideo(videoTempsParcial);
				//System.out.println(videoTempsParcial);
			}
		}
		
	}
	
	/**
	 * Converteix una hora en format String a format integer
	 * 
	 * @param tempsActual	String "hh:mm:ss"
	 * @return	resultat[3]	int	hh:mm:ss
	 */
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
