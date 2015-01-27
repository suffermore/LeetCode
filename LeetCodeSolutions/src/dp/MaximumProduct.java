package dp;

public class MaximumProduct {

	public int maxProduct(int[] A) {
		if( A == null || A.length == 0) {
	        return 0;
		}
		
	    if(A.length == 1) {
	        return A[0];  
	    }
	    
	    int max_local = A[0];  
	    int min_local = A[0];  
	    int global = A[0];
	    
	    for(int i=1;i<A.length;i++) {
	        int last_max = max_local;
	        
	        max_local = Math.max(Math.max(A[i] * last_max, A[i] * min_local), A[i]);  
	        min_local = Math.min(Math.min(A[i] * last_max, A[i] * min_local), A[i]);  

//	        max_local = Math.max(A[i] * temp_max, A[i] * min_local);  
//	        min_local = Math.min(A[i] * temp_max, A[i] * min_local);  
	        
	        global = Math.max(global, max_local);  
	    }
	    return global;
    }
	
	public static void main(String[] args) {
//		int[] A = {2, -1, 3, 0, -2, -6};
//		int[] A = {0, 2};
//		int[] A = {0};
//		int[] A = {-2, 0, -3};
		int[] A = {2, 0, 3};
		MaximumProduct m = new MaximumProduct();
		System.out.println(m.maxProduct(A));
	}
}
