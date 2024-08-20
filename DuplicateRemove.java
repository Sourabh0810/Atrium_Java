
// for sorted Array
package Array_exercise;

public class DuplicateRemove {

	public static void main(String args[]) {
		
		
		int arr[]= {3,4,5,5,7,8,9,9};
		int len=arr.length;
	    System.out.println(len);
	  
	  int j=0;
	   int temp[]=new int[arr.length-1-1];
	   
	   for(int i=0;i<arr.length-1;i++) {
		   
		   if(arr[i]!=arr[i+1]) {
			   
			   temp[j]=arr[i];
			   j++;
			   
		   }
	   }
	 
	   temp[j]=arr[arr.length-1];
	   
	   for(j=0;j<temp.length;j++) {
		   System.out.print(temp[j]+",");
	   }
	   
		
	}
	
}
