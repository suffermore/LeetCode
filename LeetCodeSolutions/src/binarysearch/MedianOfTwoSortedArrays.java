package binarysearch;

public class MedianOfTwoSortedArrays {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A == null) {
            if (B.length % 2 == 0) {
                return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
            } else {
                return B[B.length / 2];
            }
        }
        if (B == null) {
            if (A.length % 2 == 0) {
                return (A[A.length / 2] + A[A.length / 2 + 1]) / 2.0;
            } else {
                return A[A.length / 2];
            }
        }
        
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
	
    //a is the starting index of A now, b is the starting index of B now
    private int findKth(int A[], int a, int[] B, int b, int k) {
        //when one of A and B has no one left to cut off
        if (a == A.length) {
            return B[b + k - 1];
        }
        if (b == B.length) {
            return A[a + k - 1];
        }
        
        //when k == 1, k can not divide into two parts
        if (k == 1) {
        	return Math.min(A[a], B[b]);
        }
        
        //divide k into two part: partA and partB
        int partA = 0, partB = 0;
        if (A.length - a < k / 2) {
            //A has less than k/2 elements, let partA = total number of elements left in A
            partA = A.length - a;
            partB = k - partA;
        } else if (B.length - b < k / 2) {
            //B has less elements than k/2, let partB = total number of elements left in B
            partB = B.length - b;
            partA = k -partB;
        } else {
            //both A and B have enough elements which are more than k/2
            partA = k / 2;
            partB = k / 2;
            //note: partB != k - k/2, because we can only make sure elements in A and B are more than k/2, when k is 5, k/2 = 2, k - k/2 = 3
        }
        
        //cut one part off by comparing the first partA and the first partB elements
        if (A[a - 1 + partA] < B[b - 1 + partB]) {
            return findKth(A, a + partA, B, b, k - partA);
        } else {
            return findKth(A, a, B, b + partB, k - partB);
        }
    }
    
    public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] A = {2, 3, 4};
		int[] B = {1};
		System.out.println(m.findMedianSortedArrays(A, B));
	}
}
