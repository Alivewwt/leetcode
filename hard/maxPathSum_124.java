package alogrithm.hard;

import alogrithm.easy.TreeNode;

/**
 * @author created by wuwt
 * @date 2020/6/21 9:56 上午
 * 二叉树中的最大路径和
 **/
public class maxPathSum_124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //中序遍历
        if(root==null)
            return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root==null)
            return 0;
        int leftmax = Math.max(0, dfs(root.left));//左孩子贡献
        int rightmax = Math.max(0, dfs(root.right));//右孩子贡献
        res = Math.max(res, root.val+leftmax+rightmax); //更新res
        return root.val+Math.max(leftmax,rightmax); //返回当前节点的总贡献

    }

    public static void main(String[] args) {
        maxPathSum_124 mp = new maxPathSum_124();
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        int a = mp.maxPathSum(root);
        System.out.println(a);
    }
}
