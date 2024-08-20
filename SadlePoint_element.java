package Array_exercise;

import java.util.Scanner;

public class SadlePoint_element {

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
     
     // to find out smallest element in first row
     for(int i=0;i<row;i++) {
    	 
    	int min=arr[i][0];
    	for(int j=0;j<col;j++) {
    		if(min>arr[i][j]) {
    			min=arr[i][j];
    		}
    	}
    	 System.out.println(min); 	
     }	
	}
}