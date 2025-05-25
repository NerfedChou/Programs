package Algorithm.Sorting;
public class BubbleSort {
    
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        int max = n - 1;
        for (int i = 0; i < max; i++) { 
            for (int j = 0; j < max - i; j++) { 
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                
                }
            }
        }
    }
    

    public static void printArray(int arr[]) {
        for (int i: arr) 
            System.out.print( i + " ");
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
