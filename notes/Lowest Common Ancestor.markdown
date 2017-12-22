### 问题

给定一个二叉树，找到树中给定两个节点的公共祖先(LCA)。如下图所示

>```tex
>     _______3______
>       /              \
>    ___5__          ___1__
>   /      \        /      \
>   6      _2       0       8
>         /  \
>         7   4
>```

节点1和5的最低公共祖先是3,5和4的最低公共祖先是5。

### 思路

我们可以用深度优先遍历，从叶子节点向上，标记子树中出现目标节点的情况。如果子树中有目标节点，标记该目标节点，如果没有，标记为null。显然，如果左子树、右子树都有标记，说明就已经找到最小公共祖先了。如果在根节点为p的左右子树中找p、q的公共祖先，则必定是p 本身。

换个角度，可以这么想：如果一个节点左子树有两个目标节点中的一个，右子树没有，那么这个节点肯定不是最小公共祖先。如果一个节点右子树有两个目标节点中的一个，左子树没有，那这个节点肯定也不是最小公共祖先，只有一个节点正好左子树有，右子树也有的时候，才是最小公共祖先。

### 代码

```java
class Solution {
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
```

