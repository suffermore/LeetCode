package sort;

public class MergeSort {

	private static int tempArr[];
	private static int number=0;
	
	public static void mergeSort(int arr[], int tempArr[], int m, int n) {

		int mid = (m+n)/2;
		if (m < n) {
			mergeSort(arr, tempArr, m, mid);
			mergeSort(arr, tempArr, mid+1, n);
	
			merge(arr,m,mid,n);
		}
	}
	
	private static void merge(int arr[], int left, int mid, int right){
		
		int i=left;
		int j=mid+1;
		int p=left;
		
		if(i==0&&j==2){
			System.out.print("___");
		}
		while (i<=mid&&j<=right) {
			
			if (arr[i]<=arr[j])
				tempArr[p++] = arr[i++];
			else
				tempArr[p++] = arr[j++];
		}

		while (i<=mid) {
			tempArr[p++] = arr[i++];
		}
		while (j<=right) {
			tempArr[p++] = arr[j++];
		}

		for (int k = left; k <= right; k++)  
		    arr[k] = tempArr[k];
		 
        System.out.println("The "+(++number)+"st Sorting:\t");
        
        for (int k=0;k<tempArr.length;k++) {
			System.out.print(tempArr[k]);
		}
		System.out.print("\n");
		
	}
	
	public static void main(String args[]){
		//int[] array = {6,1,4,2,9,5,8,7,3};
		int[] array = {6,1,3,2};

		System.out.print("\nBefore Sort:\n");
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		
		tempArr = new int[array.length];
		mergeSort(array, tempArr, 0, array.length-1);

		System.out.print("\nAfter Sort:\n");
		for (int i=0;i<tempArr.length;i++) {
			System.out.print(tempArr[i]);
		}
	}
}
