package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/7/4 10:36 下午
 * 有序数组转换为二叉搜索树,树不唯一
 **/
public class sortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int nums[], int left, int right){
        if(left>right)
            return null;
        // 不断以中间节点为根结点
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left,mid-1);
        root.right = helper(nums, mid+1, right );
        return root;
    }

}

