/*
对一棵树中序遍历
定义一个队列，
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  result=new ArrayList<>();
       if(root==null)
       return result;
       Queue<TreeNode> queue=new LinkedList<TreeNode>();
       queue.offer(root);//将根节点入队
       while(!queue.isEmpty()){
           int size=queue.size();
           ArrayList<Integer> level=new ArrayList<Integer>();
           for(int i=0;i<size;i++){
               TreeNode head=queue.poll();//出队对头元素并访问。
               level.add(head.val);
               if(head.left!=null)
               queue.offer(head.left);
               if(head.right!=null)
               queue.offer(head.right);
           }
           
           result.add(level);
       }
       return result;
 }
}
