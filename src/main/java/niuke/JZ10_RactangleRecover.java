package niuke;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如 n=2,2种覆盖方案；n=3,3种覆盖方案；n=4,5种覆盖方案
 * 思路： 同fibonacci数列
 */
public class JZ10_RactangleRecover {
    public int rectCover(int target) {
        int a = 1;
        int b =2;
        if(target==1) return a;
        if(target==2) return b;
        int res = 0;
        int start = 3;
        while(start<=target){
            res = a+b;
            a = b;
            b = res;
            start++;
        }
        return res;

    }
}
