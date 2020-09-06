package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/19 9:17 下午
 * 最长不重复子串
 **/
public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        char[] chars = s.toCharArray();
        String  sb  = String.valueOf(s.charAt(0));
        int maxlen = 1;
        for(int i=1;i<chars.length;i++){
            int idx = sb.indexOf(String.valueOf(chars[i]));
            // 不在当前字符串中
            if(idx==-1){
                sb+=String.valueOf(chars[i]);

            }else{
                maxlen = Math.max(sb.length(),maxlen);
                sb = sb.substring(idx+1)+ chars[i];
            }
        }

        return Math.max(maxlen,sb.length());
    }

    public static void main(String[] args) {
        String s = "dedg";
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring(s));
    }
}
