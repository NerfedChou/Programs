import java.util.LinkedList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int arr[], int bucketSize) {
        if (arr.length == 0) return;

        // 1) Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // 2) Calculate the number of buckets
        int bucketCount = (max / bucketSize) + 1;

        // 3) Create buckets
        LinkedList<LinkedList<Integer>> buckets = new LinkedList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        // 4) Put elements into buckets
        for (int num : arr) {
            int bucketIndex = num / bucketSize;
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1; // Handle large values
            }
            buckets.get(bucketIndex).add(num);
        }

        // 5) Sort each bucket and put back into array
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
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
