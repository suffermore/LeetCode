package binarytree.bst;

public class UniqueBST {
	
	//method II
	public int numTreesII(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        //i means the first i node
        for (int i = 2; i <= n; i++) {
        	//j means the jth node; let the jth node be root, num = count[j - 1] * count[i - j]
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }
}
