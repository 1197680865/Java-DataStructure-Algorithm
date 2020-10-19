package dataStructures.tree;

/**
 * 二叉平衡树
 * 一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 * 要点1.计算节点的高度
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int arr[] = {4,3,6,5,7,8};
        AVLTree tree = new AVLTree();
        for (int i=0;i<arr.length; i++){
            tree.add(new AVLNode(arr[i]));
        }
        tree.infixOrder();

        System.out.println("树的高度：" + tree.getRoot().height());
        System.out.println("左子树的高度：" + tree.getRoot().leftHeight());//1
        System.out.println("右子树树的高度：" + tree.getRoot().rightHeight());//3
        //左右子树高度差为2，超过了1，非二叉平衡树

    }

}

class AVLTree {
    private AVLNode tree;
    public AVLNode getRoot(){
        return  tree;
    }

    /**
     * 向树中添加节点
     *
     * @param node
     */
    public void add(AVLNode node) {
        if (tree == null) {
            tree = node;
        } else {
            tree.add(node);
        }
    }

    public void infixOrder() {
        if (tree != null) {
            tree.infixOrder();
        }
    }
}


/**
 *
 */
class AVLNode {
    private int value;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(int v) {
        value = v;
    }

    /**
     * 添加节点
     * 递归
     *
     * @param node
     */
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }

        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }

        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    /**
     * @return 左子树的高度
     */
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    /**
     * @return 右子树的高度
     */
    public int rightHeight(){
        if (this.right == null){
            return 0;
        }else {
            return this.right.height();
        }
    }

    /**
     * 计算以当前节点为根节点的树的高度
     * 思路：递归，取左子树和右子树高度的最大值
     *
     * @return
     */
    public int height() {
        //注意：+1
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

}