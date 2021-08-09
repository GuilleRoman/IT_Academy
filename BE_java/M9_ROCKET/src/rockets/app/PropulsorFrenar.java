package rockets.app;

import rockets.domain.Propulsor;

public class PropulsorFrenar implements Runnable {

	private Propulsor propulsor;
	private int cadencia;
	
	public PropulsorFrenar(Propulsor propulsor, int cadencia) {
		this.propulsor = propulsor;
		this.cadencia = cadencia;
	}	
	
	
	@Override
	public void run() {
		Boolean iterar=true;
			
		while(iterar) {
			
			// Si la potència és zero llavors finalitzar la resta de valors
			if(propulsor.getPotenciaActual() <= 0) {
				iterar=false;
			}else {
				// Actualitzem la potencia (decrementar un)
				if(propulsor.getPotenciaObjectiu() == propulsor.getPotenciaActual()) {
					iterar=false;
				} else {
					propulsor.setPotenciaActual(propulsor.getPotenciaActual()-cadencia);
					propulsor.setEtiqueta();			
					
					// Esperem un segon
					try {
						Thread.sleep(1000);										
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
				}
			}			
		}		
	}
	
	
}
