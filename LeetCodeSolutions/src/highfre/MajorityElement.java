package highfre;

public class MajorityElement {
	public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int count = 1;
        int candidate = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    candidate = num[i];
                }
            }
        }
        return candidate;
    }
}
