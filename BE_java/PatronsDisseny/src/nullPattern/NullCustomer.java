package nullPattern;

public class NullCustomer extends AbstractCustomer{
	
	@Override
	public Boolean nil() {		
		return true;
	}

	@Override
	public String getName() {
		return "Not available in Customer Database.";
	}
	

}
