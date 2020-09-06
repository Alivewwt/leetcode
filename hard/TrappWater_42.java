package alogrithm.hard;

/**
 * @author created by wuwt
 * @date 2020/4/6 9:43 上午
 * 收集雨水，左右两边的柱子应该一样高，否则则以最低高度作为能收集到的雨水
 **/
public class TrappWater_42 {
    public int trap(int[] height) {
        int res = 0, mx =0, n =height.length;
        int dp[] = new int[n];
        //从左找最大值
        for(int i=0;i<n;i++){
            dp[i] = mx;
            mx = Math.max(dp[i],height[i]);
        }

        mx =0;
        for(int i = n-1;i>=0;i--){
            //和左边最大值比较，取较小值
            dp[i] = Math.min(dp[i],mx);
            //从右边找最大值
            mx = Math.max(height[i],mx);
            if(dp[i]-height[i]>0){
                res += dp[i]-height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
       System.out.println(new TrappWater_42().trap(height));
    }
}
