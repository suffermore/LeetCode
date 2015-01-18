package dp;

public class JumpGameII {
	//O(n) method
    public int jump(int[] A) {
    	int curCover = 0;
    	int count = 0;
    	int nextCover = 0;	//when traverse i under curCover, there might be a bigger cover be found.
    	
    	int i = 0;
    	while (i < A.length) {
    		if (nextCover >= A.length - 1) {
    			break;
    		}
    		while (i <= nextCover) {
    			curCover = Math.max(curCover, i + A[i]);
    			i++;
    		}
    		count++;
    		nextCover = curCover;
    	}
    	
        return count;
    }
    
    //O(n^2) method
    public int jumpII(int[] A) {
        int[] steps = new int[A.length];
        steps[0] = 0;   //Initialize: you are positioned at 1st node, so steps[0] = 0;
        
        for (int i = 1; i < A.length; i++) {
        
            steps[i] = Integer.MAX_VALUE;   //Assume step i is unreachable whose value is Integer.MAX_VALUE
            
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    /**
                     * Don't worry if there are less steps behind j, 
                     * because all the (j'|j' >j),it's steps[j'] must larger than steps[j]
                     */
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        
        return steps[A.length - 1];
    }
      
    public static void main(String[] args) {
		JumpGameII jump = new JumpGameII();
//		int[] A = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		int[] A = {1,2};
		System.out.println(jump.jump(A));
	}
}
