### 题目描述

判断一棵树是否为另一棵树的子树。

举例:

``` java
树s
     3
    / \
   4   5        
  / \
 1   2
    /
   0
```

```
 树t
   4
  / \
 1   2    t不是s的子树
```

### 思路

首先判断树s和树t的根节点是否相等，若不相等，若递归判断s的左节点和右节点是否和t相等。

### 代码

```java
public class Solution {
	public boolean isSubTree (TreeNode s, TreeNode t) {
		if(s==null)
			return false;
		if(isSame(s,t))
			return true;
		return isSubTree(s.left,t)&&isSubTree(s.right,t);
	}
	
	public boolean isSame(TreeNode p,TreeNode t){
      if(p==null&&t==null)
      	return true;
      if(p==null||t=null)
      	return false;
      if(p.val!=t.val)
      	return false;
      return isSame(p.left,t.left)&&isSame(p.right,t.right);
	}
}
```
