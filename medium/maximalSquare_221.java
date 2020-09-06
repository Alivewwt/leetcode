package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/5/8 9:47 下午
 * 组成最大正方形的面积
 **/
public class maximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int maxArea =0;
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return maxArea;
        int rows = matrix.length,cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    //边界，
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }

                    maxArea = Math.max(maxArea,dp[i][j]);
                }
            }
        }
        return maxArea*maxArea;
    }
}
