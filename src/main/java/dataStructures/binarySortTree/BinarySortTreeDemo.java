package dataStructures.binarySortTree;

/**
 * 二叉排序树
 *  对于二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大
 *  特点1：二叉排序树中序遍历，吉升序
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        //构建二叉排序树
        BinarySortTree tree = new BinarySortTree();
        for (int v:arr)
        {
            tree.add(new Node(v));
        }
        //中序遍历
        tree.infixOrder(); // 1 3 5 7 9 10 12


    }

}

/**
 * 二叉排序树
 */
class BinarySortTree{
    private Node tree;

    /**
     * 向树中添加节点
     * @param node
     */
    public void add(Node node){
        if (tree == null)
        {
            tree = node;
        }else {
            tree.add(node);
        }
    }

    public void  infixOrder(){
        if (tree!=null){
            tree.infixOrder();
        }
    }
}


/**
 * 二叉排序树的节点
 */
class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int v){
        value = v;
    }

    /**
     * 添加节点
     * 递归
     * @param node
     */
    public void add(Node node){
        if (node == null)
        {
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value)
        {
            if (this.left == null)
            {
                this.left = node;
            }else {
                //递归的向左子树添加
                this.left.add(node);
            }

        }else {
            if (this.right == null)
            {
                this.right = node;
            }else {
                //递归的向右子树添加
                this.right.add(node);
            }

        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.left!=null)
        {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right !=null)
        {
            this.right.infixOrder();
        }

    }

}
