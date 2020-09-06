package alogrithm.medium;

import alogrithm.easy.TreeNode;

/**
 * @author created by wuwt
 * @date 2020/5/5 4:52 下午
 * 判断一棵树是否为有效二叉搜索树,当前节点是否大于中序遍历的前一个节点
 **/
public class isValidBST_98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        //访问左子树
        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val<=pre) {
            return false;
        }

        pre = root.val;
        //访问右子树
        return isValidBST(root.right);
    }
}
