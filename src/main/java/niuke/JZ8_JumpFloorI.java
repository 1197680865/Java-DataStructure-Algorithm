package niuke;

/**
 *  普通跳台阶
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *          //f(1) = 1;
 *         //f(2) = 2;
 *  思路：类同fibonacci数列求法只是f（2）不同
 * 方法1： 普通fibonacci递归
 * 方法2： 普通fibonacci递归/循环（动态规划） + 记忆化搜索
 * 方法3（这里使用此方法）：方法2基础上优化，只需要用两个变量存储f(n-1)、f(n-2)就行
 */
public class JZ8_JumpFloorI {
    public int JumpFloor(int target) {
        //f(1) = 1;
        //f(2) = 2;
        int a =1;
        int b = 2;
        if(target<=1) return a;
        if(target == 2) return b;
        int start =2;
        int res = 0;
        while(start<target){
            res = a + b;
            a = b;
            b = res;
            start++;
        }
        return res;
    }
}
