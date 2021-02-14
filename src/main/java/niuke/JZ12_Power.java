package niuke;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 输入 2,3，返回8
 * 输入 2，-3，返回 0.12500
 * 思路：1.暴力循环，但是如何幂指数为负数时，需要调整base为base的倒数
 */
public class JZ12_Power {
    public double Power(double base, int exponent) {
        //要点： exponent为负数，需要调整base为base的倒数
        //方法1：暴力循环
        if(base ==0) return 0;
        if(exponent<0) {
            base = 1/base;
            exponent = -exponent;
        }
        int e = 1;
        double ans = 1.0;
        while(e<=exponent){
            ans = ans * base;
            e++;
        }
        return ans;
        //方法2：递归快速幂

    }

    /**
     * 快速幂
     * @param base
     * @param exp
     * @return
     */
    public static double getPower(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        if (exp<0){
            base = 1/base;
            exp = -exp;
        }
        double ans = getPower(base, exp >> 1);
        ans *= ans;
        if ((exp & 1) == 1) {
            ans *= base;
        }
        return ans;
    }
}
