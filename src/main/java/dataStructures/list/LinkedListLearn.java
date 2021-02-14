package dataStructures.list;

import java.util.Stack;

public class LinkedListLearn {


    public static void main(String[] args) {
        //单链表初始化
        int[] arr = {2, 9, 8, 6, 4};
        SingleTLinkedList linkedList = new SingleTLinkedList();
        for (int data : arr) {
            linkedList.addTNode(new TNode(data));
        }
        System.out.println(linkedList);
//        linkedList.reverseLinkedList();
//        System.out.println(linkedList);
        TNode head = linkedList.getHead();
        TNode res = SingleTLinkedList.reverseLinkedList(head);
        res.print();
    }
}

class TNode {
    public TNode next;
    public Integer data;

    public TNode(Integer data) {
        this.data = data;
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
        TNode tmp = this;
        while (true){
            sb.append(tmp.data).append(" ");
            tmp = tmp.next;
            if (tmp==null){
                break;
            }
        }
        System.out.println(sb.toString());
    }
}

class SingleTLinkedList {
    private TNode head = new TNode(null);

    public void addTNode(TNode tNode) {
        TNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = tNode;
    }
    public TNode getHead(){
        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        TNode tmp = head;
        while (tmp != null) {
            builder.append(tmp.data).append(" ");
            tmp = tmp.next;
        }
        return builder.toString();
    }

    /**
     * 使用 栈 实现列表反转
     */
    public void reverseLinkedList(){
        Stack<TNode> stack = new Stack<>();
        TNode tmp = head.next;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        TNode restmp = head;
        while (!stack.empty()){
            TNode pop = stack.pop();
            restmp.next = pop;
            restmp = restmp.next;
        }
        //反转后的最后一个元素 next应为空
        restmp.next = null;
    }

    /**
     * @param head 为第一个元素，而非空的头。区别于上一个反转方法
     * @return
     */
    public static TNode reverseLinkedList(TNode head){
        Stack<TNode> stack = new Stack<>();
        TNode tmp = head;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        if (stack.isEmpty()){
            return head;
        }
        TNode rhead = stack.pop();;
        TNode restmp =rhead;
        while (!stack.empty()){
            TNode pop = stack.pop();
            restmp.next = pop;
            restmp = restmp.next;
        }
        //反转后的最后一个元素 next应为空
        restmp.next = null;
        return rhead;
    }
}