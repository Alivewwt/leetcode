package alogrithm.hard;

/**
 * @author created by wuwt
 * @date 2020/4/24 10:13 下午
 * 统计数组中的逆序个数
 **/
public class reversePairs_51 {
    int res =0 ;

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return res;
    }

    public void merge(int[] nums,int start,int end){
        if(start>=end)
            return ;
        int mid = (start+end)/2;
//        int count = merge(nums,start,mid)+merge(nums,mid+1,end);
        merge(nums,start,mid);
        merge(nums,mid+1,end);

        int l=start,r=mid+1,cur=0;
        int[] temp = new int[end-start+1];

        while(l<=mid&&r<=end){
            if(nums[l]<=nums[r]){
                temp[cur]=nums[l++];
                res+=r-(mid+1);
              }else{
                temp[cur] = nums[r++];
             }
            cur++;
            }
        while(l<=mid){
            temp[cur++] =nums[l++];
            res+=r-(mid+1);
         }
        while(r<=end){
            temp[cur++]=nums[r++];
        }
        // 复制回原数组
        for(int i=0;i<temp.length;i++){
            nums[i+start] =temp[i];
         }
        }

    public static void main(String[] args) {
        int nums[] = {7,5,6,4};
        System.out.println(new reversePairs_51().reversePairs(nums));
    }
}
