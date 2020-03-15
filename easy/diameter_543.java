package algorithm.easy;

// 求一棵树任意一个节点的左右子树的深度之和，可以经过根结点，也可以不经过，需求最大值；

/**
 * @author wuwt
 * @date 2020-03-15
 **/
public class diameter_543 {
    int len = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        getHeight(root);
        return len;
    }
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        else{
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            len = Math.max(len,left+right);
            return 1+Math.max(left,right);//计算任意一个节点的最长路径值，在其中取出最大值即可
        }
    }

}
