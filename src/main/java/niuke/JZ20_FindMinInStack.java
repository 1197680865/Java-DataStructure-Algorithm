package niuke;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：
 * 方法1：双栈法 空间换时间 时间复杂度O（1），空间复杂度O（n）。构建辅助栈，用于存放当前元素对应的最小值
 * 方法2： 单栈双存法，最小元素辅助信息也存放在原始栈中，push一次实际上是push两个元素，一个是实际node值，一个是最小值
 * 方法3： 栈压缩还原法，栈中存储与最小元素的差值，在引入一个新的变量最小值，每次push和pop时需要根据当前最小值和差值更新最小值
 */
public class JZ20_FindMinInStack {
    //双栈法 空间换时间 时间复杂度O（1），空间复杂度O（n）
    private Stack<Integer> mainStack = new Stack();
    private Stack<Integer> minStack = new Stack();
    int min = Integer.MAX_VALUE;
    int top = 0;
    public void push(int node) {
        if(mainStack.isEmpty()){
            mainStack.push(node);
            minStack.push(node);
            min = node;
            top =node;
        }else{
            mainStack.push(node);
            minStack.push(min);
            if(node<=min){
                min = node;
            }
        }

    }

    public void pop() {
        mainStack.pop();
        min =  minStack.pop();
    }

    public int top() {
        return top;
    }

    public int min() {
        return min;
    }
}
