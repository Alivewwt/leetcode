package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/23 9:14 下午
 * 组成硬币的种类数
 **/
public class waysToChange_08 {
    public int waysToChange(int n) {
        //组成硬币为n的可能个数
        int[][] dp = new int[4][n + 1];
        int[] coins = {1, 5, 10, 25};

        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i])
                    //选当前硬币
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[3][n];
    }

    public static void main(String[] args) {
        System.out.println(new waysToChange_08().waysToChange(5));
    }
}
