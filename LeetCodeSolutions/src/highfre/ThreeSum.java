package highfre;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        
        Arrays.sort(num);
        //pick a
        for (int i = 0; i < num.length - 2; i++) {
            
            if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			
            int tar = 0 - num[i];
            //Use two pointer to pick b and c (b + c = 0 - a)
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                
                if (num[left] + num[right] == tar) {
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(num[i]);
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
                    
                } else if (num[left] + num[right] < tar) {
                    left++;
                } else {
                    right--;
                }
            }
            
        }
        
        return rst;
    }
}
