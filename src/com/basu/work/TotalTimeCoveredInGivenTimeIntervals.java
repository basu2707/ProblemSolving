package com.basu.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
Given a list of arrays of time intervals, write a function that calculates the total amount of time covered by the intervals. 
For example: 
input = [(1,4), (2,3)] 
return 3 
input = [(4,6), (1,2)] 
return 3 
input = {{1,4}, {6,8}, {2,4}, {7,9}, {10, 15}} 
return 11
input = {{ 3, 7 }, { 4, 5 }, {10, 20}, {8, 15}}


Good Explanation is at :   https://algorithmsandme.com/arrays-merge-overlapping-intervals/
 * @author sivakumar
 *
 */
public class TotalTimeCoveredInGivenTimeIntervals {

	public static void main(String[] args) {
		//int[][] segments = {{1,4},{2,3}};
		//int[][] segments = {{1,4}, {6,8}, {2,4}, {7,9}, {10, 15}};
		int[][] segments = {{3,7}, {4,5}, {10,20}, {8,15}};
		
		//System.out.println(mergeSegments(segments));
		
/*		List<Interval> intervals = Arrays.asList(new Interval(1, 5),
				new Interval(2, 3), new Interval(4, 6),
				new Interval(7, 8), new Interval(8, 10),
				new Interval(12, 15)
			);*/
		List<Interval> intervals = Arrays.asList(new Interval(1, 3),
				new Interval(2, 6), new Interval(8, 10),
				new Interval(15, 18));
		//mergeIntervals(intervals);
		System.out.println(mergeOverlappingIntervals(intervals));
	}
	
	public static int mergeSegments(int[][] segments) {
        Arrays.sort(segments, (x, y) -> x[0] - y[0]);

        int result = 0;
        int last = 0;
        for(int[] seg : segments) {
            result += Math.max(seg[1] - Math.max(last, seg[0]), 0);
            last = Math.max(last, seg[1]);
        }
        return result;
    }
	
	/**
	 * this will give the overlapping intervals
	 * 
		Input: [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
		
		Input: [[1,4],[4,5]]
		Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	 * 
	 * @param intervals
	 * @return
	 */
	// Function to merge overlapping intervals
		public static List<Interval> mergeIntervals(List<Interval> intervals)
		{
			// sort the intervals in increasing order of their starting time
			Collections.sort(intervals, (a, b) -> a.start - b.start);

			// create an empty stack
			Stack<Interval> stack = new Stack<Interval>();

			// do for each interval
			for (Interval curr: intervals)
			{
				// if stack is empty or top interval in stack do not overlap
				// with current interval, push it to the stack
				if (stack.empty() || curr.start > stack.peek().end) {
					stack.push(curr);
				}

				// if top interval of stack overlap with current interval,
				// merge two intervals by updating ending of top interval
				// to ending of current interval
				if (stack.peek().end < curr.end) {
					stack.peek().end = curr.end;
				}
			}

			List<Interval> overlapping = new ArrayList<>();
			// print all non-overlapping intervals
			while (!stack.empty()) {
				overlapping.add(stack.pop());
			}
			return overlapping;
		}
		
		/**
			time: O(n logn) 
			Space: O(n)
			Runtime: 42 ms, faster than 44.97% of Java online submissions for Merge Intervals.
			Memory Usage: 41.7 MB, less than 81.67% of Java online submissions for Merge Intervals.
		 * @param intervals
		 * @return
		 */
		private static List<Interval> mergeOverlappingIntervals(List<Interval> intervals) {
			if (intervals == null || intervals.size() <= 1) {
				return intervals;
			}
			
			Collections.sort(intervals, (a,b) -> a.start - b.start);
			int start = intervals.get(0).start;
			int end = intervals.get(0).end;
			
			List<Interval> stack = new ArrayList<>();
			
			for (Interval n : intervals) {
				if (end >= n.start) {
					end = Math.max(end, n.end);
				} else {
					stack.add(new Interval(start, end));
					start = n.start;
					end = n.end;
				}
			}

			stack.add(new Interval(start, end));
			return stack;
		}


}
