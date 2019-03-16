package Constructs;

abstract class AnonymousInner {
	public abstract void print();
}

class ConcreteClass {
	public void print() { System.out.println("\n---ConcreteClass---"); }
}

public class NestedClassOuter {

	private int m_privInteger = 100;
	
	public NestedClassOuter() {
		// TODO Auto-generated constructor stub
	}

	//
	// Inner class
	//
	public class NestedClassInner {
		public void print() { System.out.println("NestedClassInner"); }
		public int getPrivateInteger() { return  m_privInteger; }
	}
	
	public void testNestedClassInner() {
		NestedClassInner nci = new NestedClassInner();
		nci.print();
		nci.getPrivateInteger();
	}
	
	//
	// Method local inner class
	//
	public void methodLocalInnerClass() {
		class LocalClass {
			public void print() { System.out.println("\n---method local inner class---"); } 
		}
		
		LocalClass lc = new LocalClass();
		lc.print();
	}
	
	//
	// Anonymous inner class
	//
	public void testAnonymousInnerClass() {
		AnonymousInner inner = new AnonymousInner() {
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("\n---Override by anonymous inner class---");
			}
		};
		
		inner.print();
	}
	
	// 
	// Passing anonymous inner class by argument
	//
	public void passingAnonymousInnerClassAsArgument(AnonymousInner ai) {
		ai.print();
	}
	
	//
	// Overriding concrete class as method argument
	//
	public void passingConcreteClassAsArgument( ConcreteClass cc) {
		cc.print();
	}
	
	//
	// Static inner class
	//
	static class StaticNestedClass {
		void print() { System.out.println("\n---Static nested class---"); }
	}
	
	public static void main(String args[])
	{
		//
		// Inner class
		//
		System.out.println("---Inner Classes---");
		NestedClassOuter nc = new NestedClassOuter();
		nc.testNestedClassInner();
		
		NestedClassOuter outer = new NestedClassOuter();
		NestedClassOuter.NestedClassInner inner = outer.new NestedClassInner();
		inner.print();
		System.out.println( inner.getPrivateInteger() ); 
		
		//
		// Method local inner class
		//
		nc.methodLocalInnerClass();
		
		//
		// Anonymous inner class
		//
		nc.testAnonymousInnerClass();
		
		// 
		// Passing anonymous inner class by argument
		//
		nc.passingAnonymousInnerClassAsArgument(new AnonymousInner() {
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("\n---Passing anonymous inner class by argument---");
			}
		});
		
		//
		// Overriding concrete class as method argument
		//
		nc.passingConcreteClassAsArgument(new ConcreteClass());
		nc.passingConcreteClassAsArgument(new ConcreteClass() {
			public void print() { System.out.println("\tOverride concrete class print()"); }
		});
		
		//
		// Test static inner class
		//
		NestedClassOuter.StaticNestedClass staticNested = new NestedClassOuter.StaticNestedClass();
		staticNested.print();
	}
}
