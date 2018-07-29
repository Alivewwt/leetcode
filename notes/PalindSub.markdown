### 题目描述

给定一个字符串，你的任务是计算在该字符串中有多少个回文字符串。

子串如果有不同的起始索引或者结束索引，那么便可以认为是不同的，即使他们包含着相同的字符。

### 思路

回文具有对称的性质，我们应该利用对称的性质

1. #### 回文串都有个对称轴

2. #### 当在回文串两端各加入两个相同的字符的时候，形成的新字符仍旧是回文串。

3. #### 我们可以从一个字符，或者两个相同字符开始，运用以上两个规律开始构造回文

### 代码

```java
class Solution {
    public int countSubstrings(String s) {
       if(s==null)
           return 0;
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            count+=extend(s,i,i);//奇数
            count+=extend(s.i,i+1);//偶数
        }
    }
    public int extend(String s,int i,int j){
        int i=0;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}
```

