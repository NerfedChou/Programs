import java.util.Scanner;

public class BucketSortScanner {

    public static void bucketSort(int arr[]) {
        if (arr.length == 0) return;

        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Set number of buckets to array length (beginner-friendly)
        int bucketCount = arr.length;
        int bucketSize = (max / bucketCount) + 1;

        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] buckets = new java.util.ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }

        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = num / bucketSize;
            buckets[bucketIndex].add(num);
        }

        // Sort each bucket and concatenate
        int index = 0;
        for (java.util.List<Integer> bucket : buckets) {
            java.util.Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
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
        
        int arr[] = Input();
        System.out.println("Original array: ");
        printArray(arr);
        bucketSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    
    }
}
