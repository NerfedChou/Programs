public class BucketSort {

    public static void bucketSort(int arr[], int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] buckets = new java.util.ArrayList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }

        // 2) Insert elements into their respective buckets
        for (int num : arr) {
            int bucketIndex = num / bucketSize;
            if (bucketIndex >= bucketSize) {
                bucketIndex = bucketSize - 1;
            }
            buckets[bucketIndex].add(num);
        }

        // 3) Sort each bucket and concatenate the result
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
    
    public static void main(String[] args) {
        
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int bucketSize = 10; // Size of each bucket
        System.out.println("Original array: ");
        printArray(arr);
        bucketSort(arr, bucketSize);
        System.out.println("Sorted array: ");
        printArray(arr);
    
    }
}
