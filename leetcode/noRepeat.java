package project.leetcode;

public class noRepeat {
	public  int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s.length();

		char[] ch = s.toCharArray();
		int len = ch.length;
		int maxLength = 1;
		String sb = String.valueOf(ch[0]);
		for (int i = 1; i < len; i++) {
			if (!sb.contains(String.valueOf(ch[i]))) {
				sb += String.valueOf(ch[i]);
			} else
			// 如果字符串重复出现
			{
				if (maxLength < sb.length()) {
					maxLength = sb.length();
			   }
				// 从第一次出现ch[i]的位置+1截取
				sb = sb.substring(sb.indexOf(ch[i]) + 1) + String.valueOf(ch[i]);
			}
		}
		if (maxLength < sb.length()) {
			maxLength = sb.length();
		}
		return maxLength;
	}
	
}
