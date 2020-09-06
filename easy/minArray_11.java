package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/7/25 12:36 下午
 * 旋转数组里的最小数
 * [3,4,5,1,2] return 1
 **/
public class minArray_11 {
    public int minArray(int[] numbers) {
        if(numbers.length==0||numbers==null)
            return -1;
        int l = 0,r = numbers.length-1;
        while(l<r){
            //中间数
            int mid = l+(r-l)/2;
            //最小值右侧元素
            if(numbers[mid]<numbers[r]){
                r = mid;
            }
            else if(numbers[mid]>numbers[r]){
                l = mid+1;
            }else{
              //  只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                r-=1;
            }

        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int numbers[] = new int[]{3,4,5,1,2};
        System.out.println(new minArray_11().minArray(numbers));
    }
}
