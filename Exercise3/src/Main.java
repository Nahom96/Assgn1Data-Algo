public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList<String> num = new CircularlyLinkedList<>();
        num.addFirst("Nahom");
        num.addFirst("John");
        num.addFirst("Peter");
        num.addFirst("Alex");
        num.show();
        System.out.println("*********LAST*********");

        CircularlyLinkedList<String> clone = num.clone();

        num.addLast("David");
        num.removeFirst();

        clone.addLast("James");
        clone.addLast("Joe");
        clone.show();
    }
}