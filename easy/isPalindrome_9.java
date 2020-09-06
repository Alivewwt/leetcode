package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/6/14 1:15 下午
 * 判断回文数
 **/
public class isPalindrome_9 {
    public boolean isPalindrome(int x) {
        int res = 0;
        int temp = x;
        while (temp>0){
            int tmp = temp%10;
            res = res*10+tmp;
            temp = temp/10;
        }
//        System.out.println(res);
        return res==x;
    }

    public static void main(String[] args) {
        boolean  x= new isPalindrome_9().isPalindrome(89);

    }
}
