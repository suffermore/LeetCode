package highfre;

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
	
	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] a = {3,2,4};
		int[] result = new int[2];
		result = t.twoSum(a, 6);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
