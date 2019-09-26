package offer.Stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        mainStack.push(node);
        if (minStack.isEmpty()){
            minStack.push(node);
        }
        if(node<minStack.peek()){
            minStack.push(node);
        }
    }

    public void pop() {
        if (!minStack.isEmpty()&&minStack.peek()==mainStack.pop()){
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();

    }

    public int min() {
        return minStack.peek();
    }

}
