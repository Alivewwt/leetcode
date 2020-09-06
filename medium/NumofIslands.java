package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/3/22 7:52 下午
 * 判断一个矩阵中的连续区域的个数，深度搜索
 **/

public class NumofIslands {
    public static int numIslands(char[][] grid){
        if (grid==null||grid.length==0|| grid[0].length==0)
            return 0;
        int rows = grid.length; //行数
        int cols = grid[0].length; //列数
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        //从矩阵中的每个数开始判断，是否能形成一个"岛屿"
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                   count++;
                    helper(grid,i,j,rows,cols,visited);
                }
            }
        }
        return count;

    }

    private static void helper(char[][] grid, int i, int j, int rows, int cols,boolean visited[][] ) {
        //递归结束条件
        if (i<0 || i>=rows ||j<0 || j>=cols ||  grid[i][j]!='1' || visited[i][j])
            return ;
        //当前矩阵元素被访问过
        visited[i][j] = true;
        helper(grid,i-1,j,rows,cols,visited);
        helper(grid,i,j-1,rows,cols,visited);
        helper(grid,i+1,j,rows,cols,visited);
        helper(grid,i,j+1,rows,cols,visited);

    }
}
