import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSortScanner {

    public static void bucketSort(int arr[]) {
        if (arr.length == 0) return;

        // 1) Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // 2) Set number of buckets to array length 
        int bucketCount = arr.length;
        int bucketSize = (max / bucketCount) + 1;

        // 3) Create buckets (LinkedList of LinkedLists)
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
