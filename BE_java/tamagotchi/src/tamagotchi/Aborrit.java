package tamagotchi;

public class Aborrit implements State{
	
	private Tamagotchi tamagotchi;
	
	@Override
	public void jugar() {
		System.out.println("Yaaa!  jugem ....");
		tamagotchi.setState(new Cansat());
	}

	@Override
	public void alimentar() {		
		System.out.println("No quiero comer");
	}

	@Override
	public void dormir() {
		System.out.println("no quiero dormir");
	}

	@Override
	public void comEstas() {		
		System.out.println("Estic aborrit ... vull jugar");
	}

	@Override
	public void setTamagotchi(Tamagotchi tamagotchi) {
		this.tamagotchi = tamagotchi;		
	}


}
