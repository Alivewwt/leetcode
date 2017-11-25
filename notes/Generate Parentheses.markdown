### 题目描述

给定一个非负整数$n$，生成$n$对括号的所有合法排列。

举例:

n=3

```tex
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

### 思路

该问题的解的个数就是卡特兰数，但是现在不是求个数，而是要将所有的合法的括号排列打印出来。

这道题和买票找零问题一样，通过买票找零问题我们可以知道，针对一个长度为$2n$的合法排列，第1到$2n$个位置都满足如下规则：左括号的个数大于右括号的个数。所有可以按照这个规则去打印括号:假设在位置k我们还剩下left个左括号和right个右括号，如果left>0，则我们可以直接打印左括号，而不违背规则。能否打印右括号，我们还必须验证left和right的值是否满足规则，如果left>right，则我们不能打印右括号，因为打印会违背合法排列的规则，否则可以打印右括号。如果left和right均为零，则说明我们已经完成一个合法排列，可以将其打印出来。

### 代码

```java
 public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        String str="";
        generateoneByone(list,str,n,n);
        return list;
    }
    
    public void generateoneByone(List<String> list,String str,int left,int right){
        if(left>right)
            return ;
        if(left>0)
            generateoneByone(list,str+'(',left-1,right);
        if(right>0)
            generateoneByone(list,str+')',left,right-1);
        if(left==0&&right==0){
              list.add(str);
            return;
        }
          
    }
```

