package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/5 9:48 上午
 * string 字符转数字 "28"->28
 **/
public class myAtoi_8 {
    public int myAtoi(String str) {
        long res = 0;
        boolean digit = false;
        boolean plus = true;
        boolean sign = false;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!digit && !sign) continue;
                else break;
            } else if ('0' <= c && c <= '9') {
                res = res * 10 + c - '0';
                if (res > Integer.MAX_VALUE) { // check if out of range
                    if (plus) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                digit = true;
            } else if (c == '+' || c == '-') {
                if (digit || sign) break;
                sign = true;
                plus = c == '+' ? true : false;
            } else {
                break;
            }
        }
        // post processing
        if (!plus) res *= -1;
        return (int)res;
    }

    public static void main(String[] args) {
        String s = "words and 987";
        System.out.println(new myAtoi_8().myAtoi(s));
    }
}
