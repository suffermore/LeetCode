package datastructure.hash;

import java.util.HashMap;

public class MaxPoints {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int max = 1;
		
		//store points in the same line by a node and a k(k is the slope of the line)
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		
		for (int i = 0; i < points.length; i++) {
			// shared point changed, map should be cleared and serve the new point
			map.clear();
			
			// maybe all points contained in the list are same points,and same points' k is represented by Integer.MIN_VALUE
			map.put((double) Integer.MIN_VALUE, 1);

			int dup = 0;
			//find all lines go through point: points[i], group them by slope and numbers
			for (int j = i + 1; j < points.length; j++) {
				
				//ignore the point if it is the same point with i;
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					dup++;
					continue;
				}
				
				//k is not exist when a line is horizontal
				double k = points[j].x == points[i].x ? 
						Integer.MAX_VALUE : 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
				
				if (map.containsKey(k)) {
					map.put(k, map.get(k) + 1);
				} else {
					map.put(k, 2);
				}
				
			}
			
			//get max numbers
			for (int item : map.values()) {
				max = Math.max(max, item + dup);
			}
			
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Point[] p = new Point[3];
		p[0] = new Point(1, 1);
		p[1] = new Point(1, 1);
		p[2] = new Point(1, 1);
//		p[3] = new Point(1, 1);
		
		MaxPoints m = new MaxPoints();
		int max = m.maxPoints(p);
		System.out.println(max);
		
	}
}
