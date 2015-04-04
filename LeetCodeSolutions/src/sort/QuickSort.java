package sort;

public class QuickSort {
	
	public static void quickSort(int arr[], int left, int right){
		//Do nothing if left >= right
		if(left < right){
			int pivot = partition2(arr, left, right);
			//Recursive quicksort the left parts and right parts
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	private static int partition(int arr[], int left, int right){
		//p <- Get a number from array
		int p = arr[left];
		int i = left, j = right;

	    //Put elements < p to the left side, and elements >= p to the right side
		while(i<j){
			for (i = i+1; i < right; i++) {
				if (arr[i]>p)
					break;
			}
			for (j = j; j > left; j--){
				if(arr[j]<=p)
					break;
			}
			if (i<j){
				swap(i,j, arr);
			}
		}
	    //Put p in the middle slot which index is pivot
		swap(left, j, arr);
		return j;
	}

	private static int partition2(int arr[], int left, int right){
		//p <- Get a number from array
	    int p=arr[left];
	    
	    //Put elements < p to the left side, and elements >= p to the right side
	    int i=left,j;
	    for(j=left+1;j<=right;j++){
	        if(arr[j]<p){
	        	i++;
	            swap(i,j,arr);
	        }
	    }
	    //Put p in the middle slot which index is pivot
	    swap(i,left,arr);
	    return i;
	}
	
	private static void swap(int i, int j, int arr[]){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String args[]){
		//int[] a = {4,2,3,4,1,7,6,9,4,5,8};
//		int[] a = {2,3,1,7,6,9,4,5,8};
		int[] a = {8,1,10,1,8,8,2,4,9,3,8,1,3,3,6,2,5,1,1,7,1,1,3,9,6,4,6,6,7,2};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println("\nQuickSort:");
		quickSort(a, 0, a.length-1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
