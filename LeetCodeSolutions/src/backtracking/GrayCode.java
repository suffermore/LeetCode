package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
		
		if (n == 0) {
			return result;
		}
		
        for (int i = 1; i <= n; i++) {
		    int addNumber = 1 << (i - 1);
		    int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) + addNumber);
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		System.out.println(g.grayCode(3));
	}
}
