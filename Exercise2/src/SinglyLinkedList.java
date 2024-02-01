public class SinglyLinkedList<E> {

    public static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e){
            element = e;
        }
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public void setElement(E n){ element = n;}
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    public Node<E> head = null;
    public Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList(){}
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }
    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size == 0){
            tail = head;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        }
        else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0){
            tail = null;
        }
        return answer;
    }
    public void swapNodes(Node<E> node1, Node<E> node2) {
        if (node1 == node2) return;

        Node<E> prev1 = null, prev2 = null, current = head;
        while (current != null && (prev1 == null || prev2 == null)) {
            if (current.next == node1) prev1 = current;
            else if (current.next == node2) prev2 = current;
            current = current.next;
        }

        if ((prev1 == null && node1 != head) || (prev2 == null && node2 != head)) return;

        if (prev1 != null) prev1.next = node2;
        if (prev2 != null) prev2.next = node1;

        Node<E> temp = node1.next;
        node1.next = node2.next;
        node2.next = (node1 == prev2) ? node1 : temp;

        if (head == node1) head = node2;
        else if (head == node2) head = node1;

        if (tail == node1) tail = node2;
        else if (tail == node2) tail = node1;
    }
    public Node<E> findNode(E value){
        Node<E> n = head;
        while(n != null){
            if(n.getElement().equals(value)){
                return n;
            }
            n = n.getNext();
        }
        return null;
    }
    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }


}
