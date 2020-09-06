package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/27 10:52 下午
 * 在旋转数组里找数，二分法
 **/
public class search_33 {
    public int search(int[] nums, int target) {
        if(nums==null|nums.length==0)
            return -1;
        int start = 0,end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            //前半部分有序
            if(nums[start]<=nums[mid]){
                //target在前半部分
                if(nums[start]<=target&&target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;

                }
            }else{
                if(nums[mid]<target&&target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
