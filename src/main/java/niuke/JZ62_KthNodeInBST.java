package niuke;

/**
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 输入:{5,3,7,2,4,6,8},3  输出：{4}
 *
 * 思路： BST的特点 1：二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大。
 *        BST的特点 2：中序遍历的结果是从小到大排序的。（寻找BST第k小的时候会用到）
 */
public class JZ62_KthNodeInBST {

    int count =0;
    TreeNode ans = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null) return null;
        if(pRoot.left != null) {
            KthNode(pRoot.left,k);
        }
        count++;
        int tmp = pRoot.val;
        if(count==k){
            ans = pRoot;
            return pRoot;
        }
        if(pRoot.right != null) {
            KthNode(pRoot.right,k);
        }
        //最后如果返回的是null，会影响到最上层的一次递归，导致最终结果错误
        return ans;
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
