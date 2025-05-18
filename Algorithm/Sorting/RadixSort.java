package Algorithm.Sorting;

public class RadixSort {
   
    // Function to get the largest element from an array
    static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    static void countingSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int count[] = new int[10]; // count array

        // Initialize count array as 0
        for (int i = 0; i < 10; i++)
            count[i] = 0;

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that it contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Main function to implement radix sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // exp is 10^i where i is the current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countingSort(arr, n, exp);
    }

    // Function to print an array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    
    }

    public static void main(String args[]) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        System.out.println("Unsorted array");
        printArray(arr, n);

        radixsort(arr, n);

        System.out.println("\nSorted array");
        printArray(arr, n);
    }
}

