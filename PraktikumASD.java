

class Node {

    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}

class LL {

    Node head, tail;
    int size = 0;

    public LL() {
        this.inisialisasi();
    }

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (size == 0) {
            head = input;
            tail = input;
            size++;
        } else {
            input.next = head;
            head = input;
            size++;
        }
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(char key, Node input) {
        Node temp = head;
        do {
            if (temp.data == key) {
                input.next = temp.next;
                temp.next = input;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != null);

    }

    void insertBefore(char key, Node input) {
        Node temp = head;
        while (temp != null) {
            if ((temp.data == key) && (temp == head)) {
                this.addFirst(input);

                break;
            } else if (temp.next.data == key) {
                input.next = temp.next;
                temp.next = input;

                break;
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.next;
                head = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(char key) {
        Node temp = head, nextPointer = null;
        if (isEmpty()) {
            System.out.println("Data is empty");
        } else {
            while (temp.data != key) {
                nextPointer = temp.next.next;
                temp = temp.next;
            }
            temp = head;
            while (temp.next != null) {
                if (temp.next.data == key) {

                    temp.next = nextPointer;
                    size--;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void addSorted(int data) {
        Node baru = new Node(data);
        if (size == 0) {
            head = tail = baru;
        } else if (head.data > baru.data) {
            baru.next = head;
            head = baru;
        } else {
            Node now = head;
            while (now.data < baru.data) {
                now = now.next;
            }
            if (now == tail) {
                tail.next = baru;
                tail = baru;
            } else {
                baru.next = now.next;
                now.next = baru;
            }
        }
        size++;
    }

    public void cetakLinkedlist() {
        Node temp = head;
        int x = 0;
        while (temp != null) {
            System.out.println("DataIndex-" + x + "  :" + temp.data);
            temp = temp.next;
            x++;
        }
    }

    public static void main(String[] args) {
        Cars list = new Cars();
        list.addFirst(new Node('I'));
        list.addFirst(new Node('J'));
        list.addLast(new Node('N'));
        list.addLast(new Node('I'));
        list.insertBefore('N', new Node('A'));
        list.insertAfter('I', new Node('H'));
        list.insertBefore('A', new Node('S'));
        list.insertAfter('H', new Node('A'));
        list.removeFirst();
        list.removeLast();
        list.remove('A');

        list.cetakLinkedlist();
        //J I H A S A N I
    }

}
