package educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time, 
 * insert a given interval at the correct position and merge all necessary 
 * intervals to produce a list that has only mutually exclusive intervals.
 * 
 * Example 1: 
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * 
 * Example 2: 
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 * 
 * @author bk
 *
 */
public class InsertInterval {

	public static List<Interval> insert(List<Interval> inputList, Interval newInterval){
		List<Interval> outputList = new ArrayList<Interval>();

		// Insert new interval at the end of input list
		inputList.add(newInterval);

		// Sort and merge input list since new interval has been added 
		// and needs rearrangements
		Collections.sort(inputList, (a,b) -> Integer.compare(a.start, b.start));

		merge(inputList, outputList);

		return outputList;
	}

	public static void merge(List<Interval> inputList, List<Interval> outputList) {
		Iterator<Interval> itr = inputList.iterator();
		Interval interval = itr.next();
		int start = interval.start;
		int end = interval.end;

		while(itr.hasNext()) {
			interval = itr.next();
			if(interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				outputList.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		// add last interval
		outputList.add(new Interval(start, end));
	}
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		// Inserting to empty list
		input = new ArrayList<Interval>();
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}
}
