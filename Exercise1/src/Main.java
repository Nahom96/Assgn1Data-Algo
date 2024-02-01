public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> L = new DoublyLinkedList<>();
        L.addFirst("Peter");
        L.addFirst("Justinian");
        L.addFirst("Araya");

        DoublyLinkedList<String> M = new DoublyLinkedList<>();
        M.addFirst("Alexander");
        M.addFirst("Nahom");
        M.addFirst("Ali");

        M.addTwo(L);
        M.show();

    }

}
