package generics;

public class Bounded_Generics<T extends Number> {

	private T age;
	private T name;
	private T salery;
	
	public Bounded_Generics(T age) {
		this.age=age;
		
	}
	
	public T getage() {
		return age;
	}
	public T getname() {
		return name;
	}
	public T getsalery() {
		return salery;
	}
	
	public static void main(String args[]) {
		
		Bounded_Generics<Integer> Bgobj=new Bounded_Generics<Integer>(24);
		
		Bounded_Generics<Double> Dobj=new Bounded_Generics<>(5.5);
		
		Bounded_Generics<Float> Fobj=new Bounded_Generics<>(6.5f);
		// Bounded_Generics<String>Sobj=new Bounded_Generics<>("sourabh");  T extends only Number class 
		
		
	}
}
