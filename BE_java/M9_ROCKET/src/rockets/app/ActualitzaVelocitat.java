package rockets.app;

import rockets.domain.Coet;
import rockets.domain.Propulsor;

public class ActualitzaVelocitat implements Runnable {
	
	private Coet coet;	
	private double velocitat = 0;
	
	public ActualitzaVelocitat (Coet coet) {
		this.coet = coet;
		
	}
	
	@Override
	public void run() {
			
		int totalPropulsors;
			
		while(true) {
			totalPropulsors=0;
			
						
			
			// Calculo la potencia de tots els propulsors
			for(Propulsor prop : coet.getPropulsors()) {
				totalPropulsors += prop.getPotenciaActual();
			}
			
			//Calculo la velocitat actual
			velocitat =Math.sqrt(totalPropulsors); 
			 													// Actualitzo la velocitat inicial
			coet.setVelocitatActual(velocitat+""); 									   // Mostrem la velocitat a PanelDeControl	
			
			
			// Esperem un segon
			try {
				Thread.sleep(1000);										
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Error ActualitzarVelocitat class \n thead sleep (1000) ");
			}
		}	
	}
}
