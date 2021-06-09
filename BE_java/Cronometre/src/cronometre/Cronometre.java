package cronometre;


public class Cronometre  implements Runnable {

	private int hores, minuts, segons;
	
	
	public Cronometre(int hores, int minuts, int segons) {
		this.hores=hores;
		this.minuts=minuts;
		this.segons=segons;		
	}
	
	
	@Override
	public void run() {
		String temps;
		
		while(true) {
			temps="";
			
			if(hores<10) {
				temps+="0"+hores;
			}else {
				temps+=hores;
			}
			
			temps+=" : ";
			
			if(minuts<10) {
				temps+="0"+minuts;
			}else {
				temps+=minuts;
			}
			
			temps+=" : ";
			
			if(segons<10) {
				temps+="0"+segons;
			}else {
				temps+=segons;
			}
			
			segons++;
			
			if(segons==60) {
				minuts++;
				segons=0;
				if(minuts==60) {
					hores++;
					minuts=0;
					if(hores==24) {
						hores=0;
					}
				}
			}
			
			
			
		}
		
		
	}

	
}
