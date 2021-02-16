package niuke;

import java.util.Arrays;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 思路： 类似堆排序，使用大顶堆
 */
public class JZ29_Find10MinInArray {
    public static void main(String[] args) {
        int[] array={0,1,3,4,7,8,9,10,11,12,13,14,15,16,17,18,19,20,6,5};
        print(array);
    }
    public static void print(int[] array) {
        //最小的10个数 思路： 构建大顶堆（10个节点的），
        // 从第11个开始与大顶堆的顶部元素做比较，小则替换堆顶，调整堆。
        int[] heap = new int[10];
        for (int i=0;i<10;i++){
            heap[i] = array[i];
        }
        //调整heap，使其成为大顶堆
        //从最后一个非叶子节点开始，从下向上调整
        for (int t=10/2-1; t>=0; t--){
            adjust(heap,t,10);
        }
        //从array[10]开始，逐个元素与heap堆顶比较，小则替换堆顶，调整堆；小则忽略
        for (int t =10;t<array.length;t++){
            if (array[t] < heap[0]){
                heap[0] = array[t];
                adjust(heap,0,10);
            }
        }
        //输出最小的10个数，从小到大
        Arrays.sort(heap);
        System.out.println(Arrays.toString(heap));

    }

    public  static void adjust(int[] arr, int i, int length){
        int tmp = arr[i];
        // k= i*2+1 : 节点k为节点i的左子节点
        for (int k= i*2+1; k<length; k=k*2+1){
            if (k+1<length && arr[k] < arr[k+1]  ){
                k++;
            }
            if (arr[k] > tmp){ //如果k节点的值大于tmp，即子节点的值大于父节点
                arr[i] = arr[k]; //把较大的值赋给i结点
                i=k;
            }else {
                break;
            }
        }
        arr[i] = tmp;
    }
}
