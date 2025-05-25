import java.util.List;
import java.util.ArrayList;

public class bucket {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (float num : arr) {
            int index = (int)(num * n);
            buckets.get(index).add(num);
        }

        for (List<Float> bucket : buckets) {
            for (int i = 1; i < bucket.size(); i++) {
                float key = bucket.get(i);
                int j = i - 1;
                while (j >= 0 && bucket.get(j) > key) {
                    bucket.set(j + 1, bucket.get(j));
                    j--;
                }
                bucket.set(j + 1, key);
            }
        }

        int idx = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[idx++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] data = { 0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f };

        System.out.println("Before sorting:");
        for (float num : data) {
            System.out.print(num + " ");
        }

        bucketSort(data);

        System.out.println("\nAfter sorting:");
        for (float num : data) {
            System.out.print(num + " ");
        }
    }
}
    

