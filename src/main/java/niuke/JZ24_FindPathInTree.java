package niuke;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 输入:{10,5,12,4,7},22    输出：[[10,5,7],[10,12]]
 * 输入:{10,5,12,4,7},15   输出：[]
 * {10,5,12,4,7} 二叉树为：
 *          10
 *       5      12
 *     4  7
 *
 * 思路：前序遍历， 递归。  遍历到叶子节点即得到一条路径，检验此路径上的值是否符合条件。 回退然后获取另外一条路径。
 * 部分情况下若target提前超出了范围，可以考虑剪枝
 */
public class JZ24_FindPathInTree {

    //使用全局变量
    ArrayList<ArrayList<Integer>> result  = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //前序遍历 root -- root.left -- root.right
        //边界条件： root为null 直接返回
        if(root == null) return result;
        target = target - root.val;
        path.add(root.val);
        if(root.left ==null && root.right == null && target==0){
            result.add(new ArrayList<Integer>(path));
        }
        //剪枝，如果提前超出了target就无需继续计算其子树了
        if(target<0 && path.size()>0){
            path.remove(path.size() -1);
            return result;
        }
        //递归root的左右子树，由于操作的是全局变量，所以可以不用返回值
        if(root.left!=null){
            FindPath(root.left,target);
        }
        if(root.right!=null){
            FindPath(root.right,target);
        }
        //root的左子树和右子树遍历完成 或者是到达了叶子节点且不符合target，需要回退一层
        path.remove(path.size() -1);
        //递归到了叶子节点
        return result;
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
