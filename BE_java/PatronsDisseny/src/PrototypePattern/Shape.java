package PrototypePattern;

public abstract class Shape implements Cloneable {

	private String id;
	protected String type;
	
	// mètode abstracte
	abstract void draw();

	
	// cloneable implementation
	public Object clone() {
		Object clone =null;
						
		try {
			clone = super.clone();
		}catch(CloneNotSupportedException cnse) {
			
		}
		
		return clone;
	}
	
	
	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	
	
}
