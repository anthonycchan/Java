package Constructs;

import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.BitSet;
import java.util.Stack;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Properties;
import java.util.Iterator;

public class DataStructures {

	public DataStructures() {
		// TODO Auto-generated constructor stub
	}
	
	public void enumerationTester() {
		Enumeration<?> days;
		
		Vector<String> dayNames = new Vector<String>();
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		
		days = dayNames.elements();
		
		System.out.println("Enumeration");
		while(days.hasMoreElements()) {
			System.out.println( "\t" + days.nextElement());
		}
	}
	
	public void bitSetTester() {
		BitSet bset1 = new BitSet();
		BitSet bset2 = new BitSet(16);
		
		for ( int i = 0 ; i < 16; i++ ) {
			if ( i % 2 == 0 ) bset1.set(i);
			if ( i % 5 == 0 ) bset2.set(i);
		}
		
		System.out.println("Bitset");
		System.out.println( "\t" + bset1);
		System.out.println( "\t" + bset2);
		
		System.out.println("AND");
		bset1.and(bset2);
		System.out.println("\t" + bset1);
		
		System.out.println("OR");
		bset1.or(bset2);
		System.out.println("\t" + bset1.toString() );
	}
	
	public void vectorTester() {
		Vector<Integer> vt1 = new Vector<Integer>();
		
		vt1.addElement(new Integer(1));
		vt1.addElement(new Integer(2));
		
		System.out.println("Vector");
		System.out.println("\tcapacity:" + vt1.capacity() + " size: " + vt1.size() + " first:" + vt1.firstElement() + " last:" + vt1.lastElement());
		
		System.out.print("\tEnumerate:");
		Enumeration<Integer> vecEnum;
		vecEnum = vt1.elements();
		while ( vecEnum.hasMoreElements() )
			System.out.print(vecEnum.nextElement() + " ");
		System.out.println();
	}
	
	public void stackTest() {
		System.out.println("Stack");
		Stack<Integer> st1 = new Stack<Integer>();
		st1.push(new Integer(5) );
		st1.push(new Integer(6));
		System.out.println("\t" + st1);
		
		System.out.println("\t"+ st1.pop() + " "+ st1);
		
		if ( st1.search(new Integer(5)) != -1) {
			System.out.println("\tfound 5");
		}
		
		try {
			st1.pop();
			st1.pop();
		} catch (EmptyStackException ex) {
			System.out.println("\tempty stack");
		}
	}
	
	public void hashMapTest() {
		HashMap<String, Integer> hm1 = new HashMap<>();
		hm1.put("Dog", 15);
		hm1.put(new String("Cat"), new Integer(20));
		
		System.out.println("HashMap");
		System.out.println("\t" + hm1);
		System.out.println("\tCat = " + hm1.get("Cat") );
		
		// Duplicate key (overwrites the original value)
		hm1.put("Dog", 20);
		System.out.println("\t" + hm1);
	}
	
	public void hashTableTest() {
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put("Dog", 15);
		ht.put(new String("Cat"), new Integer(20));
		
		System.out.println("Hashtable");
		
		Enumeration<String> petsSpecies= ht.keys();
		while ( petsSpecies.hasMoreElements() ) {
			String nameStr = (String) petsSpecies.nextElement();
			System.out.println("\t" + nameStr + " = " + ht.get(nameStr));
		}
		
		Integer age = ht.get("Cat");
		ht.put("Cat", age + 1);
		System.out.println("\t" + ht);
		
		Integer testGet = ht.get("giraff");
		if ( testGet == null )
			System.out.println("\t" + testGet);
	}
	
	public void propertyTest() {
		Properties animalAge = new Properties();
		animalAge.put("Cat", "Fifteen");
		animalAge.put("Dog", "Twenty");
		
		System.out.println("Properties");
		
		Set<Object> animalName = animalAge.keySet();
		Iterator<Object> iter = animalName.iterator();
		while (iter.hasNext()) {
			String name = (String)iter.next();
			System.out.println("\t" + name + " = " + animalAge.getProperty(name));
		}
		
		System.out.println("\tGiraff = " + animalAge.getProperty("Giraff", "unknown"));
	}
	
	public static void main(String args[]) {
		DataStructures ds = new DataStructures();
		
		ds.enumerationTester();
		ds.bitSetTester();
		ds.vectorTester();
		ds.stackTest();
		ds.hashMapTest();
		ds.hashTableTest();
		ds.propertyTest();
	}
}
