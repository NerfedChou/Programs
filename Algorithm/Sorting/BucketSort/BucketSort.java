import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int arr[], int bucketSize) {
        if (arr.length == 0) return;

        // 1) Create buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(new ArrayList<>());
        }

        // 2) Put elements into buckets
        for (int num : arr) {
            int bucketIndex = num / bucketSize;
            if (bucketIndex >= bucketSize) {
                bucketIndex = bucketSize - 1; // Handle large values
            }
            buckets.get(bucketIndex).add(num);
        }

        // 3) Sort each bucket and put back into array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket); // Sort the bucket
            for (int num : bucket) {
                arr[index++] = num; // Put back into array
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int bucketSize = 10; // You can change this!
        System.out.println("Original array: ");
        printArray(arr);
        bucketSort(arr, bucketSize);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
