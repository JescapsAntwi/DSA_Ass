import java.util.Objects;

// Class to represent a node in the Binary Search Tree
class Node {
    String name;
    String phone;
    Node left;
    Node right;

    // Constructor for the Node class
    public Node(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.left = null;
        this.right = null;
    }

    // Override equals and hashcode methods.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) && Objects.equals(phone, node.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}