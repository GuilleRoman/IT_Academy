package observer;

public class HexeObserver extends Observer {
	
	public HexeObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String : "+Integer.toHexString(subject.getState()));
	}
	
	
}
