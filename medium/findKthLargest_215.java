package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/7/8 10:21 下午
 * 无序数组第k大元素
 **/
class Solution {
    public int findKthLargest_215(int[] nums, int k) {
        if(k<0 ||nums==null|| nums.length==0)
            return -1;
        int n = nums.length;
        int target = n-k;
        int left = 0,right=n-1;
        while(true){
            int index = KthLargest(nums,left, right);
            if(index == target)
                return nums[index];
            else if(index<target){
                left = index+1;

            }else{
                right = index -1;
            }
        }

    }

    private int KthLargest(int[] nums, int left, int right) {

        int j = left;//记录基准元素的位置
        int pivot = nums[left];
        for(int i=left+1;i<=right;i++){
            //移动比基准元素小的数到前面去
            if(nums[i]<pivot){
                j++;
                swap(nums,j,i);

            }
        }
        //基准元素放到该放的位置上
        swap(nums,j,left);
        return j;
    }

    public  void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}