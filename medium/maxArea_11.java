package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/18 7:24 下午
 * 盛最多水的容器 双指针法
 **/
public class maxArea_11 {
    public int maxArea(int[] height) {
        if(height.length<=1)
            return 0;
        int maxArea =0;
        int left =0;
        int right = height.length-1;
        while(left<right){
            if(height[left]<=height[right]){
                maxArea = Math.max(maxArea,height[left]*(right-left));
                left++;
            }else{
                maxArea = Math.max(maxArea,height[right]*(right-left));
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new maxArea_11().maxArea(height));
    }
}
