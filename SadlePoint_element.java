package Array_exercise;

import java.util.Scanner;

public class SadlePointElement {

	public static void main(String args[]) {
		
     Scanner sc=new Scanner(System.in);
     
     System.out.println("enter row:");
     int row=sc.nextInt();
     
     System.out.println("enter col:");
     int col=sc.nextInt();
		
     
     int arr[][]=new int[row][col];
     
     for(int i=0;i<row;i++) {
    	 
    	 for(int j=0;j<col;j++) {
    		 
    		 arr[i][j]=sc.nextInt();
    		 
    	 }
     }
     System.out.println("your entered array:");
     for(int i=0;i<row;i++) {
    	 
    	 for(int j=0;j<col;j++) {
    		 
    		 System.out.print(arr[i][j]+" ");
    		 
    	 }
    	 System.out.println();
     }
     boolean flag=true;
     boolean found=true;
     // to find out smallest element in first row
     for(int i=0;i<row;i++) {
    	 
    	int minvalue=arr[i][0];
    	
    	int mincolindex=0;
    	
    	for(int j=0;j<col;j++) {
    		
    		if(arr[i][j]<minvalue) {
    			minvalue=arr[i][j];
    			mincolindex=j;
    		}
    		
    	}
    	boolean issaddlepoint=true;
		
    	//now in the same col check if it is max
		for(int k=0;k<row;k++) {
			if(arr[k][mincolindex]>minvalue) {
				issaddlepoint=false;
				break;
			}
		}
		
		if(issaddlepoint) {
			System.out.println("saddle point found at index:"+i+","+mincolindex+" value"+" "+minvalue);
			found=true;
		}	
	}
	
	
	if(found == false) {
		System.out.println("no saddle point in the matrix");
	}
  }
}
