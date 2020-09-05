package dataStructures.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Zhangchen
 * <p>思路</p>
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 * 本次使用填坑法+递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {-9,-9,78,0,23,-567,70,70};
        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 基准数选择的是数组第一个（故先从右侧查找）
     * @param arr
     * @param left
     * @param right
     */
    public static void qSort(int[] arr,int left,int right){
        if (left < right)
        {
            int i=left, j =right;
            int tmp = arr[i];
            while (i<j)
            {
                // 1.从右向左找第一个小于tmp的数(i<j，是为了控制不要循环到right，减少不必要的循环)
                while (i<j  &&  arr[j]>=tmp){
                    j--;//从右向左找到第一个小于tmp的数后，退出循环
                }
                //将从右侧找到的数放到坑中arr[i]，此后arr[j]是坑
                if (i<j)
                {
                    arr[i] = arr[j];
                    i++;
                }

                // 2.从左向右找第一个大于tmp的数(i<j，是为了控制不要循环到left，减少不必要的循环)
                while (i<j  &&  arr[i]<=tmp){
                    i++;//从左向右找到第一个大于tmp的数后，退出循环
                }
                //将从左侧找到的数放到坑中arr[j]，此后arr[i]是坑
                if (i<j)
                {
                    arr[j] = arr[i];
                    j--;
                }

                //3.将2中新出来的arr[i]坑填上tmp
                arr[i] = tmp;

                //4.递归调用，提供数组的左右边界
                qSort(arr,left,i-1);//因为[left,i-1]还是无序的
                qSort(arr,i+1,right);//因为[i+1,right]还是无序的
            }

        }

    }
}
