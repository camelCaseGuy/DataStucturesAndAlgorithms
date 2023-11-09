package HS;

public class HeapSort {
	static void heapify(int arr[], int N, int i) {
		int max = i; 
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < N && arr[l] > arr[max])
			max = l;

		if (r < N && arr[r] > arr[max])
			max = r;

		if (max != i) {
			int swap = arr[i];
			arr[i] = arr[max];
			arr[max] = swap;

			heapify(arr, N, max);
		}
	}

	static void buildHeap(int arr[], int N) {
		int startIdx = (N / 2) - 1;

		for (int i = startIdx; i >= 0; i--) {
			heapify(arr, N, i);
		}
	}

	static void printHeap(int arr[], int N) {
		System.out.println("Array heap:");

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void sort(int arr[]) {
		int N = arr.length;

		for (int i = N / 2 - 1; i >= 0; i--) {
			heapify(arr, N, i);
		}

		for (int i = N - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 15, 12, 5, 11, 3, 10, 6, 20, 23, 9, 4, 24, 8, 1, 7, 2 };

		int N = arr.length;

		buildHeap(arr, N);
		printHeap(arr, N);
		sort(arr);
		printHeap(arr, N);
	}

}
