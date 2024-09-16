package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_ArrayDeque {


	
	public static void main(String args[]) {
		
		Deque<Integer> que=new ArrayDeque<>();
		
		
		que.add(10);
		que.add(20);
		que.add(30);
		que.add(40);
		que.add(100);
		que.add(50);
			
		System.out.println(que.peek());
		System.out.println(que.poll());
		
       for(Integer q:que) {
			
			System.out.print(q+" ");
	    }
        System.out.println(); 
		System.out.println(que.peekFirst());
		System.out.println(que.peekLast());
		
       for(Integer q:que) {
			
			System.out.print(q+" ");
	    }
      
		que.remove();
		System.out.println();
		for(Integer q:que) {
			System.out.print(q+" ");
		}
		
		System.out.println("first element deleted: "+que.remove());
		for(Integer q:que) {
			System.out.print(q+" ");
		}
		System.out.println();
		
		
		System.out.println("peek element is:"+que.peek());
		System.out.println("first element deleted: "+que.remove());
		for(Integer q:que) {
			System.out.print(q+" ");
		}
		System.out.println();
		System.out.println("peek element is:"+que.peek());
		
		System.out.println("poll is:"+que.poll());
		
		for(Integer q:que) {
			
			System.out.print(q+" ");			
		}
		
	}
}
