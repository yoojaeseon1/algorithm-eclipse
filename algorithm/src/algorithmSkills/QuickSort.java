package algorithmSkills;

public class QuickSort {

	public static void main(String[] args) {
		
		
		int[] arrs = { 69, 10, 30, 2, 16, 8, 31, 22 };
		quickSort(arrs, 0, arrs.length - 1);
		System.out.println("°á°ú");

		for (int i : arrs) {
			System.out.print(i + " ");
		}


	}

	public static int partition(int[] arr, int left, int right) {

		int pivot = arr[(left + right) / 2];
		System.out.println("pivot : " + pivot);
		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			System.out.println("left : " + left);
			while ((arr[right] > pivot) && (left < right))
				right--;
			System.out.println("right : " + right);

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		System.out.println("---------");
		return left;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		
		for(int arrI = 0; arrI < arr.length; arrI++) {
			System.out.print(arr[arrI] + " ");
		}
		System.out.println();
		
		
		if(left < right) {
			int newPivotIndex = partition(arr, left, right);
			
			quickSort(arr, left, newPivotIndex-1);
			quickSort(arr, newPivotIndex + 1, right);
		}
		
	}

}
