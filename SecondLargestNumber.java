package Array_exercise;

public class SecondLargestNumber {

	
	public static  void sortArray(int arr[]) {
		 
		
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=1;j<arr.length;j++) {
				
				
				if(arr[j]<arr[j-1]) {            
					
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
					
				}
			
			}
			
		}
	
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			
			
		}
		
	}

	public static  void FindSecondLargest(int arr[]) {
		System.out.println();
		System.out.println("second largest element is:");
		System.out.print(arr[arr.length-1-1]);
		
    
	}
	
	
	public static void main(String args[]) {
		
		int arr[]= {4,3,6,7,63,56,2};
		System.out.println("before Sort:");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			
			
		}
		System.out.println();
		System.out.println(" After sort");
		
		sortArray(arr);
		FindSecondLargest(arr);
		
	}
	
}
