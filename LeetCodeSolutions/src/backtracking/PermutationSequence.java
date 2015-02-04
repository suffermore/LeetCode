package backtracking;

import java.util.ArrayList;

public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		
		k--;
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numList.add(i);
		}
		
		//get factor
		int factor = 1;
		for (int i = 2; i < n; i++) {
			factor *= i;
		}
		
		String rst = "";
		//i present ith digit
		for (int i = n - 1; i >= 0; i--) {
			
			int index = k / factor;
			k = k % factor;
			rst += numList.get(index);
			numList.remove(index);
			
			if (i > 0) {
				factor /= i;
			}
			
		}
		
		return rst;
    }
	
	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 3));
	}
}
