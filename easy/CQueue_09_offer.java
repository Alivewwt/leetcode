package alogrithm.easy;

import java.util.LinkedList;

/**
 * @author created by wuwt
 * @date 2020/6/30 9:23 下午
 * 剑指offer
 * 使用两个栈实现队列
 **/
public class CQueue_09_offer {
    LinkedList<Integer> A,B;
    public CQueue_09_offer() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    // 插入队尾
    public void appendTail(int value) {
        A.addLast(value);
    }
    // 删除头部元素
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
