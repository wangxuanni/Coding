package leetcode.stack;

import java.util.Stack;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-24 11:38
 **/

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        minstack.push(Integer.MAX_VALUE);


    }

    public void push(int x) {
        stack.push(x);
        if (x<=minstack.peek()){
            minstack.push(x);
        }

    }

    public void pop() {
        if (!minstack.isEmpty()&&stack.peek()==minstack.peek()){
            minstack.pop();
        }

        stack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minstack.peek();

    }
}
