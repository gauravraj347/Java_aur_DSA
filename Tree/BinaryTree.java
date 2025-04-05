package Tree;

class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Class to build a binary tree
class TreeBuild {
    static int idx = -1; // Index to track array position

    // Method to construct binary tree from an array
    public static Node treec(int nodes[]) {
        idx++;
        if (idx >= nodes.length || nodes[idx] == -1) {
            return null; // Return null for empty nodes (-1)
        }

        Node newNode = new Node(nodes[idx]); // Create a new node
        newNode.left = treec(nodes); // Recursively build left subtree
        newNode.right = treec(nodes); // Recursively build right subtree
        return newNode;
    }

    public static void preorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");    // Print -1 for null nodes
            return;
        }
        System.out.print(root.data + " ");    // Visit root
        preorder(root.left);                  // Traverse left subtree
        preorder(root.right);                 // Traverse right subtree
    }
    public static void inorder(Node root){
        if(root==null){
            System.out.println(-1);
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}






public class BinaryTree {
    public static void main(String[] args) {
        int nodes[] = {4, 8, 9, -1, -1, 2}; // Tree input

        //TreeBuild.idx = -1; // Reset index before calling the method
        //Node root = TreeBuild.treec(nodes); // Correct method call

        TreeBuild treess=new TreeBuild();
        Node root=treess.treec(nodes);

        System.out.println("Root Node Data: " + root.data); // Print root data
    }
}
