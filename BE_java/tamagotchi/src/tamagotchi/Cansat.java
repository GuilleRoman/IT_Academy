package tamagotchi;

public class Cansat implements State {
	private Tamagotchi tamagotchi;

	@Override
	public void jugar() {
		System.out.println("no vull jugar");		
	}

	@Override
	public void alimentar() {
		System.out.println("no vull menjar");
		
	}

	@Override
	public void dormir() {
		System.out.println("Bona nit uwu");
		tamagotchi.setState(new Dormint());
	}

	@Override
	public void comEstas() {
		System.out.println("Estic cansat");
		
	}

	@Override
	public void setTamagotchi(Tamagotchi tamagotchi) {
		this.tamagotchi = tamagotchi;
		
	}

}
