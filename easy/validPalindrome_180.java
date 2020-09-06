package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/5/21 9:32 下午
 * 验证字符串是否为回文字符串 可删除一个字符
 **/
public class validPalindrome_180 {
    public boolean validPalindrome(String s) {
        int low =0,high = s.length()-1;
        while(low<high){
            if(s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else{
                boolean flag1=true,flag2=true;
                for(int i=low,j=high-1;i<j;i++,j--){
                    char c3=s.charAt(i),c4= s.charAt(j);
                    if(c3!=c4){
                        flag1=false;
                        break;
                    }
                }
                for(int i=low+1,j=high;i<j;i++,j--){
                    char c3=s.charAt(i),c4= s.charAt(j);
                    if(c3!=c4){
                        flag2=false;
                        break;
                    }
                }
                return flag1||flag2;
            }
        }
        return true;
    }
}
