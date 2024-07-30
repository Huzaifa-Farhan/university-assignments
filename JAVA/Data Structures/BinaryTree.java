//Huzaifa Farhan (100741975)
//Data Structures Assignment 2 Q1

import java.util.Scanner;

public class BinaryTree {
    private int postOrderIndex;
    private Scanner inputScanner;

    // initializes the scanner to take user input later in the code
    public BinaryTree() {
        inputScanner = new Scanner(System.in);
    }

    //this method takes the inorder and postorder traversal arrays as inputs.
    //Calls the recursive constructTree method to build the tree.
    public TreeNode constructTreeFromTraversals(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        return constructTree(inorder, postorder, 0, inorder.length - 1);
    }

    //A method that constructs the binary tree. Writter recursively.
    //Uses the current range of the inorder traversal and the postOrderIndex to access the postorder array.
    //Uses the postOrderIndex to find the root of the current subtree,
    //then finds the position of this root in the inorder array 
    //to divide the tree into left and right subtrees.
    //Recursively builds the right subtree first, then the left subtree  
    private TreeNode constructTree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null; // Base case: no subtree to construct.
        }

        // Create the root node of the current subtree.
        TreeNode root = new TreeNode(postorder[postOrderIndex--]);

        // If this node has no children, return it.
        if (start == end) {
            return root;
        }

        // Find the index of the root node in the inorder array to divide left and right subtrees.
        int inorderIndex = findIndex(inorder, root.value, start, end);

        // Recursively build the right and then left subtrees.
        root.rightChild = constructTree(inorder, postorder, inorderIndex + 1, end);
        root.leftChild = constructTree(inorder, postorder, start, inorderIndex - 1);

        return root;
    }

    //this method searches for a given value within a specified range in the array to return its index.
    //used to find the root node's index in the inorder traversal array.		
    private int findIndex(int[] array, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // Value not found.
    }

    //Method that performs a preorder traversal of the tree and prints the values of the nodes.
    //allow written recursivley
    public void printPreOrderTraversal(TreeNode node) {
        if (node == null) {
            return; // Base case: leaf node's children.
        }
        System.out.print(node.value + " ");
        printPreOrderTraversal(node.leftChild);
        printPreOrderTraversal(node.rightChild);
    }

    //Methodthat determines if one tree is a subtree of another 
    //by checking for identical structure and values starting from any node in the main tree.
    //Uses the areIdenticalTrees method specifically for checking tree equality.
    public boolean isSubtreeOf(TreeNode mainTree, TreeNode subTree) {
        if (mainTree == null) return false; // The main tree ended without a match.
        if (areIdenticalTrees(mainTree, subTree)) return true; // The two trees match.
        // Check the subtrees recursively.
        return isSubtreeOf(mainTree.leftChild, subTree) || isSubtreeOf(mainTree.rightChild, subTree);
    }

    //Checks if two trees are identical by comparing their structures and node values.
    //This method is also written recursively.
    private boolean areIdenticalTrees(TreeNode treeA, TreeNode treeB) {
        if (treeA == null && treeB == null) return true; // Both trees are empty.
        if (treeA == null || treeB == null) return false; // One tree is empty, and the other is not.
        // Check if the current nodes and their subtrees are identical.
        return treeA.value == treeB.value && areIdenticalTrees(treeA.leftChild, treeB.leftChild) && areIdenticalTrees(treeA.rightChild, treeB.rightChild);
    }

    // Reads an array of integers from the user input, 
    // this is later than used for the inorder and postorder traversals.
    private int[] readIntegerArray(int length) {
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = inputScanner.nextInt();
        }
        return resultArray;
    }

    // Main method to execute the program. (includes all the strings and output statements)
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //Ask user for size and traversals for the first tree.
        System.out.println("Enter the size of the first tree:");
        int firstTreeSize = binaryTree.inputScanner.nextInt();

        //Ask user for inorder traversal tree.
        System.out.println("Enter the inorder traversal of the first tree:");
        int[] inorderTraversal1 = binaryTree.readIntegerArray(firstTreeSize);

        //Ask user for postorder traversal tree.
        System.out.println("Enter the postorder traversal of the first tree:");
        int[] postorderTraversal1 = binaryTree.readIntegerArray(firstTreeSize);
        
        
        //uses the constructTreeFromTraversals method 
        //with the inorderTraversal1 and postorderTraversal1 to calculate the preorder travesal tree
        TreeNode firstTreeRoot = binaryTree.constructTreeFromTraversals(inorderTraversal1, postorderTraversal1);
        System.out.print("The preorder traversal of the first tree is: ");
        
        //returns the preorder traversal tree to user
        binaryTree.printPreOrderTraversal(firstTreeRoot);
        System.out.println();

        // Read the size and traversals for the second tree.
        System.out.println("Enter the size of the second tree:");
        int secondTreeSize = binaryTree.inputScanner.nextInt();

        // Ask user for inorder traversal tree.
        System.out.println("Enter the inorder traversal of the second tree:");
        int[] inorderTraversal2 = binaryTree.readIntegerArray(secondTreeSize);

     // Ask user for postorder traversal tree.
        System.out.println("Enter the postorder traversal of the second tree:");
        int[] postorderTraversal2 = binaryTree.readIntegerArray(secondTreeSize);

        //uses the constructTreeFromTraversals method 
        //with the inorderTraversal1 and postorderTraversal1 to calculate the preorder travesal tree
        //this is done again for the second tree root
        TreeNode secondTreeRoot = binaryTree.constructTreeFromTraversals(inorderTraversal2, postorderTraversal2);
        System.out.print("The preorder traversal of the second tree is: ");
        binaryTree.printPreOrderTraversal(secondTreeRoot);
        System.out.println();

        //once the sceond tree root has been made, we check if its a subtree or not
        //uses the isSubtreeOf with the firstTreeRoot and secondTreeRoot parameters for comparison 
        //to determine if the second is a subtree of the first (returns yes if the case, and vice versa)
        boolean isSubtree = binaryTree.isSubtreeOf(firstTreeRoot, secondTreeRoot);
        System.out.println("The answer to whether the second tree is a subtree of the first is: " +
                (isSubtree ? "Yes" : "No"));

        // Close the scanner resource to avoid resource leaks.
        binaryTree.inputScanner.close();
    }
}

//This class defines a binary tree node.
//leftchild, rightchild, and an instance of value (an integer value and references to its left and right children)
class TreeNode {
 int value;
 TreeNode leftChild;
 TreeNode rightChild;

 TreeNode(int value) {
     this.value = value;
 }
}
