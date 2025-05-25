 import java.util.Arrays;
public class RadixSort {
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max)
                max = value;
        }
        return max;
    }
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; 
        int[] count = new int[10]; 

        for (int value : arr) {
            int index = (value / exp) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
      
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }
    public static void main(String[] args) { 
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }
}