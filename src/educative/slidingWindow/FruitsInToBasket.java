package educative.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of characters where each character represents a fruit tree, 
 * you are given two baskets, and your goal is to put maximum number of fruits in each basket. 
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but you can’t skip a tree once you have started. 
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you have 
 * to pick from a third fruit type. Write a function to return the maximum number of fruits in both baskets.
 * 
 * Example 1:
 * Input: Fruit=['A', 'B', 'C', 'A', 'C'] 
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * 
 * Example 2:
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] 
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 * 
 * Example 3:
 * Input: Fruit=['A', 'A', 'A', 'A', 'B', 'B', 'C', 'C', 'C', 'C','C','C','B','B','C'] 
 * Output: 11
 * Explanation: We can put 4 'A' in one basket and one 'B' in the other from the subarray 
 * ['B', 'B', 'C', 'C', 'C', 'C','C','C','B','B','C']
 * 
 * @author bk
 *
 */
public class FruitsInToBasket {
	public static int maxFruits(Character[] fruit) {
		int maxFruits = 0;
		int start = 0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int end = 0; end < fruit.length; end++) {
			hm.put(fruit[end], hm.getOrDefault(fruit[end], 0)+1);
			
			while(hm.size() > 2) {
				hm.put(fruit[start], hm.get(fruit[start])-1);
				if(hm.get(fruit[start]) <= 0) {
					hm.remove(fruit[start]);
				}
				start++;
			}
			maxFruits = Math.max(maxFruits, end - start + 1);
		}
		return maxFruits;
	}
	
	public static void main(String[] args) {
		Character[] fruit1 = {'A', 'B', 'C', 'A', 'C'};
		int out1 = maxFruits(fruit1);
		System.out.println(out1);
		
		Character[] fruit2 = {'A', 'B', 'C', 'B', 'B', 'C'};
		int out2 = maxFruits(fruit2);
		System.out.println(out2);
		
		Character[] fruit3 = {'A', 'A', 'A', 'A', 'B', 'B', 'C', 'C', 'C', 'C', 'C', 'C', 'B', 'B', 'C'};
		int out3 = maxFruits(fruit3);
		System.out.println(out3);

	}

}
