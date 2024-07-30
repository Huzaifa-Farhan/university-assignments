class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class bst {
    Node root;

    bst() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    //inorder traversal using recursion (already give)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    //preorder traversal using recursion
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    //postorder traversal using recursion
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        bst tree = new bst();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree:");
        tree.inorder();

        System.out.println("\nPreorder traversal of the given tree:");
        tree.preorder();

        System.out.println("\nPostorder traversal of the given tree:");
        tree.postorder();

        
        System.out.println("\n\nDelete 20");
        tree.delete(20);
        System.out.println("Inorder traversal of the modified tree:");
        tree.inorder();
        System.out.println("\nPreorder traversal of the modified tree:");
        tree.preorder();
        System.out.println("\nPostorder traversal of the modified tree:");
        tree.postorder();

        
        System.out.println("\n\nDelete 30");
        tree.delete(30);
        System.out.println("Inorder traversal of the modified tree:");
        tree.inorder();
        System.out.println("\nPreorder traversal of the modified tree:");
        tree.preorder();
        System.out.println("\nPostorder traversal of the modified tree:");
        tree.postorder();

        System.out.println("\n\nDelete 50");
        tree.delete(50);
        System.out.println("Inorder traversal of the modified tree:");
        tree.inorder();
        System.out.println("\nPreorder traversal of the modified tree:");
        tree.preorder();
        System.out.println("\nPostorder traversal of the modified tree:");
        tree.postorder();
        
    }
}
