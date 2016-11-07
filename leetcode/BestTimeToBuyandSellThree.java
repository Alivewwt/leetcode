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