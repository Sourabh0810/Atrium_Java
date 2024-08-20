package Array_exercise;

public class OuterElements {

	
	public static void main(String args[]) {
		
		int arr[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
				
		int newArr[][]=new int [4][4];
		
		
		for(int i=0;i<4;i++) {
			
			newArr[0][i]=arr[0][i];
			System.out.print(arr[0][i]+",");
		}
         for(int i=1;i<4;i++) {
			
        	 newArr[i][0]=arr[i][0];
			System.out.print(arr[i][0]+",");
		}
         
        for(int i=1;i<4;i++) {
 			
        	 newArr[3][i]=arr[3][i];
 		   System.out.print(arr[3][i]+",");
 		}
        for(int i=1;i<3;i++) {
 			
        	newArr[i][3]=arr[i][3];
  		   System.out.print(arr[i][3]+",");
  		}
		
        System.out.println();
        for(int i=0;i<arr.length;i++) {
        	for(int j=0;j<arr.length;j++) {
        		  System.out.print(newArr[i][j]+",");
        		
        	}
        	System.out.println();
        }
        
	}
}
