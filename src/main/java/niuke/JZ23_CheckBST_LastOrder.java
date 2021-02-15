package niuke;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 输入:[4,8,6,12,16,14,10] 返回值:true
 * 思路：二叉搜索树即二叉排序树，注意二叉排序树和大顶堆的区别。
 * 二叉搜索树特点：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序
 * 后续遍历：先左子节点，再右子节点，最后为父节点
 * 算法要点：1.根据后续遍历特性，找出父节点及左右分界
 *          2.判断是否左右分界内的元素是否符合二叉搜索树的特点：  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
 */
public class JZ23_CheckBST_LastOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        //二叉搜索树即二叉排序树，注意二叉排序树和大顶堆的区别
        //若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
        //后续遍历： 先左子节点，再右子节点，最后为父节点
        if(sequence == null || sequence.length == 0) return false;
        int length = sequence.length;
        //要点1： 根据后续遍历特性，找出父节点及左右分界
        //要点2： 判断是否左右分界内的元素是否符合二叉搜索树的特点：  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
        //比如  10 16 9 14 就是错误的，14为根节点，16,、9按照特性应为又子节点但是9小于14，所以不正确
        return helpVerify(sequence,0,length-1);
    }
    public boolean helpVerify(int [] sequence,int start, int root){
        //root 根节点，start是 以root为跟节点的所有节点的开始位置
        //出口，上一轮的递归无问题，返回true
        if(start >=root) return true;
        //找到左子树和右子树的边界
        int rs = start;
        while(sequence[rs] < sequence[root]){
            rs ++ ;
        }
        int r = rs;
        //rs为右子树开始的位置
        //下面判定右子树的元素是否都大于root
        while(rs<=root){
            if(sequence[rs] < sequence[root]){
                //出口：非正确的后续遍历
                return false;
            }
            rs++;
        }
        //右子树遍历结束，执行到此，说明当前节点的root的左右子树的特征是正确的
        return helpVerify(sequence,start,r-1) && helpVerify(sequence,r,root-1);
    }
}
