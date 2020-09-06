package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/5/17 3:58 下午
 **/
public class mySqrt_69 {
    //二分查找法
    public double mySqrt(int x) {
        double l=0,r=x, res =-1;
        while(l<=r){
            double mid = l+(r-l)/2;
            if(mid*mid<=x){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }

        }
        return res;
    }
        //  牛顿法
        public double mySqrt_1(int x) {
           if (x==0)
               return x;
           double x0 = x,C =x;
            while(true){
                 double xi = 0.5*(x0+C/x0);
                 if(Math.abs(x0-xi)<1e-7)
                     break;
                 x0 = xi;
            }
            return x0;
        }

    //  牛顿法
    public double mySqrt_2(int x) {
        if (x==0)
            return x;
        double res = x;
        while(true){
            if(res-x/res<1e-7)
                break;
            res = 0.5*(res+x/res);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new mySqrt_69().mySqrt_2(8));
        System.out.println(new mySqrt_69().mySqrt_1(8));
    }
}
