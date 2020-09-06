package alogrithm.easy;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Stack;

/**
 * @author created by wuwt
 * @date 2020/5/12 9:41 下午
 * 最小栈
 **/
public class MinStack_155 {
    /** initialize your data structure here. */
    private Stack<Integer> minStack ;
    private Stack<Integer> dataStack;
    public MinStack_155() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int x) {
        //先将数据压入数据栈
        dataStack.push(x);
        if(minStack.isEmpty()||x<minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        //先删除数据栈的元素
        int x =dataStack.pop();
        if(x== minStack.peek())
            minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
