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
			if(propulsor.getPotenciaObjectiu() <= propulsor.getPotenciaActual()) {
				iterar=false;
			}else {
				propulsor.setPotenciaActual(propulsor.getPotenciaActual()+cadencia);
				propulsor.setEtiqueta();
				
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
