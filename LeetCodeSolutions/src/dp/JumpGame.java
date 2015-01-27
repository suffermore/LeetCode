package dp;

public class JumpGame {
	
	//O(n) method
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        int maxCover = 0;
        for (int i = 0; i <= maxCover; i++) {
            if (i + A[i] > maxCover) {
                maxCover = i + A[i];
            }
            if (maxCover >= A.length - 1) {
                return true;
            }
        }
        return false;
    }
    
    //O(n^2) method
    public boolean canJumpII(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            //can[i] = false;
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] >= i - j) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[A.length - 1];
    }
}
