package cuaCircular;



/**
 * 
 * <p>IT Academy BE Java</>
 *
 * @author juanj
 * 
 *<p>THREADS </p>
 *
 * Model Consumidor productor
 * 
 * 27 de jul. 2021
 */
public class Inici {

	
	public static void main(String[] args) {
		Magatzem magatzem = new Magatzem(4);
		
		ThreadEscriptor te1 = new ThreadEscriptor(magatzem, 1);
		ThreadEscriptor te2 = new ThreadEscriptor(magatzem, 2);
		ThreadEscriptor te3 = new ThreadEscriptor(magatzem, 3);
		ThreadEscriptor te4 = new ThreadEscriptor(magatzem, 4);
		ThreadEscriptor te5 = new ThreadEscriptor(magatzem, 5);
		
		ThreadLector tl1 = new ThreadLector(magatzem, 1);
		ThreadLector tl2 = new ThreadLector(magatzem, 2);
		ThreadLector tl3 = new ThreadLector(magatzem, 3);
		ThreadLector tl4 = new ThreadLector(magatzem, 4);
		ThreadLector tl5 = new ThreadLector(magatzem, 5);
		
		te1.start();
		te2.start();
		te3.start();
		te4.start();
		te5.start();
		
		tl1.start();
		tl2.start();
		tl3.start();
		tl4.start();
		tl5.start();
		
		try {
			te1.join();
			te2.join();
			te3.join();
			te4.join();
			te5.join();
						
			while(!magatzem.estaBuit()) {
				Thread.sleep(100);
			}
			
			tl1.interrupt();
			tl2.interrupt();
			tl3.interrupt();
			tl4.interrupt();
			tl5.interrupt();
			
		}catch(InterruptedException ie) {
			System.out.println("Interrupció : \n");
			ie.printStackTrace();
		}
		
		
	}

}
