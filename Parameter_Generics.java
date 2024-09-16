// parameterized generics
package generics;

public class Parameter_Generics<T,U> {

	private T first;
	private U second;
	
	
	public  Parameter_Generics(T first,U second) {
		this.first=first;
		this.second=second;
	}
	public T getfirst() {
		return first;
	}
	public U getsecond() {
		return second;
	}
	
	
	public static void main(String args[])
	{
		
		Parameter_Generics<Integer,Integer> Iobj=new Parameter_Generics<Integer,Integer>(10,15);
		Parameter_Generics<Double,Double> Dobj=new Parameter_Generics<Double,Double>(8.5,6.5);
		Parameter_Generics<Integer,Float>IFobj=new Parameter_Generics<Integer,Float>(10,5.5f);
		Parameter_Generics<String,Float>SFobj=new Parameter_Generics<String,Float>("sourabh",10.5f);
	
		System.out.println("first is:"+Iobj.getfirst());
		System.out.println("second is"+Iobj.getsecond());
		
		System.out.println("first is:"+Dobj.getfirst());
		System.out.println("second is"+Dobj.getsecond());
		
		System.out.println("first is:"+IFobj.getfirst());
		System.out.println("second is"+IFobj.getsecond());
		
		System.out.println("first is:"+SFobj.getfirst());
		System.out.println("second is"+SFobj.getsecond());
		
		
	}
}
