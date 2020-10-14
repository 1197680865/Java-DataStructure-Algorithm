package dataStructures.sort;

/**
 * 快速排序（第二种写法，较好理解）
 * 递归
 */
public class QuickSort2 {
    public static void main(String[] args) {
//        int[]  arr = {1,5,4,9,7,15,12};
        int[]  arr = {1,5,4,9,7,15,12,7};
        quick(arr,0,arr.length-1);
        print(arr);

    }


    /**
     * 快排 递归方法
     * @param a 数组
     * @param left 左边界下标
     * @param right 右边界下标
     */
    public static void quick(int[] a,int left,int right){
        //1.找到中间值
        int pivot = (left + right) /2;
        int v = a[pivot];
        int l =left;//左边界下标，会更新
        int r = right;//右边界下标，会更新

        while (l<r) {//5.循环完成本轮的所有项分组
            //2.从左遍历，找到第一个大于等于v的,可以超出pivot
            while (a[l] < v) {
                l++;
            }

            //3.从右遍历，找到第一个小于等于V的,可以超出pivot
            while (a[r] > v) {
                r--;
            }
            //检查是否完成全部分组
            if (l>=r){
                break;
            }

            //4.交换2 3 步骤中找到的值
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            //边界处理相等数的情况
            if (a[l] == v){
                r--;
            }
            if (a[r]==v){
                l++;
            }

            //5.  2 3 4 只是完成了两次交换，需要外加循环完成本轮的所有项分组
        }

        if (l==r){ //边界条件，否则会栈溢出
            l++;
            r--;
        }

        //6.向左递归 注意左右边界
        if (left<r) {//边界条件，否则会栈溢出
            quick(a, left, r);
        }
        //7.向右递归 注意左右边界
        if (right>l) {//边界条件，否则会栈溢出
            quick(a, l, right);
        }

    }



    public static void print(int[] arr){
        for (int q:arr){
            System.out.print(q+" ");
        }
        System.out.println();
    }
}
