package com.bk;

import java.util.Stack;

public class CountParenthesis {

	public int countParenthesisPairs(String str)
	{
		if(str == null || str.length() < 2)
			return 0;

		int pairCount = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++)
		{
			char c1 = str.charAt(i);
			if(c1 == '(' || c1 == '{' || c1 == '[')
					{
				stack.push(c1);
					}  
			else if(c1 == ')' || c1 == '}' || c1 == ']')
			{
				char c2 = stack.pop();
				if((c1 == ')' && c2 == '(') || (c1 == '}' && c2 == '{') || (c1 == ']' && c2 == '['))
				{
					pairCount++;
				}                    
			}
		}
		return pairCount;
	}
	public static void main(String[] args) {
		CountParenthesis countParenthesis = new CountParenthesis();
		System.out.println(countParenthesis.countParenthesisPairs("(({[]}))"));
		System.out.println(countParenthesis.countParenthesisPairs("("));
		System.out.println(countParenthesis.countParenthesisPairs("(){]"));
		System.out.println(countParenthesis.countParenthesisPairs("")); 
		System.out.println(countParenthesis.countParenthesisPairs("(bhavesh){}["));
	}
}

