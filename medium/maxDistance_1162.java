package alogrithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author created by wuwt
 * @date 2020/3/29 8:44 下午
 * 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？
 *  请返回该海洋区域到离它最近的陆地区域的距离,广度搜索，将海洋变成陆地最多需要经过几次变换。
 **/
public class maxDistance_1162 {

    public int maxDistance(int[][] grid) {
        if(grid==null || grid[0].length==0)
            return -1;
        int res = 0;
        Queue<int[] > queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                //遇到陆地
                if(grid[i][j]==1){
                   queue.add(new int[]{i,j});
                }
            }
        }
        //如果全部是海洋或者陆地
        if (queue.size()==0|| queue.size()==m*n)
            return -1;
        int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()){
            //前层的节点数; 需要弹出当前层的所有节点, 但是不能弹出新加入的节点
            int count = queue.size();
            for(int i =0;i<count;i++){
                int cur[]= queue.poll();
                int x ,y;
                for(int [] temp: moves){
                    //上下左右
                    x = cur[0] + temp[0];
                    y = cur[1]+ temp[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0){
                        grid[x][y] =1 ;//变成陆地
                        queue.add(new int[]{x,y});
                    }
                }
            }
            res++;
        }
        return res-1;
    }

    public static void main(String[] args) {
        int grid[][] = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(new maxDistance_1162().maxDistance(grid));
    }

}
