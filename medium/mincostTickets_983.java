package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/5/6 9:32 下午
 * 花最低的票价完成旅行
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 每一天以当前日期截止的最优解
 **/
public class mincostTickets_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int last = days[len-1];//最后一天
        int[] dp = new int[last+1];//表示第i天最便宜的花费
        int pos = 0;
        for(int i=1;i<=last;i++){
            if(i==days[pos]){
                int day1 = i-1;
                int day2 = i-7>0?i-7:0;
                int day3 = i-30>0?i-30:0;
                dp[i] = Math.min(dp[day1]+costs[0],Math.min(dp[day2]+costs[1],dp[day3]+costs[2]));
                pos++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[last];
    }

    public static void main(String[] args) {
        int days[] = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        System.out.println(new mincostTickets_983().mincostTickets(days,costs));
    }
}
