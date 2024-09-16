package collection;

import java.util.Deque;
import java.util.LinkedList;


public class Queue_LinkedList {

	public static void main(String args[]) {
		Deque<Integer>que2=new LinkedList<>();
	  
	    
		que2.add(10);
		que2.add(30);
		que2.push(40);
		que2.push(50);
		que2.add(100);      // add in queue
		que2.push(200);    // add to first position
		        
		for(Integer q:que2) {
			System.out.print(q+" ");
		}
		que2.pop();
		for(Integer q:que2) {
			System.out.print(q+" ");
		}
		
		System.out.println("peek is:"+que2.peek());
		System.out.println("peek first:"+que2.peekFirst());
		System.out.println("peeklast:"+que2.peekLast());
		System.out.println("poll:"+que2.poll());
		System.out.println("pollfirst:"+que2.pollFirst());
		System.out.println("polllast :"+que2.pollLast());
	}
}
