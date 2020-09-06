package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/4 10:09 下午
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 最后对所有状态对2取余，则状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。先对原数组进行逐个扫描，
 * 对于每一个位置，扫描其周围八个位置，如果遇到状态1或2，就计数器累加1，扫完8个邻居，
 * 如果少于两个活细胞或者大于三个活细胞，而且当前位置是活细胞的话，标记状态2，
 * 如果正好有三个活细胞且当前是死细胞的话，标记状态3。完成一遍扫描后再对数据扫描一遍，
 * 对2取余变成我们想要的结果。
 **/
public class gameofLife_289 {
    public void gameOfLife(int[][] board) {
        /*
        Dead->Dead: Condition 0;
        Live->Live : Condition 1;
        Live->Dead: Condition 2;
        Dead->Live:Condition 3
         */
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int count = getLive(board,i,j) ;//计算原来8个位置有多少活细胞
                if(board[i][j]==0||count==3){ //dead->live
                    board[i][j] =3;
                }else if(board[i][j]==1 &&(count<2||count>3)){//live->dead
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] = board[i][j]%2;
            }
        }

    }
    //计算原来周围的8个位置上有多少个活细胞
    public int getLive(int[][] board,int i,int j){
        int count =0;
        for(int x =i-1;x<=i+1;x++){
            for(int y =j-1;y<=j+1;y++){
                if(x<0 || x>=board.length || y<0||y>=board[0].length || (x==i &&y==j))
                    continue;

                if(board[x][y]==1||board[x][y]==2)
                    count+=1;
            }
        }

        return count;
    }
}
