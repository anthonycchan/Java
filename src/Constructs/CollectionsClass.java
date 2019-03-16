package Constructs;

import java.util.*;

public class CollectionsClass {

	public CollectionsClass() {
		// TODO Auto-generated constructor stub
	}

	public void listTest() {
		System.out.println("List");
		
		// The abstract class List is parent class of LinkedList
		List<String> lt1 = new LinkedList<String>();
		lt1.add("cat");
		lt1.add("Dog");
		System.out.println("\t" + lt1);
		
		// The abstract class List is parent class of ArrayList
		List<String> lt2 = new ArrayList<String>();
		lt2.add("Cat");
		lt2.add("Dog");
		System.out.println("\t" + lt2);
		
		// parent class of List
		Collection<String> cl1 = lt1;
		System.out.println("\t" + cl1);
		
		System.out.print("\tBackwards iterator: ");
		ListIterator<String> lt2Iter = lt1.listIterator(lt1.size());
		while ( lt2Iter.hasPrevious() )
			System.out.print(lt2Iter.previous() + " ");
		
		System.out.print("\n\tForward iterator: ");
		ListIterator<String> lt1Iter = lt1.listIterator();
		while ( lt1Iter.hasNext() )
			System.out.print(lt1Iter.next() + " ");
		System.out.print("\n");
	}
	
	public void setTest() {
		System.out.println("Set");
		System.out.print("\t");
		
		int sampelInts[] = { 30, 50, 20, 10, 60 };
		
		Set<Integer> sampleIntsSet= new HashSet<Integer>();
		for ( int x : sampelInts ) {
			sampleIntsSet.add(x);
		}
		
		TreeSet<Integer> sortedSet = new TreeSet<Integer>(sampleIntsSet);
		System.out.println(sortedSet + " first=" + sortedSet.first() + " last=" + sortedSet.last() );
	}
	
	public void mapTest() {
		System.out.println("Map");
		
		//
		// HashMap
		//
		Map<Integer, String> mp1 = new HashMap<Integer, String>();
		mp1.put(1,  "anthony");
		mp1.put(2, "cat");
		mp1.put(3, "dog");
		
		System.out.println("\t" + mp1);
		
		Set<Map.Entry<Integer, String>> st1 = mp1.entrySet();
		System.out.println("\t" + st1);
		
		Iterator<Map.Entry<Integer, String>> mapIter = st1.iterator();
		while ( mapIter.hasNext() ) {
			Map.Entry<Integer, String> mapElem = mapIter.next();
			System.out.println("\t" + mapElem.getKey() + ":=" + mapElem.getValue() + " " + mapElem.hashCode());
		}

		//
		// Sorted Map
		//
		TreeMap<String, Double> physicalConst = new TreeMap<String, Double>();
		physicalConst.put("acceleration", 9.8);
		physicalConst.put("pi",  3.14);
		physicalConst.put("g", 6.674 );
		System.out.println("\t" + physicalConst);
		
		SortedMap<String, Double> sm = physicalConst;
		System.out.println("\t" + sm);
	}
	
	public void collectionAlgoTest() {
		System.out.println("Collections algorithms");
		LinkedList<Integer> llInt = new LinkedList<Integer>();
		llInt.add(2);
		llInt.add(1);
		llInt.add(3);
		llInt.add(5);
		
		Collections.sort(llInt);
		System.out.println("\t" + llInt);
		
		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(llInt, r);
		System.out.println("\t" + llInt);
		
		System.out.println("\t" + Collections.binarySearch(llInt, new Integer(5), r));
	}
	
	public void comparatorTest() {
		System.out.println("Comparator");
		LinkedList<Dog> dog = new LinkedList<Dog>();
		
		dog.add(new Dog("labrador", 1));
		dog.add(new Dog("askal", 5));
		dog.add(new Dog("shitsu", 15));
		
		System.out.print("\tUnsorted: ");
		Iterator<Dog> dogIter = dog.iterator();
		while ( dogIter.hasNext() ) {
			Dog d1 = dogIter.next();
			System.out.print(d1.getDogName() + " - "+ d1.getDogAge() + ", ");
		}
		
		System.out.print("\n\tSorted: ");
		Collections.sort(dog, new Dog());
		Iterator<Dog> dogIter2 = dog.iterator();
		while ( dogIter2.hasNext() ) {
			Dog d1 = dogIter2.next();
			System.out.print(d1.getDogName() + " - "+ d1.getDogAge() + ", ");
		}
	}

	public void abstractCollectionTest() {
		AbsCollection absTest = new AbsCollection();
		absTest.add("dog");
		System.out.println("\t" + absTest);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsClass cl = new CollectionsClass();
		cl.listTest();
		cl.setTest();
		cl.mapTest();
		cl.abstractCollectionTest();
		cl.collectionAlgoTest();
		cl.comparatorTest();
	}
}

//
// AbstractCollection
//
class AbsCollection extends AbstractCollection<Object> {
	  List<Object> list = new ArrayList<Object>();

	  public boolean add(Object e) {

	    list.add(e);

	    return true;
	  }
	  public Iterator<Object> iterator() {
		  
	    return list.iterator();
	  }
	  public int size() {

	    System.out.println(list.size());

	    return 0;
	  }
	  public String toString() {
		  
		  return list.toString();
	  }
}

class Dog implements Comparator<Dog>, Comparable<Dog>
{
	private String name;
	private int age;
	
	Dog(){}
	Dog(String n, int a){
		name = n;
		age = a;
	}

	public String getDogName() {
		return name;
	}
	
	public int getDogAge() {
		return age;
	}
	
	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return o.age - age;
	}
	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o2.age - o1.age;
	}	
}