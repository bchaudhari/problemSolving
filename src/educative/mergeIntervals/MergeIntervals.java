package educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that 
 * has only mutually exclusive intervals.
 * 
 * Example 1: 
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 * 
 * Example 2: 
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 * 
 * Example 3: 
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 * 
 * @author bk
 *
 */
public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> input){
		if(input.size() < 2) {
			return input;
		}
		
		List<Interval> mergedList = new LinkedList<Interval>();
		
		// Sort input intervals by start value
		Collections.sort(input, (a, b) -> Integer.compare(a.start, b.start));
		
		Iterator<Interval> inputIterator = input.iterator();
		Interval interval = inputIterator.next();
		int start = interval.start;
		int end = interval.end;
		
		while(inputIterator.hasNext()) {
			interval = inputIterator.next();
			if(interval.start <= end) {
				end = Math.max(end, interval.end);
			}
			else {
				mergedList.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		// add the last interval
		mergedList.add(new Interval(start, end));
	    
		return mergedList;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 5));
	    input.add(new Interval(7, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(6, 7));
	    input.add(new Interval(2, 4));
	    input.add(new Interval(5, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 6));
	    input.add(new Interval(3, 5));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	}

}

class Interval{
	int start;
	int end;
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
