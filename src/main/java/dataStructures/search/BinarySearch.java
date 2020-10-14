package dataStructures.search;

/**
 * 二分查找
 * 递归方法：
 * 退出条件：1.找到，退出；2.left>right未找到退出
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,10,90,90,90,100,100,100,11111};
        System.out.println(search(arr,90,0,arr.length-1));
        System.out.println(search2(arr,90,0,arr.length-1));
    }

    /**
     * 二分查找 递归
     * @param a
     * @param fv  要查询的值
     * @param left
     * @param right
     * @return 找不到返回-1，找到就返回索引,返回的不一定是第一个相等的
     */
    public static int search(int[] a,int fv,int left ,int right){
        if (left>right){
            return -1; //退出条件，未找到
        }
        int pivot = (left + right) /2;
        int v=a[pivot];
        if (v <fv){
            //右半部分递归
            return search(a,fv,pivot,right);
        }else if(v >fv){
            //左半部分递归
            return search(a,fv,left,pivot);
        }else {
            return pivot;//退出条件，找到
        }
    }


    /**
     * 二分查找 递归
     * @param a
     * @param fv  要查询的值
     * @param left
     * @param right
     * @return 找不到返回-1，找到就返回索引,返回的不一定是第一个相等的
     */
    public static int search2(int[] a,int fv,int left ,int right){
        if (left>right){
            return -1; //退出条件，未找到
        }
        int pivot = (left + right) /2;
        int v=a[pivot];
        if (v <fv){
            //右半部分递归
            return search2(a,fv,pivot,right);
        }else if(v >fv){
            //左半部分递归
            return search2(a,fv,left,pivot);
        }else {
            //第一个相等的
            if (fv==a[pivot-1]){
                int i = pivot;
                while (fv==a[i-1]){
                    i--;
                }
                return i;
            }
            /* 最后一个相等的
            if (fv==a[pivot+1]){
                int j = pivot;
                while (fv==a[j+1]){
                    j++;
                }
                return j;
            }
             */

            return pivot;//退出条件，找到
        }
    }
}
