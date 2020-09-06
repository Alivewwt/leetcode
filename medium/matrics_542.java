package alogrithm.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author created by wuwt
 * @date 2020/4/15 9:19 下午
 * 找到矩阵中每个元素到最近0的距离
 **/
public class matrics_542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;
        int[][] dist = new int[matrix.length][matrix[0].length];
        for (int[] x : dist) Arrays.fill(x, Integer.MAX_VALUE - 1000);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    // 左 上
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1]+1);
                }

            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                //右 下
                if (i < matrix.length - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < matrix[0].length - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);

            }
        }
        return dist;
    }
    //队列广度搜索
    public int[][] updateMatrix_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;
        Queue<int []> queue = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[row][col]==0)
                    queue.add(new int[]{i,j});
                else
                    matrix[i][j] =-1;
            }
        }
        int []dx = {-1,1,0,0};
        int []dy = {0,0,-1,1};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            //遍历每个0节点的上下左右
            for(int i=0;i<4;i++){
                int newX = point[0]+dx[i];
                int newY = point[1]+dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if(newX>=0&& newX<row&& newY>=0 && newY<col&&matrix[newX][newY]==-1){
                    matrix[newX][newY] = matrix[x][y]+1;
                    queue.add(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }
}
