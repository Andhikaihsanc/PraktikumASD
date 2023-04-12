

import java.util.Scanner;

public class KeretaBonus {
    
class Node {

    Object data;
    Node next;

    Node() {
    }

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, Node pointer) {
        this.data = data;
        this.next = pointer;
    }

}

class LL1 {

    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void inisialisasi() {
        head = tail = null;
    }

    void TambahDataAwal(Node input) {
        if (isEmpty()) {
            head = tail = head.next = tail.next = input;
        } else {
            input.next = head;
            tail.next = head = input;
        }
        size++;
    }

    void TambahDataAkhir(Node input) {
        if (isEmpty()) {
            head = tail = input;
            head.next = input;
        } else {
            input.next = head;
            tail.next = tail = input;
        }
        size++;
    }

    void removeFirst() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Data masih kosong");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.next;
                tail.next = head = temp;
                temp = null;
            }
            size--;
        }
    }

    void removeLast() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Data masih kosong");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = head;
                tail = temp;
                temp = null;
            }
            size--;
        }
    }

    void removeNode(Object key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.next.data == key) {
                    temp.next = temp.next.next;
                    if (temp.next == null)
                        tail = temp;
                    break;
                } else if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                }
                temp = temp.next;
            }
        } else
            System.out.println("Data is empty!");
        size--;
    }

    void disband(int mulai, int jumlah) {
        Node tmpNode5 = head;
        for (int i = 0; i < mulai; i++) {
            tmpNode5 = tmpNode5.next;
        }
        for (int j = mulai; j < jumlah + mulai; j++) {
            this.removeNode(tmpNode5.data);
            tmpNode5 = tmpNode5.next;
        }
    }

    void rotate() {
        Node tmpNode = head.next;

        int halfMid;
        if (size % 2 == 0) {
            halfMid = size / 2;
        } else {
            halfMid = (size + 1) / 2;
        }

        for (int i = 1; i < halfMid-1; i++) {
            tmpNode = tmpNode.next;
        }

        Node prevNode = null;
        Node nextNode = null;
        
        for (int i = 0; i < size; i++) {
            nextNode = tmpNode.next;
            tmpNode.next = prevNode;
            prevNode = tmpNode;
            tmpNode = nextNode;
        }
    }

    public void check() {
        Node tmpNode1 = head;
        while (tmpNode1 != null) {
            System.out.print(tmpNode1.data + " ");
            tmpNode1 = tmpNode1.next;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
      }
}


public class Solution {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        LL1 a = new LL1();
        int in1 = x.nextInt();
        for (int i = 0; i < in1; i++) {
            a.TambahDataAkhir(new Node(x.nextInt()));
        }
        int in2 = x.nextInt();
        x.nextLine();
        for (int i = 0; i < in2; i++) {
            String arr[] = x.nextLine().split(" ");

            switch (arr[0]) {
                case "Disband": {
                    a.disband(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                }
                break;
                case "Rotate": {
                    a.rotate();
                }
                break;
                case "Add": {
                    a.add(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                }
                break;
                case "Check": {
                    a.check();
                }
                break;

            }

        }
        
    }

}
}