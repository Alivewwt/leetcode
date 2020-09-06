package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/1 9:17 下午
 * 换硬币 面额不同，每个硬币的数量不限 计算可以凑成总金额所需的最少的硬币个数
 * dp[i] = Math.min(dp[i] , dp[i-coins[j]] + 1)
 **/
public class coinChange_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        //面额从1开始,数量加1
        int costs[] = new int[amount + 1];
        costs[0] = 0;
        // 计算凑成每种总金额的硬币数量
        for (int i = 1; i <= amount; i++) {
            costs[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && costs[i-coins[j]]!=Integer.MAX_VALUE){
                    //可以凑成 面额为i，需要加上一个面额为coins[j]
                    costs[i] = Math.min(costs[i],costs[i-coins[j]]+1);
                }
            }
        }

        return costs[amount]==Integer.MAX_VALUE? -1 : costs[amount];
    }


    public static void main(String[] args) {
        int[]  coins = {1,3,5};
        System.out.println(new coinChange_322().coinChange(coins,11));
    }
}
