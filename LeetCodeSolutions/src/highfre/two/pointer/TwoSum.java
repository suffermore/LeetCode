package highfre.two.pointer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	map.put(numbers[i],i);
        }
        for (int i = 0; i < numbers.length; i++) {
        	if (map.containsKey(target - numbers[i]) && i < map.get(target - numbers[i])) {
        		result[0] = i + 1;
        		result[1] = map.get(target - numbers[i]) + 1;
        		break;
        	}
        }
        return result;
    }
	
	//Can¡¯t use the sort method here, since the question asks for indexes.
	public int[] twoSumII(int[] nums, int tar) {
		if(nums == null || nums.length < 2) {
    		return null;
    	}
		Arrays.sort(nums);
		int[] rst = new int[2];
		
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] +  nums[right];
			if (sum == tar) {
				rst[0] = left + 1;
                rst[1] = right + 1;
                break;
            } else if (sum < tar){
                left++;
            } else {
                right--;
            }
		}
        return rst;
		
	}
	
	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] a = {3,2,4};
		int[] result = new int[2];
		result = t.twoSum(a, 6);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
