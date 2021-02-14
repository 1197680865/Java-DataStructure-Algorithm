package niuke;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 考察点： 需要注意in-place，最后得到的结果要放入array中，要进行逐项替换，只替换引用是错误的
 */
public class JZ13_ReOddEvenArray {
    public void reOrderArray(int [] array) {
        List<Integer> oddList = new LinkedList<>();
        List<Integer> evenList = new LinkedList<>();
        for(int i:array){
            if(i%2==1) {
                oddList.add(i);
            }else{
                evenList.add(i);
            }
        }
        int oddsize = oddList.size();
        int tmpInd = 0;
        Iterator<Integer> oddItr = oddList.iterator();
        while(oddItr.hasNext()){
            array[tmpInd] = (int)oddItr.next();
            tmpInd++;
        }
        Iterator<Integer> evenItr = evenList.iterator();
        while(evenItr.hasNext()){
            array[tmpInd] = (int)evenItr.next();
            tmpInd++;
        }
    }
}
