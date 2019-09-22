package algorithm;

/**
 * @author wuwt
 * @date 2019-09-22
 **/
// 先序遍历
public class mergeTrees {
    // 合并两个树，对应节点值相加
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode T = new TreeNode(0);
        if(t1==null && t2==null)
            return null;

        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        int val = 0;
        val = t1.val+t2.val;
        T.val =val;
        T.left = mergeTrees(t1.left,t2.left);
        T.right = mergeTrees(t1.right,t2.right);
        return T;
    }

}
