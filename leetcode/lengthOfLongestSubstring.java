/*
 给定字符串中，找到不重复的最长字母串长度
*/
public class lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s){
			if(s==null ||s.length()==0||s.length()==1)
				return s.length();
			int len=s.length();
			int max=1;
			char[] ch=s.toCharArray();
			// 定义一个字符串
			String sb=String.valueOf(ch[0]);
			// 遍历字符数组
			for(int i=1;i<len;i++){
				if(!sb.contains(String.valueOf(ch[i]))){
					sb+=String.valueOf(ch[i]);
				}else{
					max=Math.max(sb.length(), max);
					sb=sb.substring(sb.indexOf(ch[i])+1)+String.valueOf(ch[i]);
				}
			}
			max=Math.max(sb.length(), max);
			return max;
		}
	}