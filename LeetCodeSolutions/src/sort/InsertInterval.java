package sort;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        int pos = 0;
        
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                pos++;
            } else if (interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        
        result.add(pos, newInterval);
        return result;
    }
		
	public static void main(String[] args) {
		Interval a = new Interval(1, 5);
		Interval b = new Interval(2, 3);

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(a);
        
		InsertInterval i = new InsertInterval();
		i.insert(intervals, b);
	}
}
