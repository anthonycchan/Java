package Constructs;

public class Generics<E, V> {

	E dataMember;
	V dataMember2;
	
	public Generics() {
		// TODO Auto-generated constructor stub
	}

	public void setDataMember(E value, V value2) {
		dataMember = value;
		dataMember2 = value2;
	}
	
	public E getDataMember() {
		return dataMember;
	}
	
	public V getDataMember2() {
		return dataMember2;
	}
	
	public <T> void printData(T data[])
	{
		for ( int i = 0; i < data.length; i++ ) {
			System.out.print(data[i]);
			if ( i < data.length -1 )
				System.out.print(", ");
		}
	}
	 
	public static <T extends Comparable<T>> T maximum(T data1, T data2, T data3) {
		T max = data1;
		
		if ( data2.compareTo(max) > 0 ) {
			max = data2;
		}
			
		if ( data3.compareTo(max) > 0 ) {
			max = data3;
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		Generics<Integer, String> g1 = new Generics<Integer, String>();
		
		Integer intArray[] = {1, 2, 3, 4, 5};
		System.out.print("Print integer array: ");
		g1.printData(intArray);
		
		String strArray[] = {"cat", "dog", "cow"};
		System.out.print("\nPrint string array: ");
		g1.printData(strArray);
		
		System.out.println("\nCompare: " + Generics.maximum(1, 5, 2));
		
		g1.setDataMember(1, "anthony");
		System.out.println(g1.getDataMember() + " " +  g1.getDataMember2() );
	}
}
