package Array_exercise;

public class LeaderNumber {

	public static void main(String args[]) {
		
		int arr[]= {4,1,2,5,4,6,7,5,2};
		
		int rightmost=arr[arr.length-1];
		
		System.out.print(rightmost+",");
		
		
		for(int i=arr.length-2;i>=0;i--) {
			
			if(arr[i]>rightmost) {
				rightmost=arr[i];
				System.out.print(rightmost+",");
			}
			
		}
		
		
		
	}
}
