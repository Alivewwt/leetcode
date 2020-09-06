package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/3/28 10:42 上午
 * 返回组成卡牌的可能性
 **/
public class hasGroupsSizeX_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        // 当len小于2，直接返回false
        if (deck.length<2)
            return false;
        int []sum = new int[10000];
        //挨个遍历，统计个数
        for(int i:deck)
            sum[i]++;
        //求每个数的公约数
        int x =0;
        for(int temp:sum){
            if (temp>0){
                x = gcd(x,temp);
                if (x==1)
                    return false;
            }
        }
        return x>=2;
    }
    // 辗转相除法 求最大公约数
    public  int gcd(int a, int b){
        return b==0? a:gcd(b,a%b);
    }

}
