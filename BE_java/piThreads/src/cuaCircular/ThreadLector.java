package cuaCircular;

public class ThreadLector extends Thread {

	private Magatzem magatzem;	//magatzem de sencers
	private int id;			   // id del Thread
	
	/**
	 * Constructor
	 * 
	 * @param magatzem
	 * @param id
	 */
	public ThreadLector(Magatzem magatzem, int id) {
		this.magatzem = magatzem;
		this.id = id;
	}
	
	
	public void run() {
		System.out.println("(L) lector "+id+" iniciat");
		try {
			while(true) {
				magatzem.llegirSencer();
			}
		}catch(InterruptedException ie) {
			System.out.println("lector "+id+" interromput");
		}
		System.out.println("(L) lector "+id+" finalitzat");
	}
	
	
	
}
