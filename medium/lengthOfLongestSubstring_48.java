package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/8/27 10:08 下午
 * 最长公共子串
 **/
public class lengthOfLongestSubstring_48 {
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        String res= "";
        int max=1;
        for(int i=0;i<n;i++){
            String a = String.valueOf(s.charAt(i));
            if(res.contains(a)){
                int len = res.length();
                max = Math.max(max,len);
                res = res.substring(res.indexOf(a)+1,len);
                res+=a;

            }
            else{
                res+=a;
            }
        }
         return Math.max(res.length(),max);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(lengthOfLongestSubstring_48.lengthOfLongestSubstring(s));
    }
}
