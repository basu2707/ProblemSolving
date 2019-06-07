package com.basu.work;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] 1. find if you can attend all meetings {{7,10}, {2,4},
 * {6,7}} -- True {{0,30}, {5,10}, {6,7}} -- False
 * 
 * 2. find the minimum number of conference rooms required. 
 * Given [[0, 30],[5,10],[15, 20]], return 2.
 * 
 * @author sivakumar
 *
 */
public class MeetingRoom {

	public static void main(String[] args) {
		// Interval[] intervals = {new Interval(0,30),new Interval(5,10),new
		// Interval(15,20)};
		Interval[] intervals = { new Interval(7, 10), new Interval(2, 4), new Interval(6, 7) };

		System.out.println("Can attend Meeting canAttendMeeting: " + canAttendMeeting(intervals));
		System.out.println("Can attend Meeting canAttendMeeting1: " + canAttendMeeting1(intervals));
		System.out.println("Can attend Meeting canAttendMeeting2: " + canAttendMeeting2(intervals));
		
		Interval[] intervals1 = { new Interval(0, 30), new Interval(5, 10), new Interval(15, 20) };
		System.out.println("Minimum meeting room required minMeetingRooms: " + minMeetingRooms(intervals1));
		System.out.println("Minimum meeting room required minMeetingRooms1: " + minMeetingRooms1(intervals1));
		
	}

	private static boolean canAttendMeeting(Interval[] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}

		Arrays.sort(start);
		Arrays.sort(end);

		for (int i = 0; i < start.length - 1; i++) {
			if (start[i + 1] < end[i]) {
				return false;
			}
		}

		return true;
	}

	private static boolean canAttendMeeting1(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Time Complexity: O(n logn), Space Complexity: O(1)
	 * 
	 * @param intervals
	 * @return
	 */
	public static boolean canAttendMeeting2(Interval[] intervals) {
		if (intervals == null) {
			return true;
		}
		Arrays.sort(intervals,
				(Interval i1, Interval i2) -> i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
	
	private static int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		//PriorityQueue spits out the minimum value
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int rooms = 0;
		for (int i = 0; i < intervals.length; i++) {
			minHeap.offer(intervals[i].end);
			if (intervals[i].start < minHeap.peek()) {
				rooms++;
			} else {
				minHeap.poll();
			}
		}
		return rooms;
	}

	private static int minMeetingRooms1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
        	return 0;
        }
		
		int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int activeMeetings = 0;
        int i=0, j=0;
        
        while (i < intervals.length && j < intervals.length) {
            if (starts[i] < ends[j]) {
                activeMeetings ++;
                i ++;
            } else {
                activeMeetings --;
                j ++;
            }
            rooms = Math.max(rooms, activeMeetings);
        }
        return rooms;
    }
}

class Interval {
	int start;
	int end;
	Interval() {
		start=0;
		end=0;	
	}
	Interval(int s, int e){
		start=s;
		end=e;
	}
}
