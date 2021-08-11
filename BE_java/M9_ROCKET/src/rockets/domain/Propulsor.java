package rockets.domain;

import javax.swing.JLabel;

public class Propulsor {
	
	private int potenciaMax;
	private int potenciaActual;
	private int potenciaObjectiu;
	private Thread fil;
	private JLabel etiqueta = new JLabel();

	
	// ------ CONSTRUCTOR ------------------
	public Propulsor(int potenciaMax) {
		
		this.potenciaMax = potenciaMax;
		this.potenciaActual = 0;
		// La potència objectiu la calculem com un 10% menys de la potència total; 
		this.potenciaObjectiu =(int)(potenciaMax-(potenciaMax*0.10));
	}

	------ GETTERS SETTERS -------------------------------------------------------	
	public int getPotenciaMax() {
		return potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public int getPotenciaActual() {
		return potenciaActual;
	}

	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
		
	}

	public int getPotenciaObjectiu() {
		return potenciaObjectiu;
	}

	public void setPotenciaObjectiu(int potenciaObjectiu) {
		this.potenciaObjectiu = potenciaObjectiu;
	}	

	public Thread getFil() {
		return fil;
	}

	public void setFil(Runnable r) {
		this.fil = new Thread(r);
	}
	
	public JLabel getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta() {
		etiqueta.setText(potenciaActual+"");
	}
	
	
}
