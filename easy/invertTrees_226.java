package algorithm.easy;

/**
 * @author wuwt
 * @date 2020-01-12
 * 将树所有的左右节点进行调换
 **/
public class invertTrees_226 {
    public TreeNode invertTree(TreeNode root){
        if(root==null)
            return root;
        //转换操作
        else{
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);


        }
        return root;
    }
}
