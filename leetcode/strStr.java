
/*
* 题目:https://leetcode.com/problems/implement-strstr/description/
* 实现一个方法strStr()。
* 返回字符串needle第一次在字符串haystack出现的下标，如果needle不是haystack的一部分，就返回-1。
* 朴素字符串匹配算法，就是把2个字符串头部对齐，然后逐一字符匹配，失配后，把needle右移一位，继续从头匹配
*/

public class strStr{
	//暴力匹配，并非最优
	public int strStr(String haystack,String needle){
		
		if(haystack.length()==0&&needle.length()==0)
			return 0;
		if(needle.length()>haystack.length())
			return -1;
		char[] str=haystack.toCharArray();
		char[] Str=needle.toCharArray();//待匹配字符串	
		for(int i=0;i<str.length;i++){
			int j=0,index=i;
			for(;j<Str.length;){
				//如果不匹配，则跳出本次循环，str向右移位
				if(Str[j]!=str[index]){					
					break;
				}				
				else {
					index++;
					j++;
					if(index==str.length){
						break;
					}					
				}								
			}
			if(j==Str.length){
				return index-j;
			}			
		}
		
		return -1;
	}
}