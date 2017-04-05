package project.leetcode;

//最长回文字符串 abccba
/*
 * 我们需要知道的只是中心对称的较小一层是否是回文。所以我们从小到大连续以某点为中心的所有字符串进行计算。
 * 外层循环遍历的是子字符串的中心点，内层循环是从中心扩散，一旦不是回文就不再计算其他以此为中心的较大的字符串。
 * 中心对称有两种情况，一是奇数个字母以某个字母对称，而是偶数个字母以两个字母中间为对称。
 */
public class longestPalindrome {
	public  int lo,max;
	public String longestPalindrome(String s) {
        if(s==null||s.length()<2)
        	return s;
       int len=s.length();
      for(int i=0;i<len-1;i++){
    	  extend(s,i,i);  //奇數
    	  extend(s,i,i+1);//偶數
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
