package rockets.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class Coet {
	
	private String codi;
	private List<Propulsor> propulsors = new ArrayList<Propulsor>();
	private JTextField velocitatActual = new JTextField();
	
	// CONSTRUCTORS ----------------------------------------
	public Coet(String codi, List<Propulsor> propulsors) {
		this.codi = codi;
		this.propulsors = propulsors;
		this.velocitatActual.setText("0"); 
	}
		
	// GETTERS SETTERS  AND TOSTRING ---------------------------------
	public String getCodi() {
		return codi;
	}

	public List<Propulsor> getPropulsors() {
		return propulsors;
	}	
	
	public String getPotencies() {
		String potencies= "[ ";
		
		for(Propulsor prop : propulsors) {
			potencies += prop.getPotenciaMax()+" ";
		}
		
		potencies +=" ]";
		return potencies;
	}
	
	public JTextField getVelocitatActual() {
		return velocitatActual;
	}

	public void setVelocitatActual(String velocitatActual) {
		this.velocitatActual.setText(velocitatActual);
	}


	@Override
	public String toString() {
		return "Coet [codi=" + codi + ", propulsors=" + propulsors + "]";
	}

	
	// CALCULS DE LES DIFERENTS POTÈNCIES ----------------------------------
	public String getPotenciesActuals() {
		String potencies= "[ ";
		
		for(Propulsor prop : propulsors) {
			potencies += prop.getPotenciaActual()+" ";
		}
		
		potencies +=" ]";
		return potencies;
	}
	
	public String getPotenciesObjectiu() {
		String potencies= "[ ";
		
		for(Propulsor prop : propulsors) {
			potencies += prop.getPotenciaObjectiu()+" ";
		}
		
		potencies +=" ]";
		return potencies;
	}
	
}
