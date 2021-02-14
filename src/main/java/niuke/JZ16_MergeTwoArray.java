package niuke;

/**
 * 合并两个有序的数组（百度一面笔试题，挂，没有考虑到A遍历完而B未遍历完的情况）
 * 给出两个有序的整数数组A和B ，请将数组B合并到数组A中，变成一个有序的数组
 * 可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和 n
 * 注意： A中存放的是结果；注意两个数组变量的边界
 */
public class JZ16_MergeTwoArray {
    public void merge(int A[], int m, int B[], int n) {
        //注意 A用来存放结果
        //1：直接在A上操作，如下； 2：新建一个数组，最后把结果拷贝到A上
        int nSize = m+n;
        int an = m-1;
        int bn = n-1;
        int rn = nSize - 1;
        while(an >=0 && bn>=0){
            if(A[an] >= B[bn]){
                A[rn] = A[an];
                an--;
                rn--;
            }else{
                A[rn] = B[bn];
                bn--;
                rn--;
            }
        }
        //注意下面： 当初百度考过，忽略了边界，导致结果不对
        while(bn>=0){
            A[rn] = B[bn];
            bn--;
            rn--;
        }
    }
}
