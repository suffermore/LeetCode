package math;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	/**
	 * gray code n = former code + [1<< (n - 1) + elements in reversed list of (gray code(n - 1))]
	 * */
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		
		result = grayCode(n - 1);
		int addNumber = 1 << (n - 1);
		
		int size = result.size();
		for (int i = size - 1; i >= 0; i--) {
			result.add(result.get(i) + addNumber);
		}
		
		return result;
    }
	
	public List<Integer> grayCodeII(int n) {
        List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		
		if (n == 0) {
			return result;
		}

        for (int i = 1; i <= n; i++) {
		    int addNumber = 1 << (i - 1);
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + addNumber);
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		g.grayCode(1);
	}
}
