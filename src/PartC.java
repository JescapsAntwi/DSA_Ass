// This class represents the Telephone Directory using a Binary Search Tree
public class PartC {

    private Node root; // Root of the BST

    // Constructor for the TelephoneDirectory class
    public PartC() {
        this.root = null; // Initialize with an empty tree
    }


    public void insert(String name, String phone) {

        Node newNode = new Node(name, phone); // Create a new node

        if (root == null) { // If the tree is empty
            root = newNode; // The new node becomes the root
            return;
        }

        Node currentNode = root; // Start at the root

        while (true) { // Loop until we find the right spot
            if (name.compareTo(currentNode.name) < 0) { // If the new name is less than the current name
                if (currentNode.left == null) { // If the left child is empty
                    currentNode.left = newNode; // Insert the new node here
                    return;
                } else { // Otherwise, move to the left child
                    currentNode = currentNode.left;
                }
            } else { // If the new name is greater than or equal to the current name
                if (currentNode.right == null) { // If the right child is empty
                    currentNode.right = newNode; // Insert the new node here
                    return;
                } else { // Otherwise, move to the right child
                    currentNode = currentNode.right;
                }
            }
        }
    }


    public String search(String name) {

        if (root == null) { // If the tree is empty
            return null; // Return null if not found
        }

        Node currentNode = root; // Start at the root

        while (currentNode != null) { // Loop until we find the name or reach a leaf
            if (name.equals(currentNode.name)) { // If we find the name
                return currentNode.phone; // Return the phone number
            } else if (name.compareTo(currentNode.name) < 0) { // If the name is less than the current name
                currentNode = currentNode.left; // Go to the left child
            } else { // If the name is greater than the current name
                currentNode = currentNode.right; // Go to the right child
            }
        }

        return null; // Return null if not found
    }




    public void printDirectory() {

        inorderTraversal(root);
    }


    private void inorderTraversal(Node node) {
        if (node == null) { // Base case: If the node is null, return
            return;
        }

        inorderTraversal(node.left);         // Recursively print the left subtree
        System.out.println(node.name + ": " + node.phone); // Print the node's data
        inorderTraversal(node.right);        // Recursively print the right subtree
    }
}