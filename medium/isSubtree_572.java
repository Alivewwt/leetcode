package alogrithm.medium;

import alogrithm.easy.TreeNode;

/**
 * @author created by wuwt
 * @date 2020/5/7 9:14 下午
 **/
public class isSubtree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(t==null) return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSame(s,t);
    }
    //判断两棵树是否相等
    private boolean isSame(TreeNode s, TreeNode t) {
        if(s==null&&t==null) return true;
        if(s==null||t==null) return  false;
        if(s.val!=t.val) return false;
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}
