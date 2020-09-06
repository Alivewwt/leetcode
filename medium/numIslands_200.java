package alogrithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author created by wuwt
 * @date 2020/4/20 9:25 下午
 * 计算岛屿的个数,"1"为陆地，"0"为海洋，陆地周围全为海洋则为岛屿
 **/
public class numIslands_200 {

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1')
            return ;
        //访问过置为'2'
        grid[i][j]= '2';

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }
    /*
    我们可以扫描整个二维网格。如果一个位置为 1，则将其加入队列，开始进行广度优先搜索。在广度优先搜索的过程中，
    每个搜索到的 1 都会被重新标记为 0。直到队列为空，搜索结束。
    最终岛屿的数量就是我们进行广度优先搜索的次数。
     */
    public int bfs(char[][]grid){
        if(grid==null||grid.length==0)
            return 0;
        int n = grid.length,m = grid[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int res =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0')
                    continue;
                res++;
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[]{i,j});
                grid[i][j] ='0';
                while (!que.isEmpty()){
                    int[] top = que.poll();
                    for(int k=0;k<4;k++){
                        int new_x = top[0]+dir[k][0];
                        int new_y = top[1]+dir[k][1];
                        if(new_x<0||new_x>=n||new_y<0||new_y>=m||grid[new_x][new_y]=='0')
                            continue;
                        // 搜索到1
                        que.add(new int[]{new_x,new_y});
                        // 访问过置为0
                        grid[new_x][new_y]='0';

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0',},
                {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new numIslands_200().bfs(grid));
    }

}
