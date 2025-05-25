public class ShellSort{

  static void Display_array(int arr[])
  {
    int N = arr.length;
    for (int i=0; i<N; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  int shell_sort(int Array[])
  {
    int N = Array.length;
    for (int gap = N/2; gap > 0; gap = gap/2)
    {
      for (int i = gap; i < N; i += 1)
      {
        int Temp = Array[i];
        int j;
        for (j = i; j >= gap && Array[j - gap] > Temp; j =j- gap)
          Array[j] = Array[j - gap];
        Array[j] = Temp;
      }
    }
    return 0;
  }

  public static void main(String args[])
  {
    int arr[] = {21, 12, 14, 46, 7, 25, 10, 62, 19, 31, 1};
    System.out.println("Before sorting, the array is: ");
    Display_array(arr);

    ShellSort ob = new ShellSort();
    ob.shell_sort(arr);
    System.out.println("Array after sorting: ");
    Display_array(arr);
  }
}