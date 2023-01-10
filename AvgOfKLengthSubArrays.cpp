import java.util.*;

public class Main {
    /**
     * 
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     * Array: [1, 3, 2, 6, -1, 4, 1, 8, 5], K=5
     * Output: 2.2, 2.8, 2.4, 3.6, 3.4
     */

    public static double[] getAveragesOfKLengthSubarrays(int[] arr, int k) {
      int n = arr.length;

      // calculate the sum of first k length subarray
      int curWindowSum = 0;
      for (int i = 0; i < k; i++) {
        curWindowSum += arr[i];
      }

      double[] result = new double[n - k + 1];
      result[0] = curWindowSum / (double)k;
      for (int i = 1; i <= n - k; i++) {
        curWindowSum -= arr[i - 1];
        curWindowSum += arr[i + k - 1];
        result[i] = curWindowSum / (double)k;
      }

      return result;
    }

    // TC: O(n) | SC: O(n)

    public static void main(String[] args) {
      int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 5 };
      int k = 5;
      
      double[] result = getAveragesOfKLengthSubarrays(arr, k);
      for (double i: result) {
          System.out.print(i + " ");
      }

      System.out.println();
    }
}
