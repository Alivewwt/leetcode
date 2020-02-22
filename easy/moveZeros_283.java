package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-01-27
 * 将数组中的0移到数组末尾位置，并且不改变数组的相对位置
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 **/
public class moveZeros_283 {
    public static  void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return ;
        int c =0;
        int j =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                c+=1;
            else
                nums[j++]=nums[i];

        }
        for(int i =nums.length-c;i<nums.length;i++)
            nums[i] = 0;

    }

    public static void main(String[] args) {
        int a[] ={0,1};
        moveZeroes(a);
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
