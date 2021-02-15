package niuke;

/**
 * 平衡二叉树 类似{@link JZ38_TreeDepth#TreeDepth(niuke.JZ38_TreeDepth.TreeNode)}
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *
 * 输入：{1,2,3,4,5,6,7} 输出：true
 * 思路： 递归计算左右子树的高度
 *
 */
public class JZ39_IsBalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) {
            return true;
        }
        int ans = getCurTreeDep(root);
        if(ans==-1) return false;
        else return true;
    }
    public int getCurTreeDep(TreeNode root){
        if(root==null) {
            return 0;
        }
        int ld = getCurTreeDep(root.left);
        int rd = getCurTreeDep(root.right);
        if(ld ==-1 || rd==-1 ||Math.abs(ld-rd)>1 ){
            return -1;
        }
        return ld>rd ? ld+1 : rd+1;
    }

    class TreeNode {
        int val = 0;
       TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
