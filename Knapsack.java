package com.akshay.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 1596272 on 10/12/2020.
 */
public class KnapSack01 {
    int knapSackFindMaxProfit(int[] v, int[] w, int weight, int i) {
        if (i == w.length || weight == 0) {
            return 0;
        }
        if (w[i] > weight)
            return knapSackFindMaxProfit(v, w, weight, i + 1);
        else {
            return Math.max(v[i] + knapSackFindMaxProfit(v, w, weight - w[i], i + 1), knapSackFindMaxProfit(v, w, weight, i + 1));
        }
    }

    int knapSackFindMaxProfitDPTopDown(int[] v, int[] w, int weight, int i, int dp[][]) {
        if (i == w.length || weight == 0) {
            return 0;
        }
        if (dp[i][weight] != -1){
            return dp[i][weight];
        }
        else
            if (w[i] > weight)
                return dp[i][weight] = knapSackFindMaxProfit(v, w, weight, i + 1);
            else {
                return dp[i][weight] = Math.max(v[i] + knapSackFindMaxProfit(v, w, weight - w[i], i + 1), knapSackFindMaxProfit(v, w, weight, i + 1));
            }
    }

    @Test
    public void testKnapSackRecursive() {
        System.out.println("testKnapSackRecursive");
        long time=System.nanoTime();
        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};
        int weight = 10;
        int ans = 60;
        System.out.println("Answer:" + knapSackFindMaxProfit(v, w, weight, 0));
        System.out.println(System.nanoTime()-time);
        Assert.assertEquals(ans, knapSackFindMaxProfit(v, w, weight, 0));
    }

    @Test
    public void knapSackFindMaxProfitDPTopDown() {
        System.out.println("knapSackFindMaxProfitDPTopDown");
        long time=System.nanoTime();
        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};
        int weight = 10;
        int[][] dp = new int[v.length+1][weight+1];
        for(int i=0;i<v.length;i++){
            dp[i][0]=-1;
        }
        for(int i=0;i<weight+1;i++){
            dp[0][i]=-1;
        }
        int ans = 60;
        System.out.println("Answer:" + knapSackFindMaxProfitDPTopDown(v, w, weight, 0,dp));
        System.out.println(System.nanoTime()-time);
        Assert.assertEquals(ans, knapSackFindMaxProfit(v, w, weight, 0));
    }
}
