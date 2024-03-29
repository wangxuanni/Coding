package offer.Stack;

import java.util.Stack;
/**
 * 用两个栈实现队列
 * @author keyu
 * @since 2022-02-05 22:45
 **/
public class TwoStackForQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            // while(stack1.peek()!=null){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }

    }
}
