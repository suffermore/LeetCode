package dp;

public class JumpGame {
	
	//O(n) method
	public boolean canJump(int[] A) {
        
        int cover = 0;
        //easy to be wrong: <= ; i + A[i]; A.length - 1
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + A[i]);
            if (cover >= A.length - 1) {
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
