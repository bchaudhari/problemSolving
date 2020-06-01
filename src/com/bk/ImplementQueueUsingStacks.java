package com.bk;

import java.util.Stack;

/**
 * Leetcode - https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println("Expected 1 found --> " + queue.pop());
		System.out.println("Expected 2 found --> " + queue.peek());
		System.out.println("Expected false found --> " + queue.empty());

	}

}

//Using one stack and recursion
class MyQueue {
	private Stack<Integer> stack;
 /** Initialize your data structure here. */
 public MyQueue() {
     stack = new Stack<Integer>();
 }
 
 /** Push element x to the back of queue. */
 public void push(int x) {
 	if(stack.isEmpty()) {
 		stack.push(x);
 	} else {
 		int temp = stack.pop();
 		this.push(x);
 		stack.push(temp);
 	}
 }
 
 /** Removes the element from in front of queue and returns that element. */
 public int pop() {
     return stack.pop();
 }
 
 /** Get the front element. */
 public int peek() {
     return stack.peek();
 }
 
 /** Returns whether the queue is empty. */
 public boolean empty() {
     return stack.isEmpty();
 }
}

// Using two stacks
class MyQueue1 {
	private Stack<Integer> stack;
	private Stack<Integer> tempStack;
    /** Initialize your data structure here. */
    public MyQueue1() {
        stack = new Stack<Integer>();
        tempStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(stack.isEmpty()) {
    		stack.push(x);
    	} else {
    		// remove elements from stack and put in tempStack
    		while(!stack.isEmpty()) {
    			tempStack.push(stack.pop());
    		}
    		
    		// add new element in empty stack now so it will be last 
    		stack.push(x);
    		
    		// add elements from tempStack to stack
    		while(!tempStack.isEmpty()) {
    			stack.push(tempStack.pop());
    		}
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
