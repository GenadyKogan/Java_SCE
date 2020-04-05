import java.util.*;
public class MainClass {
		
	
//	// Pushing element on the top of the stack 
//    static void stack_push(Stack<Integer> stack) 
//    { 
//        for(int i = 0; i < 5; i++) 
//        { 
//            stack.push(i); 
//        } 
//    } 
//      
//    // Popping element from the top of the stack 
//    static void stack_pop(Stack<Integer> stack) 
//    { 
//        System.out.println("Pop :"); 
//  
//        for(int i = 0; i < 5; i++) 
//        { 
//            Integer y = (Integer) stack.pop(); 
//            System.out.println(y); 
//        } 
//    } 
//    // Displaying element on the top of the stack 
//    static void stack_peek(Stack<Integer> stack) 
//    { 
//        Integer element = (Integer) stack.peek(); 
//        System.out.println("Element on stack top : " + element); 
//    } 
//      
//    // Searching element in the stack 
//    static void stack_search(Stack<Integer> stack, int element) 
//    { 
//        Integer pos = (Integer) stack.search(element); 
//  
//        if(pos == -1) 
//            System.out.println("Element not found"); 
//        else
//            System.out.println("Element is found at position " + pos); 
//    } 
	private static Stack<Integer> getReverseStack(Stack<Integer> stack2){
		Stack<Integer> stack1 = new Stack<>();
		while(!stack2.isEmpty())
			stack1.push(stack2.pop());
		return stack1;
	}
	private static Stack<Integer> getEvenStack(Stack<Integer> stak2) {
		Stack<Integer> stack1 = new Stack<>();
		while(!stak2.isEmpty()) {
			int val=stak2.pop();
			if (val%2==0)
				stack1.push(val);
		}
		return stack1;
	}
	private static Stack<Integer> getMaxStack(Stack<Integer> s2) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack1 = new Stack<>();

	    int max=0;
	    stack.addAll(s2);
	    stack=getReverseStack(stack);
	     while(!s2.isEmpty())
		{
	    	int val=s2.pop();
			if (val>=max) 
				max=val;
		}
	     stack1.push(max);
	     while(!stack.isEmpty())
		{
	    	int val=stack.pop();
			if(val!=max)
				stack1.push(val);
		}	    
    	return stack1;
	}
	public static void main(String[] args) {
		Stack <Integer> stack=new Stack<>();
		Stack1 s1=new Stack1();
		s1.push(0);
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(6);
		s1.toString();
		System.out.println(s1.toString());
		System.out.println(s1.isEmpty());
		s1.pop();
		System.out.println(s1.toString());
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack=getReverseStack(stack);
		System.out.println(stack);
		stack=getEvenStack(stack);
		System.out.println(stack);
		stack.push(7);
		System.out.println(stack);
		
		System.out.println(getMaxStack(stack));
	}

}
