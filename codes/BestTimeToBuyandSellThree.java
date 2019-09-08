/*
* 题目:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
* 题目要求最多交易两次，找到最大利润，需要利用动态规划。我们其实可以求至少k次交易的最大利润，找到通解后可以设定 k = 2，即为本题的解答。
* 我们定义local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。
* 然后我们定义global[i][j]为在到达第i天时最多可进行j次交易的最大利润，此为全局最优。
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<2)
        return 0;
        int[] a=new int[len];
        int[] b=new int[len];
        int minV=prices[0];
    //    a[0]=0;
        for(int i=1;i<prices.length;i++)
        {
            minV=Math.min(prices[i],minV);
            a[i]=Math.max(a[i-1],prices[i]-minV);
        }
        int maxV=prices[len-1];
     //   b[len-1]=0;
        for(int i=len-2;i>=0;i--){
           maxV=Math.max(maxV,prices[i]);
           b[i]=Math.max(b[i+1],maxV-prices[i]);
        }
        int rs=0;
        for(int i=0;i<len;i++)
          {
              if(rs<a[i]+b[i])
                rs=a[i]+b[i];
          }
          return rs;
    }
}