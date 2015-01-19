package dp;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                ArrayList<Integer> prev = result.get(i - 1);
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
