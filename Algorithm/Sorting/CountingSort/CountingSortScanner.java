 import java.util.Scanner;

    public class CountingSortScanner {

        public static void countingSort (int[] arr) {

            int n = arr.length;
            int range = arr[0];
            for (int i = 0; i < n ; i++) {
                if(arr[i] > range) {
                    range = arr[i];
                }
            }
            int count[] = new int[range + 1]; // count array

            // Initialize count array as 0
            for (int i = 0; i < range + 1; i++)
                count[i] = 0;

            for (int i = 0; i < n; i++)
                count[arr[i]]++;

            for (int i = 1; i <= range; i++)
                count[i] += count[i - 1];

            int[] output = new int[n]; // output array

            for (int i = n - 1; i >= 0; i--) {
                output[count[arr[i]] - 1] = arr[i];
                count[arr[i]]--;
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
                arr[i] = val;  
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

       public static void main (String[] args) {

        int arr[] = Input();
        System.err.println("Unsorted");
        print(arr);
        countingSort(arr);
        System.err.println("Sorted");
        print(arr);   

    }


    }

