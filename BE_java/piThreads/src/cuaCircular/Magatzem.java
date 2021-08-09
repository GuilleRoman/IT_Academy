package cuaCircular;

public class Magatzem {

	private int[] magatzem;
	private int indexLectura;
	private int indexEscriptura;
	
	/**
	 * Constructor 
	 * 
	 * @param tamany	Tamany de l'array de sencers.
	 */
	public Magatzem(int tamany) {
		this.magatzem = new int[tamany];
		indexLectura = 0;
		indexEscriptura = 0;
	}
		
	/**
	 * llegir sencer 
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized int llegirSencer() throws InterruptedException {
		int resultat;
		
		while (indexLectura == indexEscriptura) {
			wait(); //s' allibera el flag de bloqueig i s'insereix a la lista d'espera
		}
		
		resultat = magatzem[indexLectura];
		indexLectura = ((indexLectura+1)% magatzem.length);
		//valorIndex();
		notify(); //Desperta un dels threads (seleccionat aleatoriament)
		return resultat;
	}
	
	/**
	 * escriure Sencer
	 * 
	 * @param sencer
	 * @throws InterruptedException
	 */
	public synchronized void escriureSencer(int sencer) throws InterruptedException {
		//Mentre iLectura major iEscriptura OR iLectura=0 i iEscriptura=magatzem.length.
		while(((indexLectura - indexEscriptura)==-1) || ((indexEscriptura-indexLectura) == (magatzem.length-1))) {
			wait(); //s' allibera el flag de bloqueig i s'insereix a la lista d'espera
		}
		
		magatzem[indexEscriptura] = sencer;
		indexEscriptura = ((indexEscriptura+1)% magatzem.length);
		//valorIndex();
		notify();	//Desperta un dels threads (seleccionat aleatoriament)	
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean estaBuit() {
		//valorIndex();
		System.out.println("buit = "+(indexLectura==indexEscriptura));
		return (indexLectura==indexEscriptura);
	}
	
	/**
	 * 
	 */
	public void valorIndex() {
		System.out.print("i. lectura    : "+indexLectura);
		System.out.println("   i. escriptura : "+indexLectura);
	}
	
}
