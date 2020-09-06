package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/5/26 10:18 下午
 * 最长回文子串
 **/
public class longestPalindrome_5 {
    int low = 0,max =0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length()-1;i++){
            Palindrome(s,i,i);
            Palindrome(s,i,i+1);
        }
        return s.substring(low,low+max);
    }
    public void Palindrome(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(max<j-i-1){
            low = i+1;
            max = j-i-1;
        }
    }

    public static void main(String[] args) {
        String s ="babad";
        System.out.println(new longestPalindrome_5().longestPalindrome(s));
    }
}
