package project.leetcode;

/*
* 题目：https://leetcode.com/problems/longest-common-prefix/description/
*给若干个字符串数组，找出最长公共字符串
*首先我们假设第一个是公共字符串，让它和后面的每个字符串去比，
*若出现不同字符，则比较停止，记录停止的位置，最后截取第一个字符串。
*/

public class longestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs==null||strs.length==0)
			return "";
		int len=strs.length;
		String str="";
		boolean flag=false;
		for(int i=0;i<strs[0].length();i++){
			char ch=strs[0].charAt(i);
			str+=ch;
			for(int j=1;j<len;j++){
				if(strs[j].length()==0)
					return "";
				else{
					if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
					{
							flag=true;
							break;	
					}
				}
			}
			//跳出第一层循环
			if(flag==true){
				str=str.substring(0,i);
				return str;
			}
		}
		return str;
		/*
		String str=strs[0];		
		for(int i=1;i<len;i++){
			int j=0;
			while(j<strs[i].length()&&j<str.length()&&str.charAt(j)==strs[i].charAt(j))
					j++;
			if(j==0)
				return "";	
			str=str.substring(0,j);
		}
		return str;
		*/
    }
	
}
