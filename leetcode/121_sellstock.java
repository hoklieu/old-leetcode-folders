public class Solution {
    //version 1: maximum continuous subarray problem 
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] diff = new int[prices.length - 1];
        //get the differences array between two pairs
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        //convert to the maximum continuous subarray problem
        int[] dp = new int[diff.length];
        dp[0] = diff[0];
        int max = dp[0];
        for ( int i = 1; i < dp.length; i++) {
            dp[i] = diff[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max,dp[i]);
        }
        return (max > 0)? max : 0;
    }
}

//version 2: in place dp
public class Solution {
    public int maxProfit(int[] prices) {
        int globalmax = 0;
        int localmax = 0;

        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            // 
            localmax = Math.max(0,localmax + prices[i + 1] - prices[i]);
            globalmax = Math.max(localmax,globalmax);
        }
        return globalmax;
    }
}

// version 3: find the minimum and find the largest behind
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            // if find the new minimum, just update it. Nothing else!
            if (prices[i] < min) {
                min = prices[i];
                //you can't set the diff to be zero because you have to store the previous max diff
                //diff = 0;
                continue;
            }
            // update the max diff
            diff = Math.max(diff,prices[i] - min);
        }
        return diff;
    }
}