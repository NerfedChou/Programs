
package Algorithm.Sorting;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        int n = arr.length; //Lenght in nums not max size
        for (int i = 0; i < n - 1; i++) { // The loop defines Max Number by Subtracting - 1 to L to base 10
            int min_idx = i; // Minimum index
            for (int j = i + 1; j < n; j++) { // Loop through values
                if (arr[j] < arr[min_idx]) //Comparing the values
                    min_idx = j; // iF true update the index at initial point
            }
            int temp = arr[min_idx]; // swap function skip this part
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int arr[]) { // printing skipp this part
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) { //Add Scanner if possible
        int arr[] = {64, 25, 12, 22, 11};
        printArray(arr);
        selectionSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
