public class DoublyLinkedList<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setPrev(Node<E> p){
            prev = p;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
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
        return header.getNext().getElement();
    }
    public E last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void addTwo(DoublyLinkedList<E> L){
        Node<E> thisLast = trailer.getPrev();
        Node<E> LFirst = L.header.getNext();

        thisLast.setNext(LFirst);
        LFirst.setPrev(thisLast);

        trailer = L.trailer;
    }

    public void show(){
        Node<E> n = header.getNext();
        while(n != trailer){
            System.out.println(n.getElement());
            n = n.getNext();
        }
    }
}
