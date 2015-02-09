package bit;

public class SingleNumber {
	public int singleNumber(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int rst = num[0];
        for (int i = 1; i < num.length; i++) {
            rst ^= num[i];
        }
        
        return rst;
    }
}
