package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/21 9:28 下午
 * 统计连续数组含有k个奇数数组的个数
 **/
public class numberOfSubarrays_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left =0, right =0,oddCnt =0, res=0;
        while(right<nums.length){
            //右指针先走
            if((nums[right++]&1)==1)
                //遇到奇数加1
                oddCnt+=1;
            //若当前滑动窗口含k个奇数
            if(oddCnt==k){
                int temp =right;
                //右边偶数的个数
                while(right<nums.length&&(nums[right]&1)==0){
                    right++;

                }
                int rightEvent = right-temp;
                int leftEvent =0;
                //统计左边偶数的个数
                while((nums[left]&1)==0){
                    left++;
                    leftEvent++;
                }
                res +=(leftEvent+1)*(rightEvent+1);
                //当前位置是左边第一个奇数位置，left 右移一位
                left++;
                oddCnt--;
            }
        }
        return res;
    }

    public int numSubarrays(int nums[],int k){
        int oddCnt =0,n = nums.length;
        int res =0;
        int[] npos = new int[n+2];
        npos[0] = -1;
        for(int i=0;i<n;i++){
            if((nums[i]&1)==1)
                npos[++oddCnt] = i;
        }
        npos[++oddCnt] = n;
        //奇数的个数
        for(int i=1;i+k<oddCnt+1;i++){
            res+=(npos[i]-npos[i-1])*(npos[i+k]-npos[i+k-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] =new int[]{1,1,2,1,1};
        System.out.println(new numberOfSubarrays_1248().numSubarrays(nums,3));
    }
}
