package alogrithm.easy;

/**
 * @author created by wuwt
 * @date 2020/5/31 1:21 下午
 **/
public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return Symmetric(root.left,root.right);
    }
    public  boolean Symmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return  true;
        if(left==null||right==null)
            return false;
        if (left.val!=right.val)
            return false;
        return Symmetric(left.right,right.left)&&Symmetric(left.left,right.right);
    }
}
