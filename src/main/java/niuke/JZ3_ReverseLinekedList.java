package niuke;
import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 思路：1.使用栈完成链表倒序  2.递归倒序
 * 3. 使用三个中间节点完成倒序：初始化三个指针prev为NULL，curr为head，next为NULL。
 */
public class JZ3_ReverseLinekedList {
    ArrayList<Integer> resList2 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //方法1 借助栈实现链表倒序
        /*
        Stack<ListNode> stack = new Stack();
        int size = 0;
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
            size++;
        }
        ArrayList<Integer> resList = new ArrayList<>(size);
        while(!stack.isEmpty()){
            resList.add(stack.pop().val);
        }
        return resList;
        */
        //方法2 递归
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            resList2.add(listNode.val);
        }
        return resList2;
    }
}

   class ListNode {
       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }
   }

