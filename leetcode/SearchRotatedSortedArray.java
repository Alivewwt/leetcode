/*(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
查找一个指定的target
*/
class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
          //右边有序
           else if(nums[mid]<nums[r])
           {
                if(nums[mid]<target&&nums[r]>=target)
                    l=mid+1;
               else
                   r=mid-1;
           }
           //左边有序
            else{
                if(nums[mid]>target&&nums[l]<=target)
                   r=mid-1;
                else
                   l=mid+1;
            }
        }
        return -1;
    }
}