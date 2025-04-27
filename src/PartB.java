import java.util.Objects;

// Class to represent the Telephone Directory using a Binary Search Tree
public class PartB {

    private Node root; // Root of the BST

    // Constructor for the TelephoneDirectory class
    public PartB() {
        this.root = null; // Initialize with an empty tree
    }

    /**
     * Inserts a new contact (name and phone number) into the Telephone Directory.
     *
     * @param name  The name of the contact to insert.
     * @param phone The phone number of the contact to insert.
     */
    public void insert(String name, String phone) {
        // Implementation of the insert operation
        // Connects to the pseudocode and brainstorming from Stage 3 (Part A)

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

    /**
     * Searches for a contact in the Telephone Directory by name.
     *
     * @param name The name of the contact to search for.
     * @return The phone number of the contact if found, null otherwise.
     */
    public String search(String name) {
        // Implementation of the search operation
        // Connects to the pseudocode and brainstorming from Stage 3 (Part A)

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

    /**
     * Deletes a contact from the Telephone Directory by name.
     *
     * @param name The name of the contact to delete.
     */
    public void delete(String name) {
        // Implementation of the delete operation
        // Connects to the pseudocode and brainstorming from Stage 3 (Part B)
        root = deleteNode(root, name);
    }

    /**
     * Recursive helper function to delete a node with the given name.
     *
     * @param currentNode The current node being examined.
     * @param name        The name of the contact to delete.
     * @return The updated subtree after deletion.
     */
    private Node deleteNode(Node currentNode, String name) {
        if (currentNode == null) { // Base case: Node not found
            return null;
        }

        if (name.compareTo(currentNode.name) < 0) { // If the name is less than the current node's name
            currentNode.left = deleteNode(currentNode.left, name); // Recurse on the left subtree
            return currentNode;
        } else if (name.compareTo(currentNode.name) > 0) { // If the name is greater than the current node's name
            currentNode.right = deleteNode(currentNode.right, name); // Recurse on the right subtree
            return currentNode;
        } else { // If the name is equal to the current node's name (Node to delete found)
            // Case 1: Node has no children (Leaf Node)
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }
            // Case 3: Node has two children
            else {
                Node successor = findMin(currentNode.right); // Find the inorder successor
                currentNode.name = successor.name;        // Copy successor's data
                currentNode.phone = successor.phone;
                currentNode.right = deleteNode(currentNode.right, successor.name); // Delete the successor
                return currentNode;
            }
        }
    }

    /**
     * Helper function to find the node with the minimum value in a subtree.
     *
     * @param node The root of the subtree.
     * @return The node with the minimum value.
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Method to print the telephone directory in order (for testing purposes)
    public void printDirectory() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.name + ": " + node.phone);
        inorderTraversal(node.right);
    }
}