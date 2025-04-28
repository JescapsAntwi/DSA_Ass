public class Main {
    public static void main(String[] args) {

        // Part A
        System.out.println("Part A: Insert and Search");
        PartA directoryA = new PartA();
        directoryA.insert("Kwame", "0594175628");
        directoryA.insert("Ama", "0208494360");
        directoryA.insert("Yaw", "0204277589");
        System.out.println("Ama's phone number: " + directoryA.search("Ama")); // This outputs 0208494360


        // Part B
        System.out.println("\nPart B: Insert and Delete");
        PartB directoryB = new PartB();
        directoryB.insert("Kwame", "0594175628");
        directoryB.insert("Ama", "0208494360");
        directoryB.insert("Yaw", "0204277589");
        directoryB.delete("Ama");
        System.out.println("Ama's phone number after deletion: " + directoryB.search("Ama")); // This outputs null


        // Part C
        System.out.println("\nPart C: Insert and Print In-Order");
        PartC directoryC = new PartC();
        directoryC.insert("Kwame", "0594175628");
        directoryC.insert("Ama", "0208494360");
        directoryC.insert("Yaw", "0204277589");
        directoryC.insert("Afia", "0249329210");
        System.out.println("Telephone Directory (In-Order):");
        directoryC.printDirectory(); // This prints Afia, Ama, Kwame, Yaw in order.
    }
}