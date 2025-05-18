package Algorithm.Sorting;

public class CountingSort {
   
    // Function to perform counting sort
    public static void countingSort(int arr[], int range) {
        int n = arr.length;
        int output[] = new int[n]; // output array
        int count[] = new int[range + 1]; // count array

        // Initialize count array as 0
        for (int i = 0; i < range + 1; i++)
            count[i] = 0;

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        // Change count[i] so that it contains actual position of this digit in output[]
        for (int i = 1; i <= range; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    // Function to print the array
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        int range = 8; // Range of input values
        System.out.println("Original array:");
        printArray(arr);
        countingSort(arr, range);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
