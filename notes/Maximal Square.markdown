### 问题

给定一个数值只含'0'和'1'的二维数组，找出数组中含'1'的最大正方形的面积。

举个例子，

>```tex
>1 0 1 0 0
>1 0 1 1 1
>1 1 1 1 1
>1 0 0 1 0
>```



返回4

### 思路

本题考查动态规划，和之前一道求岛屿数量的题类似，不过求岛屿数量深度遍历即可。这道题深度遍历时，还需考虑是否满足正方形的要求。当我们判断以某个点为正方形右下角的最大的正方形时，那它的上方，左上方和左方三个点也一定是某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。如果以$$matrix[i-1][j]、matrix[i][j-1]、matrix[i-1][j-1]$$为右下角的正方形边长相等，那么加上该点后就可以构成一个更大的正方形。如果它们不想等，那么因为缺失某部分，而无法构成更大正方形，那么只能取3个正方形最小的一个加1，为此我们得到动态规划递推式：

$$dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])$$

### 代码

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-'0';
            max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-'0';
            max=Math.max(max,dp[0][i]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
        
            }
        }
            
        return max*max;
    }
}
```

