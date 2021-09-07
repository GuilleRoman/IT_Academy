package v2_Optional;

public class Descripcio {

	private final Integer value;
	
	public Descripcio(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "V("+value+")";
	}
	
	
	
}
