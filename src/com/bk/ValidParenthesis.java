package com.bk;

import java.util.Stack;

/***
 * Leetcode - https://leetcode.com/problems/valid-parentheses/
 * 
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ValidParenthesis {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	if(c1 == '(' || c1 == '{' || c1 == '[') 
        	{
        		stack.push(c1);
        	} 
        	// if closing parenthesis is first char in string
        	else if (stack.isEmpty()) 
        	{
        	
        		return false;
        	} 
        	else 
        	{
        		char c2 = stack.pop();
        		if(!((c2 == '(' && c1 == ')') ||
        				(c2 == '{' && c1 == '}') ||
        				(c2 == '[' && c1 == ']')))
        		{
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "()[]{}";
		String s3 = "(]";
		String s4 = "([)]";
		String s5 = "{[]}";
		String s6 = "]";
		
		ValidParenthesis validParenthesis = new ValidParenthesis();
		System.out.println("Expected true found --> " + validParenthesis.isValid(s1));
		System.out.println("Expected true found --> " + validParenthesis.isValid(s2));
		System.out.println("Expected false found --> " + validParenthesis.isValid(s3));
		System.out.println("Expected false found --> " + validParenthesis.isValid(s4));
		System.out.println("Expected true found --> " + validParenthesis.isValid(s5));
		System.out.println("Expected false found --> " + validParenthesis.isValid(s6));
	}

}
