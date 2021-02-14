package niuke;

import java.util.Stack;

/**
 *  用两个栈实现队列
 *  用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *  思路： 栈1负责存，栈2负责出，栈2弹出元素时判断如果栈2为空，则将栈1中的元素pop-push入栈2
 *  时间复杂度：push操作为O(1),pop操作为O(1)
 * 空间复杂度：需要stack来存，O(n)
 */
public class JZ5_QueueByTwoStack {
    public class Solution {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                //stack2 为空时，将stack1中的数据pop进stack2
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }

        }
    }
}
