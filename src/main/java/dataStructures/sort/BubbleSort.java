package dataStructures.sort;

/**
 * 冒泡排序
 * 含优化排序:loopHasChange
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[]  arr = {1,5,4,9,7,11,12};

        int temp = 0;

        //冒泡排序 循环的边界：i<arr.length -1,因为后面有arr[j+1]
        for (int i=0; i<arr.length -1; i++){
            //记录一次外层循环是否有发生交换
            boolean loopHasChange = false;
            for (int j=0; j<arr.length -1 - i; j++){
                if (arr[j] > arr[j+1] ){
                    loopHasChange = true;
                    temp = arr[j+1 ];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
            if (!loopHasChange){
                //一次外层循环未有发生交换，已经达到有序状态
                System.out.println("loop not change. done.");
                break;
            }
            System.out.println("第" + i + "次大循环");
            print(arr);
        }


    }

    public static void print(int[] arr){
        for (int q:arr){
            System.out.print(q+" ");
        }
        System.out.println();
    }
}
