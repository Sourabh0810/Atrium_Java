package mypack;

public class KaparekarNumber {

	public static void main(String args[]) {
		
      int num=297;
	  int temp=num;
//		int rem=0;
//		int sum=0;
        int square=0;
//		boolean iskap=false;
        
		square=temp*temp;
		
		String len=Integer.toString(square);
		
		int length=len.length();
		System.out.println(length);
		boolean flag=false;
		for(int i=1;i<length;i++) {
			
			int div=(int)Math.pow(10, i);
			
			int rightpart=square%div;
			
			int leftpart=square/div;
			
			if((leftpart+rightpart)==num) {
				
				flag=true;
				System.out.println("given number is kaprekar number");
			}
			if(leftpart==0||rightpart==0) {
				break;
			}
			
		}
		if(flag==false) {
			System.out.println("given number is not a kaprekar");
		}
		
		
		
		
			
		}
		
	}
	
