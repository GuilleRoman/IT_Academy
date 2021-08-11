package rockets.app;

import rockets.domain.Propulsor;

public class PropulsorAccelerar implements Runnable{

	private Propulsor propulsor;
	private int cadencia;
	
	
	public PropulsorAccelerar(Propulsor propulsor, int cadencia) {
		this.propulsor = propulsor;	
		this.cadencia = cadencia;
	}	
	
	
	@Override
	public void run() {
		Boolean iterar=true;
				
		while(iterar) {
			//Si el propulsor ha arribat a la potencia objectiu llavors aturem l'accelerada.
			if(propulsor.getPotenciaObjectiu() <= propulsor.getPotenciaActual()) {
				iterar=false;
			}else {
				//Actualitzem la potencia actual incrementant la potencia
				propulsor.setPotenciaActual(propulsor.getPotenciaActual()+cadencia);
				propulsor.setEtiqueta();
				
				// Esperem un segon.
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
