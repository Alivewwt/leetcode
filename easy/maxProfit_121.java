package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-02-01
 * 最佳时刻买卖
 * Input: [7,1,5,3,6,4]
 * Output: 5
 **/
public class maxProfit_121 {
    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices==null)
            return 0;
        int maxSell = 0 ;
        int cur = prices[0];//当前价格
        for(int i=1;i<prices.length;i++){
            if(prices[i]<cur)
                cur = prices[i]; //以当前价格买入
            else{
                maxSell = Math.max(prices[i]-cur,maxSell);
            }

        }
        return maxSell;
    }

}
