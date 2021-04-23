package Cai_dat_tim_kiem_cay_nhi_phan;

import org.w3c.dom.Node;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }
    private void preOrder (TreeNode<E> t){
        if(t!=null){
            System.out.println(t.element+" ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }
    @Override
    public void preOrder (){
        preOrder (root);
    }
    private void postOrder (TreeNode<E> t){
        if(t!=null){
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.element+ " ");
        }
    }
    @Override
    public void postOrder(){
        postOrder(root);
    }
    public int timX (TreeNode<E> t, String x){
        if(t==null)
            return 0;
        if(t.element.equals(x))
            return 1;
        else
            return timX(t.left, x)+ timX(t.right, x);
    }
    public void timX(String x) {
        if (timX(root, x) ==  1)// co the ==0
            System.out.println("co");// =0 thi la khong
        else
            System.out.println("khong");//== 0 thi la co
    }
}
