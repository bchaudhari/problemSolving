package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/long-pressed-name/
 * 
  Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Constraints:

1 <= name.length <= 1000
1 <= typed.length <= 1000
The characters of name and typed are lowercase letters.

 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		int namePointer = 0;
		int typedPointer = 0;
		char prevName = '#';
		char prevTyped = '#';
		char currName;
		char currTyped;

		while(namePointer < name.length()) {
			currName = name.charAt(namePointer);
			if(currName != prevName) {
				while(typedPointer < typed.length() && typed.charAt(typedPointer) == prevTyped) {
					typedPointer++;
				}
			}
			if(typedPointer < typed.length()) {
				currTyped = typed.charAt(typedPointer);
				if(currName != currTyped) {
					return false;
				}
			} else {
				return false;
			}
			
			prevName = currName;
			prevTyped = currTyped;
			namePointer++;
			typedPointer++;
		}
		
		while(typedPointer < typed.length()) {
			if(typed.charAt(typedPointer) != name.charAt(name.length()-1)) {
				return false;
			}
			typedPointer++;
		}
		return true;
	}
	public static void main(String[] args) {
		LongPressedName longPressedName = new LongPressedName();
		System.out.println(longPressedName.isLongPressedName("aariv", "aaarrrriv"));
		System.out.println(longPressedName.isLongPressedName("bunny", "buuuuny"));
		System.out.println(longPressedName.isLongPressedName("bhavesh", "bhavesh"));
		System.out.println(longPressedName.isLongPressedName("namita", "nnnaamiii"));
		System.out.println(longPressedName.isLongPressedName("a", "b"));
		System.out.println(longPressedName.isLongPressedName("a", "aaaaaab"));

	}

}
