package Cai_dat_tim_kiem_cay_nhi_phan;

public interface Tree<E> {
    public boolean insert(E e);

    public void inorder();

    public int getSize();

    public void preOrder();

    public void postOrder();
}
