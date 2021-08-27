package Sencers;

public class Naturals implements Proveidor{
	private static int seguent = 0;
	
	@Override
	public Integer obtenir() {
		
		return seguent++;
	}
	

}
