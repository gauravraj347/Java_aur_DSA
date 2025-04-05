// Node class to represent a tree node

package Tree;
class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Class to build a binary tree from an array
class TreeBuilder {
    static int index; // Static index to track position in array

    // Method to build the binary tree
    public static Node buildTree(int[] nodes) {
        if (index >= nodes.length || nodes[index] == -1) {
            index++; // Move index forward
            return null; // Return null for empty nodes (-1)
        }

        // Create a new node
        Node newNode = new Node(nodes[index++]);

        // Recursively build left and right subtrees
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
}

// Preorder Traversal class
public class PreorderTraversal {

    // Preorder Traversal (Root -> Left -> Right)
    public static void preorder(Node root) {
        if (root == null) {
            return; // Return for null nodes
        }

        // Print current node
        System.out.print(root.data + " ");

        // Recursively traverse left and right subtrees
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // Define a binary tree using an array representation
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Reset index before building the tree
        TreeBuilder.index = 0;
        
        // Build the binary tree from the array
        Node root = TreeBuilder.buildTree(nodes);

        // Print Preorder Traversal result
        System.out.println("Preorder Traversal:");
        preorder(root);
    }
}
