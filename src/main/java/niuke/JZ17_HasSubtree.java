package niuke;


/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 难度较高，题解：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 * 思路：若树 B 是树 A 的子结构，则子结构的根节点可能为树 AA的任意一个节点。因此，判断树 B是否是树 A 的子结构，需完成以下两步工作：
 *         先序遍历树 A 中的每个节点 n_An ；（对应函数 HasSubtree(A, B)）；
 *         判断树 A 中 以 n_An  为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
 */
public class JZ17_HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        //root1!=null && root2!=null  如果递归中出现root1为空了，说明不包含子树;如果root2不为空为题目的约定
        return  (root1!=null && root2!=null) &&
                //先序遍历树 A 中的每个节点 n_An ；（对应函数 HasSubtree(A, B)）
                //判断树 A 中 以 n_An  为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
                (recur(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2));
    }
    //判断以root1为根节点是否包含root2树
    public boolean recur(TreeNode root1,TreeNode root2){
        if(root2 == null){
            //root2已经遍历完，而且前面都是符合要求的
            return true;
        }
        if(root1 == null || root1.val != root2.val){
            //如果root1遍历完了，但root2还有节点，明显不包含
            //如果root1和root2的值不相等，明显也不包含
            return false;
        }
        return recur(root1.left,root2.left) && recur(root1.right,root2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
