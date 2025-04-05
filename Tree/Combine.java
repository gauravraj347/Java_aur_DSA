package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Combine {

    // Node class representing a single node in the binary tree
    static class Node {
        int data;      // Value stored in the node
        Node left;     // Reference to the left child node
        Node right;    // Reference to the right child node

        // Constructor to initialize a node with given data
        Node(int data) {
            this.data = data;
            this.left = null;   // Left child initially set to null
            this.right = null;  // Right child initially set to null
        }
    }

    // BinaryTree class for constructing a binary tree from an array
    static class BinaryTree {
        static int idx = -1;    // Static index to track position in array during tree construction

        /**
         * Recursively builds a binary tree from a preorder array representation
         * @param nodes Array containing node values (-1 represents null)
         * @return Root node of the constructed binary tree
         */
        public static Node buildTree(int nodes[]) {
            idx++;  // Increment index to process next element

            // Base case: if index exceeds array length or current value is -1, return null
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);    // Create new node with current value
            newNode.left = buildTree(nodes);        // Recursively build left subtree
            newNode.right = buildTree(nodes);       // Recursively build right subtree

            return newNode;    // Return the constructed node
        }
    }

    /**
     * Performs preorder traversal: Root → Left → Right
     * @param root Root node of the tree/subtree
     */
    public static void preorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");    // Print -1 for null nodes
            return;
        }
        System.out.print(root.data + " ");    // Visit root
        preorder(root.left);                  // Traverse left subtree
        preorder(root.right);                 // Traverse right subtree
    }

    /**
     * Performs inorder traversal: Left → Root → Right
     * @param root Root node of the tree/subtree
     */
    public static void inorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");    // Print -1 for null nodes
            return;
        }
        inorder(root.left);                   // Traverse left subtree
        System.out.print(root.data + " ");    // Visit root
        inorder(root.right);                  // Traverse right subtree
    }

    /**
     * Performs postorder traversal: Left → Right → Root
     * @param root Root node of the tree/subtree
     */
    public static void postorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");    // Print -1 for null nodes
            return;
        }
        postorder(root.left);                 // Traverse left subtree
        postorder(root.right);                // Traverse right subtree
        System.out.print(root.data + " ");    // Visit root
    }

    /**
     * Performs level-order (breadth-first) traversal using a queue
     * Prints each level on a new line
     * @param root Root node of the tree
     */
    public static void levelOrder(Node root) {
        if (root == null) {
            return;    // Return if tree is empty
        }
        Queue<Node> q = new LinkedList<>();    // Queue for BFS
        q.add(root);                           // Add root to queue
        q.add(null);                           // Null marks end of level
        while (!q.isEmpty()) {
            Node curr = q.poll();              // Get next node
            if (curr == null) {
                System.out.println();          // New line for new level
                if (q.isEmpty()) {
                    break;                     // Exit if queue is empty
                } else {
                    q.add(null);               // Add marker for next level
                }
            } else {
                System.out.print(curr.data + " ");    // Print current node
                if (curr.left != null) {
                    q.add(curr.left);                 // Add left child
                }
                if (curr.right != null) {
                    q.add(curr.right);                // Add right child
                }
            }
        }
    }

    /**
     * Calculates the height of the tree (longest path from root to leaf)
     * @param root Root node of the tree/subtree
     * @return Height of the tree
     */
    public static int height(Node root) {
        if (root == null) {
            return 0;    // Height of empty tree is 0
        }
        int leftHeight = height(root.left);      // Height of left subtree
        int rightHeight = height(root.right);    // Height of right subtree
        return Math.max(leftHeight, rightHeight) + 1;    // Max height plus root
    }

    /**
     * Counts total number of nodes in the tree
     * @param root Root node of the tree/subtree
     * @return Total number of nodes
     */
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;    // Empty tree has 0 nodes
        }
        return countOfNodes(root.left) + countOfNodes(root.right) + 1;    // Left + Right + Root
    }

    /**
     * Calculates sum of all node values in the tree
     * @param root Root node of the tree/subtree
     * @return Sum of all node values
     */
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;    // Sum of empty tree is 0
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;    // Left + Right + Root
    }

    /**
     * Calculates diameter of the tree (longest path between any two nodes) - O(n²)
     * @param root Root node of the tree/subtree
     * @return Diameter of the tree
     */
    public static int diameter(Node root) {
        if (root == null) {
            return 0;    // Diameter of empty tree is 0
        }
        int diam1 = height(root.left) + height(root.right) + 1;    // Path through root
        int diam2 = diameter(root.left);                           // Diameter in left subtree
        int diam3 = diameter(root.right);                          // Diameter in right subtree
        return Math.max(diam1, Math.max(diam2, diam3));            // Maximum of all possibilities
    }

    // Helper class to store tree height and diameter together
    static class TreeInfo {
        int height;      // Height of the tree
        int diameter;    // Diameter of the tree

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    /**
     * Optimized method to calculate both height and diameter in O(n) time
     * @param root Root node of the tree/subtree
     * @return TreeInfo containing height and diameter
     */
    public static TreeInfo getTreeInfo(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);    // Empty tree info
        }
        TreeInfo leftTI = getTreeInfo(root.left);       // Info for left subtree
        TreeInfo rightTI = getTreeInfo(root.right);     // Info for right subtree
        int myHeight = Math.max(leftTI.height, rightTI.height) + 1;    // Current height
        int diam1 = leftTI.height + rightTI.height + 1;                // Path through root
        int myDiameter = Math.max(diam1, Math.max(leftTI.diameter, rightTI.diameter));    // Max diameter
        return new TreeInfo(myHeight, myDiameter);
    }

    /**
     * Checks if two trees are identical in structure and values
     * @param root First tree's root
     * @param subRoot Second tree's root
     * @return True if trees are identical, false otherwise
     */
    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;    // Both null means identical
        }
        if (root == null || subRoot == null) {
            return false;   // One null means not identical
        }
        return root.data == subRoot.data &&    // Compare values
               isIdentical(root.left, subRoot.left) &&    // Compare left subtrees
               isIdentical(root.right, subRoot.right);    // Compare right subtrees
    }

    /**
     * Checks if subRoot tree is a subtree of root tree
     * @param root Main tree's root
     * @param subRoot Subtree's root to check
     * @return True if subRoot is a subtree of root, false otherwise
     */
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;    // Empty tree is a subtree of any tree
        }
        if (root == null) {
            return false;   // Non-empty tree can't be subtree of empty tree
        }
        if (isIdentical(root, subRoot)) {
            return true;    // Found identical subtree
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);    // Check left or right
    }

    /**
     * Main method to demonstrate binary tree operations
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Array representing tree in preorder traversal (-1 for null)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Construct the binary tree
        Node root = BinaryTree.buildTree(nodes);
        System.out.println("Root Node: " + root.data);

        // Demonstrate different traversals
        System.out.println("\nPreorder Traversal:");
        preorder(root);

        System.out.println("\n\nInorder Traversal:");
        inorder(root);

        System.out.println("\n\nPostorder Traversal:");
        postorder(root);

        System.out.println("\n\nLevel Order Traversal:");
        levelOrder(root);

        // Demonstrate tree properties
        System.out.println("\n\nHeight of Tree: " + height(root));
        System.out.println("Number of Nodes: " + countOfNodes(root));
        System.out.println("Sum of Nodes: " + sumOfNodes(root));
        System.out.println("Diameter (O(n²)): " + diameter(root));

        TreeInfo treeInfo = getTreeInfo(root);
        System.out.println("Optimized Diameter (O(n)): " + treeInfo.diameter);
    }
}