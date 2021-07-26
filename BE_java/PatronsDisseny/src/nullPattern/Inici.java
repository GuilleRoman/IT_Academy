package nullPattern;

public class Inici {
	public static void main (String[] args) {
		
		  AbstractCustomer customer1 = CustomerFactory.getCustomer("Laia");
	      AbstractCustomer customer2 = CustomerFactory.getCustomer("Meritxell");
	      AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
	      AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

	      System.out.println("Customers :");
	      System.out.println(customer1.getName());
	      System.out.println(customer2.getName());
	      System.out.println(customer3.getName());
	      System.out.println(customer4.getName());
		
	}
}
