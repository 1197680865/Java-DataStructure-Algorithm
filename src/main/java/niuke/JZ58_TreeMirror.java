package niuke;

/**
 * 判断二叉树是否对称
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 输入 {8,6,6,5,7,7,5} 返回值true
 * 输入 {8,6,9,5,7,7,5} 返回值 false
 * 思路：递归，判断left.left,right.right  和 left.right,right.left
 */
public class JZ58_TreeMirror {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return helpCheck(pRoot.left,pRoot.right);
    }

    boolean helpCheck(TreeNode left,TreeNode right){
        if(left == null && right!=null){
            return false;
        }
        if(left != null && right==null){
            return false;
        }
        if(left == null && right==null){
            return true;
        }

        if(left.val == right.val){
            return helpCheck(left.left,right.right) && helpCheck(left.right,right.left);
        }else{
            return false;
        }
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
