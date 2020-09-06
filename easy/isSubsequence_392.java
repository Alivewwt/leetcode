package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/7/27 8:42 下午
 * 判断一个序列是否为另外一个序列的子序列
 **/
public class isSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0)
            return true;
        int s_len = s.length();
        int t_len = t.length();
        int i =0,j=0;
        while(i<s_len&&j<t_len){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }

            j++;
        }
        return i==s_len;
    }
}
