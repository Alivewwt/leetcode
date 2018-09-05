### 问题

这道题要求设计实现LRU cache的数据结构，实现set和get功能。cache作为缓存可以帮助快速存取数据，但是确定容量较小。这道题要求实现的cache类型是LRU，LRU的基本思想就是“最近用到的数据被重用的概率比较早用到的大的多”，是一种更加高效的cache类型。

### 思路

解决这道题的方法是**双向链表+HashMap**。

“为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们将双向链表连接到Cache的数据项，并且保证链表维持数据项从最近访问到最旧访问的顺序。每次数据项被查询到时，都将此数据项移动到链表头部(O(1)的时间复杂度)。这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，而没有被使用的内容就向链表的后面移动。当需要替换时，链表最后的位置就是最近最少被使用的数据项，我们只要将最新的数据项放在链表头部，当Cache满时，淘汰链表最后的位置就是”。

对于双向链表的使用，基于两个考虑

- 首先是Cache中块的命中可能是随机的，和Load进来的顺序无关。
- 其次，双向链表插入、删除很快，可以灵活的调整相互间的次序，时间复杂度为O(1)。

解决了LRU 的特性，现在考虑下时间复杂度。为了能减少整个数据结构的时间复杂度，就要减少查找的时间复杂度，所有这里利用HashMap来做，这样时间复杂度就是O(1)。

所以对本题来说：

get(key)：如果cache中不存在要get的值，返回-1；如果cache中存在要找的值，返回其值并将其在原链表中删除，然后将其作为头结点。

set(key,value)：当要set的key值已经存在，就更新其value，将其在原链表中删除，然后将其作为头结点；当要set的key 值不存在，就新建一个node，如果当前len<capacity，就将其加入hashmap中，并将其作为头结点，更新len长度，否则，删除链表最后一个node,再将其放入hashmap并作为头结点，但len不更新。

### 代码



```java
import java.util.HashMap;
class LRUCache{
    class Node{
        Node pre,next;
        int key;
        int val;
        public Node(int key,int vlaue){
            this.key=key;
            this.val=value;
	  }
    }
    private int capacity;
    private int num;
    private HashMap<Integer,Node> map;
    private Node first,last;
    public LRUCache(int capacity){
        this.capacity=capacity;
        num=0;
        first=null;
        last=null;
	}
    //获取元素
    public int get(int key){
		Node node=map.get(key);
        if(node==null)
            return -1;
        else if(node!=last){
			if(node==first)
                first=first.next;
            else
				node.pre.next=node.next;
            node.next.pre=node.pre;
            last.next=node;
            node.pre=last;
            node.next=null;
            last=node;
        }
        return node.val;
    }
    
    //放入元素
    public void put(int key,int value){
        Node node=map.get(key);
        if(node!=null){
            node.val=value;
            if(node!=last){
               if(node == first)  
                   first = first.next;  
               else  
                   node.pre.next = node.next;  
               node.next.pre = node.pre;  
               last.next = node;  
               node.pre = last;  
               node.next = null;  
               last = node;   
            }
        }
         else   
       {  
           Node newNode = new Node(key,value);  
 
           if(num>=capacity)  
           {  
               map.remove(first.key);  
               first = first.next;  
               if(first!=null)  
                   first.pre = null;  
               else  
                   last = null;  
               num--;      
           }  
           if(first == null || last == null)  
           {  
               first = newNode;  
           }  
           else  
           {  
               last.next = newNode;  
           }  
           newNode.pre = last;  
           last = newNode;  
           map.put(key,newNode);  
           num++;  
       }  
    }
}
```





















