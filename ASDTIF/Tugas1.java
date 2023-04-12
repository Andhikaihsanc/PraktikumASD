package ASDTIF;
import java.util.*;

public class Tugas1 {
    public static void main(String[] args) {
    LinkedList<String>web = new LinkedList<String>();
    Scanner in = new Scanner(System.in);

    
}

class Node {

    private char data;
    private Node next;
    private Node prev;

    //Konstruktor 1
    Node() {
    }

    //Konstruktor 2
    Node(char data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node head;
    Node tail;
    int size = 0;
    int sameChar = 0;

    //Method cek node kosong atau tidak
    public boolean isEmpty() {
        return head == null;
    }

    //Method tambah node di kanan
    public void addNext(char data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //Method tambah node di kiri
    public void addPrev(char data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
}

}