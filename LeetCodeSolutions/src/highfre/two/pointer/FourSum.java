package highfre.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4) {
            return rst;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            //skip duplicates
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                //skip duplicates
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                	if (sum == target) {
                		ArrayList<Integer> sol = new ArrayList<Integer>();
                        sol.add(num[i]);
                        sol.add(num[j]);
                        sol.add(num[left]);
                        sol.add(num[right]);
                        rst.add(sol);
                        left++;
                        right--;
                        
                        //skip duplicates
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }  
                }
            }  
        }
        return rst;
    }
}
