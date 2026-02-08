// Node class
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {

    Node root;

    // -------- INSERT --------
    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // -------- SEARCH --------
    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    // -------- INORDER -------- (Left Root Right)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // -------- PREORDER -------- (Root Left Right)
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // -------- POSTORDER -------- (Left Right Root)
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        int[] values = {25, 12, 50, 44, 17, 60};
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        int key = 17;
        System.out.println("\n\nSearch " + key + ": " + tree.search(tree.root, key));
    }
}
