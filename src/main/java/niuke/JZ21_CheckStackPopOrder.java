package niuke;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * s输入：[1,2,3,4,5],[4,3,5,1,2]  返回：false
 * 注意：压栈和出栈不是顺序进行的，在压栈过程中也可以出栈
 * 思路：模拟法： 使用栈模拟，从pushA取元素压栈，同时检查栈顶元素与popA[i]是否相等，若相等则模拟出栈
 * 最后，如果栈是空的，则说明弹出序列是正确的
 */
public class JZ21_CheckStackPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //压栈和出栈不是顺序进行的，在压栈过程中也可以出栈
        //当栈顶元素和popA[i]相等时，即出栈
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int item : pushA){
            stack.push(item);
            //不止一次判断
            //peek() 返回栈顶元素值，但不会弹出元素
            while(!stack.isEmpty() &&  stack.peek() == popA[i]){
                stack.pop();
                i++;
            }
        }
        //如果栈为空了，则说明弹出序列是正确的
        return stack.isEmpty();
    }
}
