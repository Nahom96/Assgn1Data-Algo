public class CircularlyLinkedList<E> implements Cloneable {

    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList(){}
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
        if(size == 0){
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        else{
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        }
        else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
    }
    public void show(){

        Node<E> start = tail.getNext(); // This is the head in a circularly linked list
        Node<E> n = start;
        do {
            System.out.println(n.getElement());
            n = n.getNext();
        } while (n != start);
    }
    @Override
    public CircularlyLinkedList<E> clone() {
        try {
            CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone();
            if (size > 0) {
                other.tail = new Node<>(tail.getElement(), null);
                Node<E> walk = tail.getNext();
                Node<E> otherTail = other.tail;
                while (walk != tail) {
                    Node<E> newest = new Node<>(walk.getElement(), null);
                    otherTail.setNext(newest);
                    otherTail = newest;
                    walk = walk.getNext();
                }
                otherTail.setNext(other.tail);
            }
            return other;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
