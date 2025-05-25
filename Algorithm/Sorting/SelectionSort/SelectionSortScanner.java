import java.util.Scanner;

public class SelectionSortScanner {

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        int max = n - 1;
        for (int i = 0; i < max; i++) {
            int min_idx = i; // Minimum index
            for (int j = i + 1; j < n; j++) { // Loop through values
                if (arr[j] < arr[min_idx]) // Comparing the values
                    min_idx = j; // If true update the index at initial point
            }
            int temp = arr[min_idx]; // swap function
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

    }

    public static void print(int arr[]){
        for (int each : arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

        

    public static int[] Input() {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Size: ");
            int size = s.nextInt();
            int arr[] = new int[size];
            int i = 0;

            do {
                System.out.println("Enter value");
                int val = s.nextInt();
                arr[i] = val;  
                i++;
            } while (i < size);
            s.close();
            return arr;
        }

    public static void main(String[] args) {

        int[] arr = Input();
        System.out.println("Unsorted Array:");  
        print(arr);
        selectionSort(arr);
        System.out.println("Sorted Array:");
        print(arr);
        
    }
}