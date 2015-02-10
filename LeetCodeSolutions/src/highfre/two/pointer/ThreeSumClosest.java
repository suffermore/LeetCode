package highfre.two.pointer;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        
        int closest_sum = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                closest_sum = Math.abs(target - sum) < Math.abs(target - closest_sum) ? sum : closest_sum;
            }
        }
        return closest_sum;
    }
	
	public static void main(String[] args) {
		int[] nums = {-3,-2,-5,3,-4};
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(nums, -1));
	}
}
