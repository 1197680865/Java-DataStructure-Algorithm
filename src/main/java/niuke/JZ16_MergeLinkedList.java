package niuke;

/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 输入
 * {1,3,5},{2,4,6}
 * 返回值
 * {1,2,3,4,5,6}
 *
 * 思路：遍历链表1 的同时，判断1的元素和链表2中元素的大小。注意更新节点
 */
public class JZ16_MergeLinkedList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2 == null) return list1;

        ListNode res = new ListNode(0);
        ListNode rHead = res;
        //注意：  有链表的地方，要考虑是用while还是if，尤其是遍历list2时
        while(list1!=null){
            if(list2!=null){
                if(list1.val<=list2.val){
                    res.next = list1;
                    list1 = list1.next;
                }else{
                    res.next = list2;
                    list2 = list2.next;

                }
                //注意更新结果的链表
                res = res.next;
            }else{
                //list2 已经遍历完成了，只剩下list1
                res.next = list1;
                list1 = list1.next;
                //注意更新结果的链表
                res = res.next;
            }
        }
        //list1 遍历完成了，可能list2没有遍历完，只剩下list2
        while(list2!=null){
            res.next = list2;
            list2= list2.next;
            //注意更新结果的链表
            res =res.next;
        }
        return rHead.next;
    }
}
