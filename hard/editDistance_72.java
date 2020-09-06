package alogrithm.hard;

/**
 * @author created by wuwt
 * @date 2020/4/9 9:29 下午
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * word1[i-1]!=word2[j-1]
 * 插入 dp[i][j] =dp[i][j-1]+1
 * 删除 dp[i][j] = dp[i-1][j]+1
 * 替换 dp[i][j] = dp[i-1][j-1]+1
 **/
public class editDistance_72 {
    public int minDistance(String word1, String word2) {
        int m =word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];
        //初始化
        for(int i=0;i<m+1;i++)
            cost[i][0]=i;
        for(int i=0;i<n+1;i++)
            cost[0][i]=i;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    cost[i][j] = cost[i-1][j-1];
                else{
                    cost[i][j] = Math.min(cost[i-1][j-1],Math.min(cost[i-1][j],cost[i][j-1]));
                    cost[i][j]++;
                }
            }
        }
        return cost[m][n];

    }

    public static void main(String[] args) {
        String word1 ="horse";
        String word2 ="ros";
        System.out.println(new editDistance_72().minDistance(word1,word2));
    }


}
