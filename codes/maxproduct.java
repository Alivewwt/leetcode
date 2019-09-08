//维护一个局部最大和一个局部最小
class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null ||nums.length==0)
            return 0;
        int max=nums[0];
        int min_local=nums[0];
        int max_local=nums[0];
        for(int i=1;i<nums.length;i++){
            int max_copy=max_local;
            max_local=Math.max(Math.max(nums[i]*max_local, nums[i]), nums[i]*min_local);
            min_local=Math.min(Math.min(nums[i]*max_copy,nums[i]),nums[i]*min_local);
            max=Math.max(max,max_local);
        }
        return max;
    }
}