package Algorithm.Sorting;

public class BubbleSort {
    // This function performs bubble sort
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { //Define maximum number of passes
            for (int j = 0; j < n - i - 1; j++) { //Loop through the array
                if (arr[j] > arr[j + 1]) {//Swap if the element found is greater than the next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // This function prints the array

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {64, 10, 114, 23, 11};
        System.out.println("Unsorted array");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }    
}
