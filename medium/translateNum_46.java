package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/6/16 8:35 下午
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 **/
public class translateNum_46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a=1, b=1;
        for(int i=2;i<=s.length();i++){
            String src = s.substring(i-2,i);
            int c = src.compareTo("10")>=0 && src.compareTo("25")<=0?a+b: a;
            b=a;
            a=c;
        }
        return a;
    }
}
