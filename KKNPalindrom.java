
import java.util.*;
class Node {
    Object data;
    Node next;
    Node prev;
    Node() {
    }

    Node(Object theData) {
        data = theData;
    }

    Node(Object theData, Node thePrevious, Node theNext) {
        data = theData;
        prev = thePrevious;
        next = theNext;
    }
}

class DoubleLL {
    Node head;
    Node tail;
    int size = 0;

    void inisialisasi() {
        Node head = null;
        Node tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addLast(Node input) {
        Node node = new Node(input.data);
        if (head == null) {
            head = tail = node;
            input.data = node.data;
            size++;
        } else {
            input.data = node.data;
            node = tail.next;
            node.prev = tail;
            tail = node;
            size++;
        }
        
    }

    public String read() {
        Node smntra = head;
        smntra.next = head.next;
        while (smntra != null) {
            smntra = smntra.next;
        }
        return null;
    }
    
    public String reverse() {
        Node smntra1 = tail;
        smntra1.prev = tail.prev;
        while (smntra1 != null) {
            smntra1 = smntra1.prev;
        }
        return null;
    }
    
    public boolean isPalindrome(){
        Node maju = head;
        Node belakang = tail;
        boolean palindrom = true;
        int tengah = size / 2;

        // Cek kesamaan data
        for (int i = 0; i < tengah; i++) {
            if (!maju.data.equals(belakang.data)) {
                palindrom = false;
                break;
            }
            maju = maju.next;
            belakang = belakang.prev;
        }

        if (palindrom == true) {
            System.out.println("Penghuni Rock Bottom");
        } else {
            System.out.println("Bukan penghuni Rock Bottom");
        }
        return palindrom;
    }

}

public class DLL {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DoubleLL dll = new DoubleLL();
        String input=in.nextLine();
        for(int i=0; i<input.length(); i++){
            dll.addLast(new Node(input.charAt(i)+""));
        }
        dll.isPalindrome();
    }
}