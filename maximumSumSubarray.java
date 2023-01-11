// https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        
        long curSum = 0;
        for (int i = 0; i < K; i++) {
            curSum += Arr.get(i);
        }
        
        long maxSum = curSum;
        for (int i = 1; i < N - K + 1; i++) {
            curSum += Arr.get(i + K - 1);
            curSum -= Arr.get(i - 1);
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
        
        // TC: O(n) | SC: O(1)
    }
}
