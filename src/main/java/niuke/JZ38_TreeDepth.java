package niuke;

/**
 * 二叉树的深度 (类似JZ24) {@link JZ24_FindPathInTree#FindPath(niuke.JZ24_FindPathInTree.TreeNode, int)}
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 输入:{1,2,3,4,5,#,6,#,#,7}  输出：4
 *
 * 思路：方法一：前序遍历（递归），到达叶子节点时，用当前路径的深度和全局最大的深度做比较并更新
 * 方法二：层次遍历（借助队列），每一层可以得出一个高度
 */
public class JZ38_TreeDepth {
    int maxdep = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        curDep(root,0);
        return maxdep;
    }

    public void curDep(TreeNode root,int cd){
        if(root==null) return ;
        cd++;
        if(root.left == null && root.right== null){
            //到达叶子节点
            if(maxdep<cd){
                maxdep =cd;
            }
            return ;
        }
        if(root.left != null){
            curDep(root.left,cd);
        }
        if(root.right != null){
            curDep(root.right,cd);
        }

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

/*
//更简单的递归写法
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null)return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int result = 1 + ((leftDepth > rightDepth)?leftDepth:rightDepth);
        return result;
    }
}*/
