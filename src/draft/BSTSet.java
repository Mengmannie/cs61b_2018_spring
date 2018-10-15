package draft;

import java.util.Set;

public class BSTSet<T> implements Set1<T> {
    BSTree tree;
    int elements;

    class BSTree {
        T element;
        BSTree left, right;

        BSTree add(T element) {
            if (this.element == null) {
                this.element = element;
                return this;
            } else if (this.element.equals(element)) {
                return null;  // signify that we did not add anything (it was already there)
            } else if (element.hashCode() < this.element.hashCode()) { // add to left
                if (left == null)
                    left = new BSTree();
                return left.add(element);
            } else { // add to right
                if (right == null)
                    right = new BSTree();
                return right.add(element);
            }
        }

        void add(BSTree subtree) {
            if (subtree != null && subtree.element != null) {
                add(subtree.element);
                add(subtree.left);
                add(subtree.right);
            }
        }

        BSTree find (T element, boolean detatch) {
            if (element == null || this.element == null)
                return null;   // empty tree or null element
            else if (this.element.equals(element)) {
                return this;
            } else if (element.hashCode() < this.element.hashCode()) { // search left
                return searchSubTree(left, element, detatch);
            } else {  // search right
                return searchSubTree(right, element, detatch);
            }
        }

        BSTree searchSubTree(BSTree subtree, T element, boolean detatch) {
            if (subtree == null)
                return null;
            else {
                BSTree t = subtree.find(element, detatch);
                if (t == subtree && detatch) {
                    if (subtree == left)
                        left = null;
                    else
                        right = null;
                }
                return t;
            }
        }

        @Override
        public String toString() {
            String rtn = "";
            if (element != null) {
                if (left != null) {
                    rtn += left + ", ";
                }
                rtn += element;
                if (right != null) {
                    rtn += ", " + right;
                }
            }
            return rtn;
        }

    }


    @Override
    public void add(T element) {
        if (tree == null)
            tree = new BSTree();
        if (tree.add(element) != null)
            elements++;
    }

    @Override
    public void remove(T element) {
        BSTree root = tree.find(element, true);
        if (root != null) {
            root.element = null;
            BSTree l = root.left;
            BSTree r = root.right;
            root.left = null;
            root.right = null;
            tree.add(l);  // add subtree back in
            tree.add(r);  // add subtree back in
            elements--;
        }

    }

    @Override
    public boolean contains(T element) {
        if (tree == null)
            return false;
        else
            return tree.find(element, false) != null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String rtn = "";
        if (tree != null)
            rtn += tree;
        return rtn;
    }

    public static void main(String[] args) {
        BSTSet<Integer> bstset = new BSTSet<>();
        bstset.add(1);
        bstset.add(2);
        bstset.add(9);
        System.out.println(bstset);
    }
}

