package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/3/31 8:26 下午
 **/
public class ArraySort_912 {
    public int[] arraySort(int[] nums){
        if(nums==null||nums.length==1)
            return nums;
      //选择
       selectSort(nums);
       //冒泡
       bubbleSort(nums);
        //快速
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public int[] selectSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            //记录当前比较位置
            int index = i;
            for(int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[index]){
                    index = j;
                }
            }
            if(index!=i){
                swap(nums,index,i);
            }
        }
        return nums;
    }
    public int[] bubbleSort(int[] nums){
        // 冒泡排序 升序排序，大的数往后沉 两两比较
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return  nums;
    }

    public void quickSort(int[] nums, int low,int high){
        if(low<high){
            int index = getIndex(nums,low,high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(nums,0,index-1);
            quickSort(nums,index+1,high);
        }
    }

    public int getIndex(int[] nums,int low, int high){
        //基准值
        int tmp = nums[low];
        while(low<high){
            while(nums[high]>=tmp && low<high){
                high--;
            }
            //若队尾元素小于基准值，则交换
            nums[low] = nums[high];
            while(nums[low]<=tmp && low<high){
                low++;
            }
            nums[high] = nums[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        nums[low] = tmp;
        return low;
    }

    public  void swap(int[] nums,int i,int j){
        int index = nums[i];
        nums[i] = nums[j];
        nums[j] =  index;
    }
    //归并排序，分而治之的思想，将数组划成块，都有序了后进行归并
    public void merge(int[] nums,int left,int mid,int right){
        //复制数组
        int[] temp = new int[nums.length];
        int p1 =left,p2=mid+1,k= left;
        while (p1<=mid&&p2<=right){
            if(nums[p1]<=nums[p2])
                temp[k++] = nums[p1++];
            else
                temp[k++] = nums[p2++];

        }
        while(p1<=mid)
            temp[k++] = nums[p1++];
        while(p2<=right)
            temp[k++] = nums[p2++];
        //数组还原
        for(int i=left;i<=right;i++)
            nums[i] = temp[i];
    }
    //归并排序
    public void mergesort(int nums[],int start,int end){
        if(start<end){
            int mid = (start+end)/2;
            mergesort(nums,start,mid);//左边归并排序
            mergesort(nums,mid+1,end); //右边归并排序
            merge(nums,start,mid,end);//将两个有序数组合并操作
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,4,0};
//        int arr[] = new ArraySort_912().arraySort(nums);
        new ArraySort_912().quickSort(nums,0,nums.length-1);
        for(int i:nums)
            System.out.println(i);
    }
}
