package niuke;

/**
 *  在旋转数组中寻找最小的元素
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *  输入：[3,4,5,1,2]
 *  输出： 1
 */
public class JZ6_FindIMinInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        //方法1 遍历
        /*
        if(array.length == 0){
            return 0;
        }
        int tmp =0;
        for(int i :array){
            if(tmp>i){
                return i;
            }else{
                tmp = i;
            }
        }
        return tmp;
        */

        //方法2 二分查找变体（重要）
        //mid：中位   traget 目标值：选择末位，比对array[mid] 与 array[traget]的大小，进而选择下一个区间
        //递归出口 or 循环出口： left>=right
        if(array.length == 0){
            return 0;
        }
        return minNumberInRotateArray(array,0,array.length-1);


    }
    //https://www.cnblogs.com/kyoner/p/11080078.html
    //二分查找 规则： 出口的判断、mid后范围的确定
    public int minNumberInRotateArray(int [] array,int left, int right) {
        if(left>=right) return array[left];
        int mid = (left + right ) /2;
        //right即为target
        if(array[mid] >= array[right]){
            //注意左边界为mid+1；否则在递归时会无法终止，最终会停在两个元素的长度，比如 [2,1]
            return minNumberInRotateArray(array,mid+1,right);
        }else{
            return minNumberInRotateArray(array,left,mid);
        }

    }
}
