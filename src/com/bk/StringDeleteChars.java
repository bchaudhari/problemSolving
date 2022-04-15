package com.bk;

/**
 * https://algodaily.com/challenge_slides/dollar-sign-deletion (medium)
 * 
 * You're given an array of strings containing alphabetical characters and certain $ characters. 
 * A $ represents a DELETE action whereby the character before it is deleted.
 * Each of these strings will be run through a method to operate on the $ DELETE action. 
 * We want to find out if the final string is the same for all of them. 
 * 
 * Example - 1
 * input = ["f$st", "st"]
 * output = true
 * Explanation: 
 * "f$st" --> ignore f before $ since $ works as delete button press. So resulting string would be "st" which is same as second string.
 * Since both are equal, return true
 * 
 * Example - 2
 * input = ["a90$n$c$se", "a90n$cse"]
 * output = false
 * 
 * Exlanation:
 * "a90$n$c$se" --> "a9se"
 * "a90n$cse" --> "a90cse"
 * Since both are not, equal return false
 * 
 * 
 * O(n*m) 
 * where 
 * 		n = size of input array
 * 		m = size of longest string in input array
 * 
 * 
 * @author bk
 *
 */

public class StringDeleteChars {
	
	public boolean isDollarDeleteEqual(String[] arr) {

		String firstProcessedString = "";
		for(int i = 0; i < arr.length; i++){
			StringBuilder sb = new StringBuilder();
			String str = arr[i];
			int skipCount = 0;
			int j = str.length()-1;
			
			// Read string in reverse order
			while(j >= 0){
				
				// Detect number of $ coming consecutively and ignore that many chars from string
				if(str.charAt(j) == '$') {
					while(j >= 0 && str.charAt(j) == '$'){
						skipCount++;
						j--;
					}

					while(skipCount > 0){
						j--;
						skipCount--;
					}
				}
				
				// add other normal chars to string builder
				else if(j >= 0){
					sb.append(str.charAt(j));
					j--;
				}
			}

			String udpatedString = sb.toString();
			
			// store first processed string for comparison 
			if(i == 0){
				firstProcessedString = udpatedString;
			}
			
			// if any match not found stop processing further array elements to save time
			if(!udpatedString.equals(firstProcessedString))
				return false;
		}
		
		// since code reached this point all the string in input array are equal after deletion process
		return true;
	}

	public static void main(String[] args) {
		StringDeleteChars stringDeleteChars = new StringDeleteChars();
		System.out.println(stringDeleteChars.isDollarDeleteEqual(new String[] {"f$ec", "ec"})); // true
		System.out.println(stringDeleteChars.isDollarDeleteEqual(new String[] {"a90$n$c$se", "a90n$cse"})); // false
		System.out.println(stringDeleteChars.isDollarDeleteEqual(new String[] {"ab$$", "c$d$"})); // true
		System.out.println(stringDeleteChars.isDollarDeleteEqual(new String[] {"b$$p", "$b$p"})); // true

	}

}
