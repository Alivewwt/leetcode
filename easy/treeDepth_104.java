package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-01-12
 * 求一棵树的高度，分别递归求左右两个子树的高度
 **/
public class treeDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}
