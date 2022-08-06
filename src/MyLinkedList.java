public class MyLinkedList<E> {
    class Node {
        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }

        Object getData() {
            return data;
        }
    }

    Node head;
    private int numNodes = 0;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, E e) {
        if (index >= numNodes) throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public void remove(int index) {
        if (index >= numNodes) throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    public void remove(E o) {
        remove(indexOf(o));
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> l = new MyLinkedList<E>(head.data);

        Node temp = head;

        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
            l.addLast((E) temp.data);
        }

        return l;
    }

    public boolean contains(E o) {
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        return found;
    }

    public int indexOf(E o) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
}