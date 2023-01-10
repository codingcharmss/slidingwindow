//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int findMaxAverage(int arr[], int n, int k) {
        // code here
        // calculate the sum of first k length subarray
      int curWindowSum = 0;
      for (int i = 0; i < k; i++) {
        curWindowSum += arr[i];
      }

      double maxWindowAvg = curWindowSum / (double)k;
      int windowStart = 0;
      for (int i = 1; i <= n - k; i++) {
        curWindowSum -= arr[i - 1];
        curWindowSum += arr[i + k - 1];
        double curWindowAvg = curWindowSum / (double)k;
        if (curWindowAvg > maxWindowAvg) {
            windowStart = i;
            maxWindowAvg = curWindowAvg;
        }
      }

      return windowStart;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> k;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.findMaxAverage(arr, n, k);
        for (int i = ans; i < ans + k; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends
