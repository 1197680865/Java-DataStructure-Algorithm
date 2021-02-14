package niuke;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 输入：1,{1,2,3,4,5} 返回5
 * 思想：法1 快慢指针法，时间复杂度为O（n），空间复杂度为O（1）
 * 法2 遍历获取长度+遍历定位，时间复杂度为O（2n）
 */
public class JZ14_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        //方法1 快慢指针法，时间复杂度为O（n），空间复杂度为O（1）
        int tmpK = 0;
        ListNode secondHead = head;
        while(head!=null){
            head = head.next;
            if(tmpK == k){
                secondHead = secondHead.next;
            }
            if(tmpK<k){
                tmpK++;
            }
        }
        //注意边界条件： k大于数组的长度
        if(tmpK<k) return null;
        return secondHead;

        //方法2 遍历获取长度+遍历定位
        //方法3 反转链表+遍历定位
    }
}
