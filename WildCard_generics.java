package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCard_generics {

    public static void main(String args[]) {
    	
    	List<?> li=new ArrayList<>();    // wildcard bounding
    //  li.add(1);
    	
    	
        List<? extends Number> list = new ArrayList<>();  // wildcard with upper bounding
 //     list.add(10);

        
  //     list.add(3); // This is also fine
        
        List<? super Number>slist=new ArrayList<>();   // wildcard with lower bounding
        slist.add(10);
        slist.add(10.5);
        slist.add(5.9f);
     // slist.add("sourabh");
        
        for(Object j:slist) {            // read as object not a Number
        	System.out.println(j);
        }
        
    }
}