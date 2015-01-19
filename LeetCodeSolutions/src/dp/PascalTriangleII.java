package dp;

import java.util.ArrayList;

public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return list;
        }
        
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> prev = list;
            list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }
        return list;
    }
}
