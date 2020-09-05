package dataStructures.recursion;

/**
 *  八皇后问题，回溯算法
 *  在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 *  即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 *  思路
 * 第一个皇后先放第一行第一列
 * 第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK（回溯），继续放在第二列、第三列、依次把所有列都放完，找到一个合适
 * 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 * 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
 * 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
 *
 * 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题.
 * arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3} //对应arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列
 * 时间复杂度 8的8次方
 * 优化：贪心算法
 */
public class Queen8 {

    static  int max =8;
    int array[] =new int[8];
    static int count =0;
    static int judgeCount =0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.placeQueen(0);
        System.out.println("有效摆放方法：" + count);//92
        System.out.println("judge次数："+judgeCount);//15720

    }

    /**
     * 尝试放置皇后（回溯）
     * 每一次递归时，进入到 placeQueen 中都有  for(int i = 0; i < max; i++)，因此会有回溯
     * @param n 第n个皇后（从0开始）
     */
    private void placeQueen(int n){
        //边界条件
        if (n == max)
        {
            //已经放置到第九个了，结束
            print();
            count++;
            return;
        }

        for (int i=0; i<max; i++)
        {
            //第n行，第i列放置皇后
            array[n] = i;
            if (judge(n))
            {
                //继续放置n+1个皇后，递归
                placeQueen(n+1);
            }
            //如果冲突，则会 i++，在第n行的第i+1的位置放置皇后
        }
    }

    /**
     * 判断第n个皇后是否符合要求(不能处于同一行、同一列或同一斜线上)
     * 思路：依次检查它前面的皇后与之是否冲突
     * @param n 第n个皇后（从0开始）
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i=0; i<n; i++)
        {
            //如果处于同一列，返回false
            if (array[i]== array[n])
            {
                return false;
            }
            //处于同一斜线，返回false。 （斜率K=1,45°）
            if (Math.abs(i-n) == Math.abs(array[i] - array[n]))
            {
                return false;
            }
        }
        return true;

    }

    private void print(){
        for (int i=0; i<array.length; i++)
        {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
