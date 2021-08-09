package cuaCircular;

public class ThreadEscriptor extends Thread {

	private Magatzem magatzem;
	private int id;
	
	/**
	 * Constructor
	 * 
	 * @param magatzem	//magatzem de sencers
	 * @param id	   //index del thread
	 */
	public ThreadEscriptor(Magatzem magatzem, int id) {
		this.magatzem = magatzem;
		this.id = id;
	}
	
	/**
	 * run()
	 * Mètode abstracte a sobreescriure
	 */
	@Override
	public void run() {
		System.out.println("(E) escriptor "+id+" iniciat ....");
		try {
			for(int i=0; i<10;i++) {
				magatzem.escriureSencer((i*10)+i);
				//System.out.print((i*10)+i+" ,");
			}
		}catch(InterruptedException ie) {
			System.out.println("Thread interromput ");
		}
		
		System.out.println("(E) escriptor "+id+" finalitzat");
	}
	
	
}
