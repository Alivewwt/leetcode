### 题目描述

给定一个字符串，找出字符串中的不重复长字符串的长度。

举例:

'abcabcbb',最长不重复字符串是'abc'，长度是3.

### 基本思路：

基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。同样是维护一个HashMap,正常情况下，如果没有出现重复则继续移动右窗口，如果发现重复字符，则说明当前窗口的串已经不满足要求，继续移动窗口不可能得到更好的结果，此时移动左窗口，知道不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为它们不是重复就是更短。所以两个窗口对每个元素的访问不超过一遍，因此时间复杂度为$O(2*n)=O(n)$.

### 代码：

```java
 public int lengthOfLongestSubstring(String s) {
       if(s==null||s.length()==0||s.length()==1)
			return s.length();		
		char[] ch=s.toCharArray();
		int len=ch.length;
		int maxLength=1;
		String sb=String.valueOf(ch[0]);
		for(int i=1;i<len;i++){	
				if(!sb.contains(String.valueOf(ch[i]))){
					sb+=String.valueOf(ch[i]);					
				}					
				else
		     //如果包含
				{
					maxLength=Math.max(maxLength,sb.length());
					sb=sb.substring(sb.indexOf(ch[i])+1)+String.valueOf(ch[i]);
				}
	}
			maxLength=Math.max(maxLength,sb.length());
        return maxLength;
    }
```

