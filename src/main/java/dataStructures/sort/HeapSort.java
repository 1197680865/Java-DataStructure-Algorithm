package dataStructures.sort;

import java.util.Arrays;

/**
 * 堆排序，是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，不稳定排序。
 * 1. 将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 2. 将其与末尾元素进行交换，此时末尾就为最大值。
 * 3. 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 *
 * 大顶堆特点：arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2]
 */
public class HeapSort {
    public static void main(String[] args) {
        //int[] arr = {4,6,8,5,9};
        int[] arr = {4,6,8,5,9,10,11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序：从小到大排列
     * @param arr
     */
    public static void heapSort(int[] arr){
        //1.构建大顶堆
        for (int i=arr.length/2-1; i>=0; i--){
            //从右到左，例：倒数第一层的非叶子节点层
            adjust(arr,i,arr.length);
        }
        //2.调整
        //2.1 交换堆顶与末尾元素，将最大元素"沉"到数组末端
        //2.2 将n-1个元素重新调整为大顶堆，仅需要一次adjust，因为目前只有首位的元素不符合
        for (int j=arr.length-1; j>=0; j--){
            int tmp = arr[j];
            arr[j] = arr[0];
            arr[0] = tmp;//2.1
            adjust(arr,0,j);//2.2 注意length参数
        }

    }


    /**
     * 把索引i对应非叶子节点为根的子树调整成大顶堆
     * 调用顺序：i从下倒上
     * 为构建大顶堆的一小步（构建过程），也是调整堆为大顶堆的一小步（调整过程）
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 	    如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param arr
     * @param i  索引i:非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 逐渐的减少
     */
    public  static void adjust(int[] arr, int i, int length){
        int tmp = arr[i];
        // k= i*2+1 : 节点k为节点i的左子节点
        for (int k= i*2+1; k<length; k=k*2+1){
            if (arr[k] < arr[k+1] && k+1<length){ //说明左子结点的值小于右子结点的值
                k++; //将k指向右节点
            }

            if (arr[k] > tmp){ //如果k节点的值大于tmp，即子节点的值大于父节点
                arr[i] = arr[k]; //把较大的值赋给i结点
                i=k; //!!! i 指向 k,继续循环比较(for循环)
            }else {
                break;//! 因为i下的子树都是已经符合大顶堆的了，不会出现{3,2,1}类似的堆，即不会出现父节点小于子节点的情况
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = tmp;//即最终的k的位置替换为tmp
    }
}
