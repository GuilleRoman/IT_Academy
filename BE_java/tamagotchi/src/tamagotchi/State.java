package tamagotchi;

public interface State {

	void jugar();
	void alimentar();
	void dormir();
	void comEstas();
	
	void setTamagotchi(Tamagotchi tamagotchi);
}