package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/6/21 10:11 上午
 * 验证回文串
 **/
public class isPalindrome_125 {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0||s.length()==1)
            return true;
        String ss= s.toLowerCase().replace(" ","");
        char[] chars = ss.toCharArray();
//        System.out.println(chars);
        //字符长度
        int len = chars.length;
        int i=0,j = len-1;
        while(i<=j){
            if(!ischarOrnum(chars[i]))
                i++;
            if(!ischarOrnum(chars[j]))
                j--;
            if(ischarOrnum(chars[i])&& ischarOrnum(chars[j])){
                if(chars[i]==chars[j]){
                    i++;
                    j--;
                }
                else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean ischarOrnum(char ch){
        if (ch>='a' && ch<='z' || ch>='0' &&ch<='9')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        isPalindrome_125 ip = new isPalindrome_125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(ip.isPalindrome(s));
    }
}
