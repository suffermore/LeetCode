package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
//	private Comparator<Interval> c = new Comparator<Interval>() {
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            return o1.start - o2.start;
//        }
//    };
    
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        List<Interval> rst = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        	
		});
        
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end) {
                last.end = Math.max(cur.end, last.end);
            } else {
                rst.add(last);
                last = cur;
            }
        }
        
        rst.add(last);
        return rst;
    }
}
