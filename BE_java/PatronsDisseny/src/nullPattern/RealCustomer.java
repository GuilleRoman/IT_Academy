package nullPattern;

public class RealCustomer extends AbstractCustomer{

	
	public RealCustomer(String nom) {
		this.name = nom;
	}

	
	@Override
	public Boolean nil() {
		return false;
	}

	
	@Override
	public String getName() {
		return name;
	}
	
	
}
