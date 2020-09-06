package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/11 9:32 下午
 * 机器人的运动范围，上下左右移动，格子的坐标和不能超过k
 **/
public class movingCount_13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visted = new boolean[m][n];
        return MovingCount(k,m,n,0,0,visted);

    }
    public int MovingCount(int threshold, int m ,int n,int row,int col,boolean[][] visited){
        if(row<0 ||row>=m || col<0||col>=n)
            return 0;
        if(visited[row][col]|| sumRowCol(row,col )>threshold)
            return 0;
        visited[row][col] = true;
        return 1+MovingCount(threshold,m,n,row+1,col,visited)+
                MovingCount(threshold,m,n,row-1,col,visited)+
                MovingCount(threshold,m,n,row,col+1,visited)+
                MovingCount(threshold,m,n,row,col-1,visited);
    }

    public int sumRowCol(int row,int col){
        int sum=0;
        while(row>0){
            sum+=row%10;
            row/=10;
        }
        while(col>0){
            sum+=col%10;
            col/=10;
        }
        return sum;

    }

}
