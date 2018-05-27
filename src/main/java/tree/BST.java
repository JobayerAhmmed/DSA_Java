package main.java.tree;

// present data in sorted order (use inorder)

// recursive function use heap space
// iterative function use stack space
// Stack memory size is very less compared to Heap memory.

// insert()
// remove()
// search()
// isBST()
// inorder()
// preorder()
// postorder()

public class BST {

    // return root
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    // return root
    public Node remove(Node root, int data) {
        // empty
        if (root == null)
            return root;

        if (data < root.data)
            root.left = remove(root.left, data);
        else if (data > root.data)
            root.right = remove(root.right, data);
        else {
            // two child
            if (root.left != null && root.right != null) {
                // find smallest in the right subtree (inorder successor)
                root.data = findMin(root.right).data;
                // delete inorder successor
                root.right = remove(root.right, root.data);
            }
            // only left child
            else if (root.left != null)
                return root.left;
            // only right child
            else if (root.right != null)
                return root.right;
            // no child
            else
                return null;
        }

        return root;
    }

    // Find minimum node in a subtree
    private Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    public Node search(Node root, int data) {
        if (root == null || root.data == data)
            return root;

        if (data < root.data)
            return search(root.left, data);

        return search(root.right, data);
    }

    public boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        // Allow only distinct values
        // For non-distinct values, use node.data
        return isBSTUtil(node.left, min, node.data-1) && isBSTUtil(node.right, node.data+1, max);
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        Node root = tree.insert(null, 8);
        tree.insert(root, 3);
        tree.insert(root, 10);
        tree.insert(root, 1);
        tree.insert(root, 6);
        tree.insert(root, 4);
        tree.insert(root, 7);
        tree.insert(root, 14);
        tree.insert(root, 13);

        System.out.print("inorder: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("preorder: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("postorder: ");
        tree.postorder(root);
        System.out.println();

        Node searchedNode = tree.search(root, 6);
        System.out.println("search 6: " + searchedNode.left.data + " " + searchedNode.data + " " + searchedNode.right.data);

        System.out.print("remove 8: ");
        root = tree.remove(root, 8);
        tree.preorder(root);
        System.out.println();

        System.out.print("remove 13: ");
        root = tree.remove(root, 13);
        tree.preorder(root);
        System.out.println();

        root = tree.insert(root, 15);
        System.out.print("insert 15: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("remove 15: ");
        root = tree.remove(root, 15);
        tree.preorder(root);
        System.out.println();

        Node a = tree.new Node(3);
        Node b = tree.new Node(2);
        Node c = tree.new Node(5);
        Node d = tree.new Node(1);
        Node e = tree.new Node(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println("isBST: " + tree.isBST(a));

        Node f = tree.new Node(4);
        Node g = tree.new Node(2);
        Node h = tree.new Node(5);
        Node i = tree.new Node(1);
        Node j = tree.new Node(3);
        f.left = g;
        f.right = h;
        g.left = i;
        g.right = j;

        System.out.println("isBST: " + tree.isBST(f));


    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
