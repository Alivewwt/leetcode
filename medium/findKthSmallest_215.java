package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/7/8 9:50 下午
 * 无序数组第k小的数
 **/
public class findKthSmallest_215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null|nums.length==0)
            return -1;
        int len = nums.length;
        int res = kthNum(nums, k-1, 0, len-1);
        return res;

    }

    public int kthNum(int[] nums, int k,int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[left];
        while(left<=right){
            while (left<=right&&nums[left]<pivot){
                left++;
            }
            while(left<=right&&nums[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        // 如果第 k 小在右侧，搜索右边的范围，否则搜索左侧。
        if(k<=right){
            kthNum(nums,k, start,right);
        }
        if(k>=left){
            kthNum(nums,k, left, end);
        }
        return nums[k];
    }
    public  void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        findKthSmallest_215 f = new findKthSmallest_215();
        System.out.println(f.findKthLargest(nums,2));
    }
}
