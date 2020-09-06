package alogrithm.easy;

import java.util.ArrayList;

/**
 * @author created by wuwt
 * @date 2020/3/30 9:49 下午
 * n个数中，删除第m个数，最后留下的数  f(n-1,m) = (m%n+x)%n=(m+x)%n
 **/
public class lastRemaining_62 {
    public int lastRemaining(int n, int m) {
//        if(n==1)
//            return 0;
//        int x = lastRemaining(n-1,m);
//        return (m+x)%n;

        //模拟法
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int index =0 ;
        while(n>1){
            //每次要删除数的位置
            index = (index+m-1)%n;
            list.remove(index);
            n--;
        }
        return  list.get(0);
    }

    public static void main(String[] args) {

        System.out.println(new lastRemaining_62().lastRemaining(5,3));
    }
}
