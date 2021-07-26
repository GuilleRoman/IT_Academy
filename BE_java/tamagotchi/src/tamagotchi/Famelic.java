package tamagotchi;

public class Famelic implements State {
	
	private Tamagotchi tamagotchi;
	
	@Override
	public void jugar() {
		System.out.println("No vull jugar .....");
		
	}

	@Override
	public void alimentar() {
		System.out.println("NYAM NYAM NYAM ....");
		tamagotchi.setState(new Aborrit());
	}

	@Override
	public void dormir() {
		System.out.println("no vull dormir ....");
		
	}

	@Override
	public void comEstas() {
		System.out.println("Estic famèlic ugrrrssss!!!!");
		
	}

	@Override
	public void setTamagotchi(Tamagotchi tamagotchi) {
		this.tamagotchi = tamagotchi;
		
	}

}
