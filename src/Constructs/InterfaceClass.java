package Constructs;

public interface InterfaceClass {
	public void turnOn();
	public void turnOff();
}

class InterfaceDriver implements InterfaceClass{
	InterfaceDriver() {}
	
	public void turnOn() {
		System.out.println("turning on");
	}
	
	public void turnOff() {
		System.out.println("turning off");
	}
	
	public static void main(String args[]){
		InterfaceDriver id = new InterfaceDriver();
		id.turnOn();
		id.turnOff();
	}
}