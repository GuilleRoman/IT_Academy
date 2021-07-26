package tamagotchi;

import java.util.Timer;
import java.util.TimerTask;

public class Dormint implements State {
	private Tamagotchi tamagotchi;
	
	@Override
	public void jugar() {
		System.out.println("Estic dormint ...zzzZZZZZZ !!!!!!");	
	}

	@Override
	public void alimentar() {
		System.out.println("Estic dormint ...zzzZZZZZZ !!!!!!");		
	}

	@Override
	public void dormir() {
		
	}

	@Override
	public void comEstas() {
		System.out.println("Estic dormint ...zzzZZZZZZ !!!!!!");
		
	}

	@Override
	public void setTamagotchi(Tamagotchi tamagotchi) {
		this.tamagotchi = tamagotchi;
		
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run() {
		        Dormint.this.tamagotchi.setState(new Famelic()); 
		    }
		}, 10000);
		
		
	}

	
}
