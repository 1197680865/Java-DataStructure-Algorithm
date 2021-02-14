package niuke;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * 输入：4 ；输出：3
 * 思路：
 * 方法1： 普通fibonacci递归
 * 方法2： 普通fibonacci递归/循环（动态规划） + 记忆化搜索
 * 方法3：方法2基础上优化，只需要用两个变量存储f(n-1)、f(n-2)就行
 *
 * 与爬台阶的区别是 f（2）不同
 */
public class JZ7_Fibonacci {
    public int Fibonacci(int n) {
        //方法1 递归
        /*
        if(n==1) return 1;
        if(n==0) return 0;
        return Fibonacci(n -1) + Fibonacci(n -2);
        */
        //方法2 循环 + 数组（记忆化搜索）

        if(n==0) return 0;
        int[] faar = new int[n+1];
        faar[0] = 0;
        faar[1] = 1;
        if(n<=1) {
            return faar[n];
        }
        int start = 2;
        while(start <=n){
            faar[start] = faar[start -1] +faar[start -2];
            start++;
        }
        return faar[start-1];
        //方法3： 方法2基础上优化，只需要用两个变量存储f(n-1)、f(n-2)就行
    }
}
