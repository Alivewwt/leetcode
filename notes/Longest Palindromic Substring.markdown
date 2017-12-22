### 问题

给定一个字符串，找出其中最长的回文字符串。

如："babab"，最长回文字符串是"bab"，"aba"也是最长回文字符串。

"cbbd"，"bb"是最长回文字符串。

### 思路

1.动态规划:这里的动态规划思路是$dp[i][j]$表示的是从$i$到$j$的子串，是否是回文串。则根据回文的规则我们可以知道：如果$s[i]==s[j]$那么是否是回文决定于$dp[i+1][j-1]$，当$s[i]!=s[j]$的时候，$d[i][j]$直接是false。

动态规划的进行是按照字符串的长度从1到n推进的。

2.遍历字符串，每个位置要先以当前字母为中心，再以当前字母和它右边那个为中心。下面我们提供了思路2的代码。

### 代码

```java
public class Solution {
   public  int lo,max;
	public String longestPalindrome(String s) {
        if(s==null||s.length()<2)
        	return s;
       int len=s.length();
      for(int i=0;i<len-1;i++){
    	  extend(s,i,i);  //奇數
    	  extend(s,i,i+1);
      }
      return s.substring(lo,max+lo);
    }

	private void extend(String s, int i, int j) {
		// TODO Auto-generated method stub
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
		if(max<j-i-1){
			lo=i+1;
			max=j-i-1;
		}
     	}
    
}
```

