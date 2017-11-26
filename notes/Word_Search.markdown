### 题目描述

题意很简单，给你一个二维字母数组，可以上下左右走，查找某个单词是否存在。同一位置的字母不可以被使用多次。

举例

>```tex
>[
>  ['A','B','C','E'],
>  ['S','F','C','S'],
>  ['A','D','E','E']
>]
>word = "ABCCED", -> returns true,
>word = "SEE", -> returns true,
>word = "ABCB", -> returns false.
>```

### 思路

这道题是典型的深度优先遍历DFS的应用，原二维数组就像是一个迷宫，可以上下左右四个方向行走，我们以二维数组中每一个数都作为起点和指定字符串做匹配，我们还需要一个和原数组等大小的visited的数组，是布尔类型，用来记录当前位置是否被访问过，因为题目要求一个cell只能被访问一次。如果一个二维数组board的当前字符和目标字符串word对应的字符相等，则对其上下左右四个字符分别调用DFS的递归函数，只要有一个返回true，那么就表示可以找到对应的字符串，否则就不能找到。

### 代码

```java
class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(word.charAt(0)==board[i][j] && search(board,word,i,j,0)){
                     return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,String word,int i,int j,int index){
        if(index==word.length())
            return true;
        if(i>=board.length|| i<0 || j>=board[i].length || j<0||visited[i][j]==true|| word.charAt(index)!=board[i][j])
            return false;
        visited[i][j]=true;
        if(search(board,word,i+1,j,index+1)||
           search(board,word,i-1,j,index+1)||
           search(board,word,i,j+1,index+1)||
           search(board,word,i,j-1,index+1))
            return true; 
        visited[i][j]=false;
        return false;
    }
}
```

