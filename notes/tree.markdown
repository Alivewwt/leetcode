## 1.二叉树的前序遍历

### 题目描述

给定一个二叉树，返回它的前序遍历。

### 题目解析

用栈的思路来处理问题

前序遍历的顺序为根-左-右，具体算法为：

+ 把根节点入栈中
+ 循环检测栈是否为空，若不空，则取出栈顶元素，保存其值
+ 看右节点是否存在，若存在则入栈中
+ 看左子节点，若存在，则入栈中

### 代码实现

~~~java
class solution{
public List<Integer> preorderTraverse(TreeNode root){
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> list = new LinkedList<>();
	if(root==null){
	return list;
}
//第一步将根节点压入栈中
	stack.push(root);
//当栈不为空时，出栈的元素插入list尾部。
	while(!stack.isEmpty()){
		root = stack.pop();
		list.add(root.val);
		if(root.right!=null) stack.push(root.right);
		if(root.left!=null) stack.push(root.left);
	}
return list;	
}
}
~~~

## 2.二叉树的中序遍历

### 题目描述

给定一个二叉树，返回它的中序遍历。

### 题目解析

用栈的思路来处理问题。

中序遍历的顺序为左-根-右，具体算法为：

+ 从根节点开始，先将根节点压入栈
+ 然后在将其所有左子节点压入栈，取出栈顶点，保存节点值
+ 再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子节点压入栈中

### 代码实现

~~~java
class solution{
public List<integer> inorderTraversal(TreeNode root){
	List<Integer> list = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
	TreeNode cur = root;
	while(cur!=null){
		if(cur!=null){
		stack.push(cur);
		cur = cur.left;
		}else{
			cur = stack.pop();
		  list.add(cur.val);
			cur = cur.right;
		}
	}
return list;ß
}
}
~~~



## 3.二叉树的后序遍历

### 题目描述

给定一个二叉树，返回它的后序遍历。

### 题目解析

用栈的思路来处理问题。

后序遍历的顺序为左-右-根，具体算法为：

+ 先将根节点压入栈，然后定义一个辅助结构head
+ while循环的条件是栈不为空
+ 在循环中，首先将栈顶节点t取出来
+ 如果栈顶点没有左右子节点，或者其左子节点是head,或者其右子节点是heda的情况下。我们将栈节点值加入res中，并将其栈顶元素移出栈，然后将head指向栈顶元素
+ 否则的话就看如果右子节点不为空，将其加入栈
+ 再看左子节点不为空的话，就加入栈

### 代码实现

~~~java
public class solution{
	public List<Integer> postOrderTraversal(TreeNode root){
	List<Integer> res = new ArrayList<Integer>();
	if(root==null)
		return res;

	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);
	while(!stack.isEmpty()){
		TreeNode node = stack.pop();
		if(node.left!=null) stack.push(node.left);//和传统先序遍历不一样，先将左节点入栈
		if(node.right!=null) stack.push(node.right);//后将右节点入栈
		res.add(0,node.val);//逆序添加节点值
	}
	return res;
}

}
~~~



## 4.二叉树的层次遍历

### 题目描述

给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。

例如：给定二叉树[3，9，20，null，null，15，7]

>```text
>    3
>   / \
>  9  20
>    /  \
>   15   7
>```

返回层次遍历结果

>```text
>[
>  [3],
>  [9,20],
>  [15,7]
>]
>```

### 题目解析

该问题需要用到队列

+ 建立一个queue
+ 先把根节点放进去，这时候找根节点的左右两个字节点
+ 去掉根节点，此时queue里的元素就是下一层的所有节点
+ 用for循环遍历，将结果存到一个一维向量里
+ 遍历完之后再把这个一维向量存到二维向量里
+ 以此类推，可以完成层序遍历

### 代码实现

>```java
>public List<List<Integer>> levelOrder(TreeNode root) {
>    if(root == null)
>        return new ArrayList<>();
>    List<List<Integer>> res = new ArrayList<>();
>    Queue<TreeNode> queue = new LinkedList<TreeNode>();
>    queue.add(root);
>    while(!queue.isEmpty()){
>        int count = queue.size();
>        List<Integer> list = new ArrayList<Integer>();
>        while(count > 0){
>            TreeNode node = queue.poll();
>            list.add(node.val);
>            if(node.left != null)
>                queue.add(node.left);
>            if(node.right != null)
>                queue.add(node.right);
>            count--;
>        }
>        res.add(list);
>    }
>    return res;
>}
>```

## 5.平衡二叉树

### 题目描述

给定一个二叉树，判断它是否是高度平衡的二叉树

### 题目解析

采取后序遍历的方式遍历二叉树的每一个节点。

在遍历到一个节点之前已经遍历了它的左右子树，那么只要在遍历每个节点的时候记录它的深度（某一节点的深度等于它到叶节点的路径的长度），就可以一边遍历一边判断每个节点是不是平衡的。

### 代码实现

~~~java
class one {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
      public int getDepth(TreeNode root) {
      if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
      }
}

class two{
    public boolean isBalanced(TreeNode root) {
        int res = Depth(root);
        return res==-1?false:true;
    }
  	public int Depth(TreeNode root) {
   	 if(root==null)
      	return 0;
      int left = Depth(root.left);
      if(left==-1)
        return -1;
      int right = Depth(root.right);
      if(right==-1)
        return -1;
      if(Math.abs(left-right)>1)
        return -1;
      reutrn Math.max(left,right)+1;
}
~~~

## 6.对称二叉树

### 题目描述

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树[1,2,2,3,4,4,3]是对称的。

```text
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

### 题目解析

用递归做比较简单：一棵树是对称的等价于它的左子树和右子树两棵树是对称的，问题就转变判断两棵树是否对称。

### 代码实现

~~~java
class soulution{
  public boolean isSymmetric(TreeNode root){
    if(root==null)
      return true;
    //把问题变成判断两棵树是否是对称的
    return isSym(root.left,root.right);
  }
  
  //判断的是根节点为r1和r2的两棵树是否是对称的
  public boolean isSym(TreeNode r1,TreeNode r2){
			if(r1==null && r2==null) return true;
    	if(r1==null|| r2==null) return false;
    	//满足的条件
    	//俩根节点相等，树1的左子树和树2的右子树相等，树2左子树和树 1的右子树都是相等的
    return r1.val==r2.val&&isSym(r1.left,r2.right)&&(r1.right,r2.left);
  }
}
~~~

## 8.重建二叉树

### 题目描述

根据二叉树的前序和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果都不含重复的数字。

> preorder = [3,9,20,15,7]
>
> inorder= [9,3,15,20,7]

### 题目解析

前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树的中序遍历结果。

### 代码实现

~~~java
class soultion{
	// 缓存中序遍历数组每个值对应的索引
private Map<Integer, Integer> indexForInOrders = new HashMap<>();
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    for (int i = 0; i < in.length; i++)
        indexForInOrders.put(in[i], i);
    return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
}
  private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
    if (preL > preR)
        return null;
    TreeNode root = new TreeNode(pre[preL]);
    int inIndex = indexForInOrders.get(root.val);
    int leftTreeSize = inIndex - inL;
    root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
    root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
    return root;
}

}
~~~































