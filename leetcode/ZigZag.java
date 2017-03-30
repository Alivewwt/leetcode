package project.leetcode;

/**
 * 
 * @author wwt
 *给定一个字符串"PAYPALISHIRING",指定打印行数numRows，按'z'型打印，如下所示
 *		P   A   H   N
		A P L S I I G
		Y   I   R
		
		解题思路：利用一个多维数组存储字符，第一个for循环是存储垂直列的字符，第二个for循环存储斜线方向的字符
		通过观察，我们发现：每两个垂直列的间隔为numRows-2
 */
public class ZigZag {
   public static String convert(String s, int numRows) {
	   if(s==null||s.length()==0||s.length()==1)
           return s;
       char ch[]=s.toCharArray();
       int len=s.length();
       StringBuffer sb[]=new StringBuffer[numRows];
       for(int i=0;i<sb.length;i++)
           sb[i]=new StringBuffer();
       int i=0;
       while(i<len){
           for(int idx=0;idx<numRows&&i<len;idx++)
               sb[idx].append(ch[i++]);
           for(int idx=numRows-2;idx>0&&i<len;idx--)
               sb[idx].append(ch[i++]);
       }
       for(int idx=1;idx<sb.length;idx++)
           sb[0].append(sb[idx]);
       return sb[0].toString();
	    }
   
  
}
