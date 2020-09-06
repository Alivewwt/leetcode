package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/6/17 8:45 下午
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 **/
public class maxScoreSightseeingPair_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int mx = A[0]+0;
        int res =0;
        for(int i=1;i<A.length;i++){
            res = Math.max(res,mx+A[i]-i);
            //一边遍历一边保存
            mx = Math.max(mx,A[i]+i);
        }
        return res;
    }

    public static void main(String[] args) {
        maxScoreSightseeingPair_1014 maxs = new maxScoreSightseeingPair_1014();
        int[]  A ={8,1,5,2,6};
        System.out.println(maxs.maxScoreSightseeingPair(A));
    }
}
