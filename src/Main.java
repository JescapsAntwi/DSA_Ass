public class Main {
    public static void main(String[] args) {

        // Part A
        System.out.println("Part A: Insert and Search");
        PartA directoryA = new PartA();
        directoryA.insert("Kwame", "123-4567");
        directoryA.insert("Ama", "987-6543");
        directoryA.insert("Yaw", "234-5678");
        System.out.println("Ama's phone number: " + directoryA.search("Ama")); // This outputs 987-6543


        // Part B
        System.out.println("\nPart B: Insert and Delete");
        PartB directoryB = new PartB();
        directoryB.insert("Kwame", "123-4567");
        directoryB.insert("Ama", "987-6543");
        directoryB.insert("Yaw", "234-5678");
        directoryB.delete("Ama");
        System.out.println("Ama's phone number after deletion: " + directoryB.search("Ama")); // This outputs null


        // Part C
        System.out.println("\nPart C: Insert and Print In-Order");
        PartC directoryC = new PartC();
        directoryC.insert("Kwame", "123-4567");
        directoryC.insert("Ama", "987-6543");
        directoryC.insert("Yaw", "234-5678");
        directoryC.insert("Afia", "876-5432");
        System.out.println("Telephone Directory (In-Order):");
        directoryC.printDirectory(); // This prints Afia, Ama, Kwame, Yaw in order.
    }
}