package niuke;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 解题：按照中序遍历的规则，给出当前节点的下一个节点是？
 * 思路：方法一：模拟法：先找到根节点，中序遍历将节点放入数组，遍历查查数组得到pNode的下一个节点
 * 方法二（推荐）：  根据中序遍历的特点，分几种情况讨论
 *
 */
public class JZ57_FindTreeNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //方法一  模拟法：先找到根节点，中序遍历将节点放入数组，遍历查查数组得到pNode的下一个节点
        //方法二 根据中序遍历的特点，分几种情况讨论

        //此处使用方法二
        //1.此节点有右子树， 按照中序遍历找到右子树的第一个节点
        //2.此节点无右子树，其此节点属于父节点的左子树。返回父节点即可
        //3.此节点无右子树，其此节点属于父节点的右子树。向上查找，找到符合条件的祖先节点：祖先节点的左子节点是 pNode的父节点。
        //    若找不到符合条件的祖父节点，则说明此节点属于尾节点，返回null
        if(pNode==null) return null;
        //1.此节点有右子树， 按照中序遍历找到右子树的第一个节点
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }

        if(pNode.right == null){
            TreeLinkNode parent = pNode.next;
            //2.此节点无右子树，其此节点属于父节点的左子树。返回父节点即可
            //注意边界 判断parent== null 即当pNode是root节点且无右子树的情况
            if(parent== null || parent.left == pNode){
                return parent;
            }
            //3.此节点无右子树，其此节点属于父节点的右子树。向上查找，找到符合条件的祖先节点：祖先节点的左子节点是 pNode的父节点。
            if(parent.right == pNode){
                TreeLinkNode pp = parent.next;
                while(pp!=null){
                    if(pp.left == parent){
                        return pp;
                    }
                    parent = pp;
                    pp = parent.next;
                }
                return null;
            }
        }
        return null;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
