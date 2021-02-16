package niuke;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 翻转单词顺序列
 * 输入:"nowcoder. a am I"  返回值:"I am a nowcoder."
 * 思路： 栈 先进后出
 */
public class JZ44_ReverseSentence {
    //栈的使用先进后出
    public String ReverseSentence(String str) {
        if(str==null || "".equals(str) ) return str;
        String[] split = str.split(" ");
        //考虑是多个空格的情况
        if(split.length==0) return str;
        Stack<String> stack = new Stack<>();
        //入栈
        for(String s: split){
            stack.push(s);
        }
        //出栈
        StringBuilder b = new StringBuilder();
        while(!stack.isEmpty()){
            b.append(stack.pop()).append(" ");
        }
        String ans = b.toString();
        if(ans.length()>1){
            ans = ans.substring(0,ans.length()-1);
        }
        return ans;
    }
}
