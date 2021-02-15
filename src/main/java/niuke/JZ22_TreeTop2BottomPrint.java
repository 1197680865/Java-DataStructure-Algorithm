package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 输入:{5,4,#,3,#,2,#,1} 输出：[5,4,3,2,1]
 * 思路：借助队列完成层次遍历当前队列的长度 == 当前层节点个数
 */
public class JZ22_TreeTop2BottomPrint {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //{5,4,#,3,#,2,#,1} 还原到二叉树结构，如下：
        /*
                            5
                          4   null
                        3  null
                      2  null
                     1 null
        */
        //注意Queue的创建方式，实际上是LinkedList
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //注意Queue放入元素的方法
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curFloorLength = queue.size();
            while (curFloorLength > 0) {
                //注意Queue取出元素的方法
                TreeNode tmpNode = queue.poll();
                list.add(tmpNode.val);
                curFloorLength--;
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
        }
        return list;
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
