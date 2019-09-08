/*
 *题目:https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 这道题求进行一次交易能得到的最大利润，属于动态规划类型的题
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
        return 0;
        int low=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<low)
                low=prices[i];
            else if(prices[i]-low>ans)
                ans=prices[i]-low;
        }
        return ans;
    }
}