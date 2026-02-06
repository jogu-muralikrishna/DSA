class Node {
    int data;
    Node left;
    Node right;

    // Constructor
    Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}

class BinaryTree {

    Node root;

    // Inorder Traversal (Left -> Root -> Right)
    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    // Preorder Traversal (Root -> Left -> Right)
    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // Creating tree nodes (same style as your notes)
        tree.root = new Node(25);
        tree.root.left = new Node(12);
        tree.root.right = new Node(50);

        tree.root.left.left = new Node(44);
        tree.root.left.right = new Node(17);

        tree.root.right.left = new Node(50);
        tree.root.right.right = new Node(60);

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);
    }
}
