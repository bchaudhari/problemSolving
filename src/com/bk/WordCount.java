package com.bk;

/**
 * Count occurrences of given word in given sentence. 
 * 
 * Example:
 * input:
 * String - "Google has doodle for every day, google doodles are awesome. Go GooGle!"
 * Word - "google"
 * 
 * Output - 3 
 * Case insensitive match
 * 
 * @author bk
 *
 */
public class WordCount {
	
	public int countWords(String str, String word) {
		str = str.toLowerCase();
		word = word.toLowerCase();
		int counter = 0;
		int n = word.length();
		
		int start = 0;
		while(start <= str.length() - n - 1) {
			str = str.substring(start);
			if(str.indexOf(word) != -1) {
				counter++;
				start = str.indexOf(word) + n;
			} else {
				break;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		System.out.println(wc.countWords("Google has doodle for every day, "
				+ "google doodles are awesome. Go GooGle!", "google")); // Expected 3
		
		System.out.println(wc.countWords("Google has doodle for every day, "
				+ "google doodles are awesome. Go GooGle!", "bhavesh")); // Expected 0
		
	}

}
