import java.util.Scanner;

public class BubbleSortScanner {
    
    public static void BubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n -1 - i; j++) {

                if (arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1]  = temp;
                }

            }
        }

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
            arr[i] = val; // store input at index i
            i++;
        } while (i < size);
        s.close();
        return arr;
    }

    public static void print(int arr[]) {
        for (int each: arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] arr = Input();
        System.out.println("Unsorted");
        print(arr);
        BubbleSort(arr);
        System.out.println("Sorted");
        print(arr);

    }
}
