import java.util.Objects;

// Class to represent the Telephone Directory using a Binary Search Tree
public class PartC {

    private Node root; // Root of the BST

    // Constructor for the TelephoneDirectory class
    public PartC() {
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
     * Prints the Telephone Directory in ascending order of contact names.
     */
    public void printDirectory() {
        // Implementation of the print operation using in-order traversal
        // Connects to the pseudocode and brainstorming from Stage 3 (Part C)
        inorderTraversal(root);
    }

    /**
     * Recursive helper function to perform in-order traversal of the BST.
     *
     * @param node The current node being visited.
     */
    private void inorderTraversal(Node node) {
        if (node == null) { // Base case: If the node is null, return (Pseudocode: if node is NULL)
            return;
        }

        inorderTraversal(node.left);         // Recursively print the left subtree (Pseudocode: printInOrder(node.left))
        System.out.println(node.name + ": " + node.phone); // Print the node's data (Pseudocode: print node.name, node.phone)
        inorderTraversal(node.right);        // Recursively print the right subtree (Pseudocode: printInOrder(node.right))
    }


}