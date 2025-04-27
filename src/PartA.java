import java.util.Objects;

// Class to represent the Telephone Directory using a Binary Search Tree
public class PartA {

    private Node root; // Root of the BST

    // Constructor for the TelephoneDirectory class
    public PartA() {
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
        // Connects to the pseudocode and brainstorming from Stage 3

        Node newNode = new Node(name, phone); // Create a new node (Pseudocode: newNode = Node(name, phone))

        if (root == null) { // If the tree is empty (Pseudocode: if root is NULL)
            root = newNode; // The new node becomes the root (Pseudocode: root = newNode)
            return;
        }

        Node currentNode = root; // Start at the root (Pseudocode: currentNode = root)

        while (true) { // Loop until we find the right spot (Pseudocode: while TRUE)
            if (name.compareTo(currentNode.name) < 0) { // If the new name is less than the current name (Pseudocode: if name < currentNode.name)
                if (currentNode.left == null) { // If the left child is empty (Pseudocode: if currentNode.left is NULL)
                    currentNode.left = newNode; // Insert the new node here (Pseudocode: currentNode.left = newNode)
                    return;
                } else { // Otherwise, move to the left child (Pseudocode: else)
                    currentNode = currentNode.left; // (Pseudocode: currentNode = currentNode.left)
                }
            } else { // If the new name is greater than or equal to the current name (Pseudocode: else if name >= currentNode.name)
                if (currentNode.right == null) { // If the right child is empty (Pseudocode: if currentNode.right is NULL)
                    currentNode.right = newNode; // Insert the new node here (Pseudocode: currentNode.right = newNode)
                    return;
                } else { // Otherwise, move to the right child (Pseudocode: else)
                    currentNode = currentNode.right; // (Pseudocode: currentNode = currentNode.right)
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
        // Connects to the pseudocode and brainstorming from Stage 3

        if (root == null) { // If the tree is empty (Pseudocode: if root is NULL)
            return null; // Return null if not found (Pseudocode: return NULL)
        }

        Node currentNode = root; // Start at the root (Pseudocode: currentNode = root)

        while (currentNode != null) { // Loop until we find the name or reach a leaf (Pseudocode: while currentNode is not NULL)
            if (name.equals(currentNode.name)) { // If we find the name (Pseudocode: if name == currentNode.name)
                return currentNode.phone; // Return the phone number (Pseudocode: return currentNode.phone)
            } else if (name.compareTo(currentNode.name) < 0) { // If the name is less than the current name (Pseudocode: else if name < currentNode.name)
                currentNode = currentNode.left; // Go to the left child (Pseudocode: currentNode = currentNode.left)
            } else { // If the name is greater than the current name (Pseudocode: else)
                currentNode = currentNode.right; // Go to the right child (Pseudocode: currentNode = currentNode.right)
            }
        }

        return null; // Return null if not found (Pseudocode: return NULL)
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