package Array_exercise;

import java.util.Scanner;
public class DiagonalSum {

	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		/*
		System.out.println("enter row:");
		int row=sc.nextInt();
		
		System.out.println("enter col:");
		int col=sc.nextInt();
		*/
		int[][] arr=new int[6][6];
		int sum=0;
		
           for(int i=0;i<=5;i++) {
			
			for(int j=0;j<=5;j++) {
				
				arr[i][j]=i*j;
					
	
				}	
			}
		
		for(int i=0;i<=5;i++) {
			
			for(int j=0;j<=5;j++) {
				
				if(i==j) {
					
					sum=sum+(arr[i][j]);
				}	
			}
		}
		System.out.println("sum is:"+sum);
		
		
	}
}
