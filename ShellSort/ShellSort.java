package Algorithm.Sorting;

public class ShellSort {
    // Function to perform shell sort
    public static void shellSort(int arr[]) {
        int n = arr.length;
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save the current element to be inserted
                int temp = arr[i];
                int j;
                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // Function to print the array
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};
        System.out.println("Original array:");
        printArray(arr);
        shellSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
    
}
