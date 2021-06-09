package N3;


import java.util.Date;
import java.util.GregorianCalendar;

public class Cronometre implements Runnable{
	
	private int hores=0,minuts=0,segons=0;
	private Thread h1;
	
	public Cronometre(int hores, int minuts, int segons) {
		
		this.hores=hores;
		this.minuts=minuts;
		this.segons=segons;
		
		h1 = new Thread(this);
		h1.start();
		
	}
	
	private void calculaHora() {
		segons++;
		
		if(segons==60) {
			minuts++;
			segons=0;
			
			if(minuts==60) {				
				minuts=0;				
				if(hores==24) {
					hores=0;
				}else {
					hores++;
				}
			}
		}
		
	}
	
	
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		
		while(ct==h1) {
			calculaHora();
			System.out.println(hores+" : "+minuts+" : "+segons);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				System.out.println(ie.getCause());
			}
			
		}
		
	}

}
