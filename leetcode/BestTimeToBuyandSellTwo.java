/*
 * 题目:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 这道题k可以无限次买入和卖出。我们只需要从第二天开始，如果当前价格比之前价格高，
 * 则把差值加入利润中，因为我们可以昨天买入，今日卖出，若明日价更高的话，还可以
 * 今日买入，明日跑出。以此类推，遍历完整个数组后即可求得最大利润。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length<2)
        return 0;
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}