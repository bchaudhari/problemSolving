package com.bk;

import java.util.Stack;

/**
 * Leetcode - https://leetcode.com/problems/min-stack/submissions/
 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MinStack {
	private Stack<Node> stack;
	private int minValue = Integer.MAX_VALUE;
	/** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<Node>();
    }
    
    public void push(int x) {
       minValue = Math.min(x, minValue);
       stack.push(new Node(x, minValue));
    }
    
    public void pop() {
    	Node node = stack.pop();
        if(stack.isEmpty()){
        	minValue = Integer.MAX_VALUE;
        }
        else if( !stack.isEmpty() && node.data == minValue){
        	minValue = stack.peek().min;
        }
    }
    
    public int top() {
        return stack.peek().data;  
    }
    
    public int getMin() {
       return minValue;
    }
}

 class Node {
	 int data;
	 int min;
	 Node next;
	 
	 public Node(int data, int min) {
		 this.data = data;
		 this.min = min;
	 }
 }
