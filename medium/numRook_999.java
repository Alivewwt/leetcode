package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/3/27 8:33 下午
 *  遇到"象"(B)停止，遇到"卒"(p)吃
 **/
public class numRook_999 {
    int res = 0;
    public  int numRookCapture(char board[][]){
     //  定义上下左右四个方向；
        if(board==null||board[0].length==0)
            return 0;
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                //找到白车
                if (board[i][j]=='R'){
                    //上下左右四个方向
                    movei(board,i-1,j,-1,0);
                    movei(board,i+1,j,1,0);
                    movei(board,i,j-1,0,-1);
                    movei(board,i,j+1,0,1);
                }
            }

        }
        return res;
    }

    public  void movei(char[][] board,int i,int j,int dx,int dy){
        //确定边界 和遇到"白象"
        if(i<0||i>=board[0].length || j<0||j>=board[0].length||board[i][j]=='B')
            return ;
        if (board[i][j]=='p'){
            res++;
            return;
        }

        movei(board,i+dx,j+dy,dx,dy);

    }

    public static void main(String[] args) {
        char[][] boards = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(new numRook_999().numRookCapture(boards));
    }

}
