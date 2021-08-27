package Sencers;

import java.util.Random;

public class Aleatori implements Proveidor{

	@Override
	public Integer obtenir() {
		Random aleatori = new Random();
		return aleatori.nextInt(1000);
	}
}
