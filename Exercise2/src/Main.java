public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> num = new SinglyLinkedList<>();
        num.addLast("Pizza");
        num.addLast("Bugger");
        num.addLast("Fries");
        num.addLast("Coke");
        num.printList();

        SinglyLinkedList.Node<String> n1 = num.findNode("Bugger");
        SinglyLinkedList.Node<String> n2 = num.findNode("Fries");

        if (n1 != null && n2 != null) {
            num.swapNodes(n1, n2);
            System.out.println("After swapping 'Bugger' and 'Fries':");
            num.printList();
        } else {
            System.out.println("One or both nodes not found.");
        }
    }


}