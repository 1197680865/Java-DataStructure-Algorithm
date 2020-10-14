package dataStructures.sort;

/**
 * 选择排序
 * 内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到排序的目的
 * 基本思想：先找到范围内最小值，再交换
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int[]  arr = {1,5,4,9,7,11,12};

        //处理arr[i]
        for (int i=0; i<arr.length; i++){
            int min = arr[i];
            int minIdx = i;

            for (int j=i+1; j<arr.length; j++){
                if (arr[j] < min){
                    min =arr[j];
                    minIdx=j;
                }
            }
            //交换
            if (minIdx !=i){
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
        print(arr);
    }

    public static void print(int[] arr){
        for (int q:arr){
            System.out.print(q+" ");
        }
        System.out.println();
    }
}
