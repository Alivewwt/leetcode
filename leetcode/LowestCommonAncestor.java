class LowestCommonAncestor{
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      //发现目标节点，则通过返回值标记该孩子树发现了某个目标节点
        if(root==null || root ==p|| root==q)
            return root;
      //查看左子树是否有目标节点，没有为null
        TreeNode left=lowestCommonAncestor(root.left,p,q);
      //查看右子树是否有目标节点，没有为null
        TreeNode right=lowestCommonAncestor(root.right,p,q);
      //都不为空，说明左右子树都有目标节点，则公共祖先就是本身
        if(left!=null && right!=null)
            return root;
      //如果发现了目标节点，则继续向上标记为该目标节点
        return left!=null?left:right;
    }
}