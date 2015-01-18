package sort;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                continue;
            }
            A[count++] = A[i];
        }
        return count;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,4,2,5};
		RemoveElement r = new RemoveElement();
		int count = r.removeElement(A, 2);
		System.out.println(count);
	}
}
