### 题目描述

>给定两个字符串$s_1$和$s_2$,将$s_1$转换成$s_2$需要经过几步，结果输出需要经过变换的步数。
>
>如：输入$s_1$="horse",$s_2$="ros"
>
>输出：3
>
>解释：
>
>horse -> rorse (replace 'h' with 'r')
>
>rorse -> rose (remove 'r')
>
>rose -> ros  (remove 'e')

### 思路

这道题让求从一个字符串转变到另一个字符串需要的变换步骤，共有三种变换方式，插入一个字符，删除一个字符，和替换一个字符。题目咋一看并不难，但是实际却暗藏玄机，对于两个字符串的比较。一般会考虑一下用HashMap统计字符出现的频率，但是在这道题却不可以这样做，因为字符串的顺序很重要。还有一种比较常见的错误，就是想当然的认为对于长度不同的两个字符串，长度的差值都是要插入操作，然后再对应每位字符，不同的地方用修改操作，但是其实这样可能会多用操作，因为**删除有时同时可以达到修改的效果**。比如例子中，当把horse变成rorse之后，之后只要删除第二个r，跟最后一个e，就可以变成ros。实际上只要三步就完成了，因为删除了某个字母后，后来左右不相连的字母就连在一起了，有可能刚好组成了需要的字符串。所以在比较的时候，要尝试三种操作，因为谁也不知道当前的操作会对后面产生什么影响。

对于当前比较的两个字符 word1[i] 和 word2[j]，若二者相同，一切好说，直接跳到下一个位置。若不相同，有三种处理方法，首先是直接**插入**一个 word2[j]，那么 word2[j] 位置的字符就跳过了，接着比较 word1[i] 和 word2[j+1] 即可。第二个种方法是**删除**，即将 word1[i] 字符直接删掉，接着比较 word1[i+1] 和 word2[j] 即可。第三种则是将 word1[i] **修改**为 word2[j]，接着比较 word1[i+1] 和 word[j+1] 即可。

### 代码

>```java
>public class minDistance {
>
>    public static int minDistance(String word1,String word2){
>        int m = word1.length();
>        int n =word2.length();
>        int[][] dp = new int[m+1][n+1];
>
>        //base
>        for(int i=0;i<=m;i++){
>            dp[i][0] =i;
>         }
>        for(int j=0;j<=n;j++){
>            dp[0][j] = j;
>        }
>
>        for(int i=0;i<m;i++){
>            for(int j=0;j<n;j++){
>              //如果相等，直接比较下一个
>                if(word1.charAt(i)==word2.charAt(j)){
>                    dp[i+1][j+1] = dp[i][j];
>                }else{
>                  // 尝试三种操作
>                    int add = dp[i][j+1]; //添加word[j]
>                    int delete = dp[i+1][j]; // 删除word[i]
>                    int rep = dp[i][j]; //替代
>                    dp[i+1][j+1] = Math.min(Math.min(add,delete),rep)+1;
>                }
>            }
>        }
>
>        return dp[m][n];
>
>    }
>
>    public static void main(String[] args) {
>        String word1 = "horse";
>        String word2 = "ros";
>        System.out.println(minDistance(word1,word2));
>    }
>}
>```











