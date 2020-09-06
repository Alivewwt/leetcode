package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/4/30 10:41 下午
 **/
public class isHappy_202 {
    public boolean isHappy(int n) {

        int slow = n,fast = Sum(n);
        while(slow!=fast){
            slow = Sum(slow);
            fast = Sum(Sum(fast));

        }
        return slow==1;

    }

    public int Sum(int n){
        int sum = 0;
        while(n!=0){
            int a = n%10;
            sum+=a*a;
            n = n/10;
        }
        return sum;
    }

}
