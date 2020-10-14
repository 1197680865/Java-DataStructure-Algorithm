package dataStructures.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<ListNode> list = new ArrayList<>();
        int[] arr = {5,2,9,3,1};
        for(int i:arr){
            list.add(new ListNode(i));
        }
        Collections.sort(list);
        System.out.println(list);
    }
}

class ListNode implements Comparable<ListNode> {
    int value;
    public int compareTo(ListNode o) {
        return value - o.value;
    }
    public ListNode(int v){
        value = v;
    }
    public String toString(){
        return value+"";
    }
}