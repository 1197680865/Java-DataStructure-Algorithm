package dataStructures.sort;

/**
 * 插入排序：对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的
 * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[]  arr = {1,5,4,9,7,15,12};
        //从第2个元素开始
        for (int i=1; i<arr.length; i++){
            int insertValue = arr[i];
            int insertIdx = i-1;
            //倒序比较，同时后移赋值
            while(insertIdx >0 && insertValue <arr[insertIdx]){
                arr[insertIdx+1] = arr[insertIdx];
                insertIdx--;
            }
            //找到插入位置 ，insertIdx+1
            //首先判断是否就是自己当前的位置，如果是当前位置就无需交换了
            if (insertIdx +1 != i){
                arr[insertIdx +1] = insertValue;
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
