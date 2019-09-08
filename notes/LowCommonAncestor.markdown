### 题目描述

两个节点的公共祖先。

举例:

``` java
    _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
```

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.
```

### 思路

后序遍历，只有先访问给定的两个节点A,B，才能确定其最近公共父节点C，所以采用后续遍历

### 代码

```java
public class lowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null ||root==p ||root==q)
			return root;
		//当root非空时，对左子树和右子树分别进行搜索。
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		//若搜索结果均非空，说明两个节点分别位于左右子树中，LCA则为root
		if(left!=null && right!=null)
			return root;
		//若只有一个结果为空，则LCA是另一个非空的节点；若结果均空，则返回NULL
		return left!=null?left:right;
	}
}
```
