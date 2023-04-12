package Tugas2;

import java.util.Scanner;

class Node {
    // Membuat Variabel default
    int data;
    int expired = 5; // to
    Node next;
    Node prev;

    //Membuat construtor 
    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
    // Pada class node, menggunakan variabel default, sehingga tidak perlu menggunakan
    // Constructor yang dibuat ada 3, mulai dari kosong, berisi data, dan berisi double linklisted

    class StackBeras {

    Node top;
    Node bottom;
    int size;
    // ++
    int berasExpired = 0;

    boolean isEmpty() {
        return size == 0;
    }

    //Membuat Method
    void kurangiUmur() {

        // START
        Node temp = top;
        while (temp != null) {
            temp.expired--;
            if (temp.expired == 0) {
                berasExpired++;
                System.out.println(berasExpired + " beras telah kedaluarsa");
            }
            temp = temp.next;
        }
        // END
        /* Jadi pada method ini menggunakan perulangan untuk mengecek apakah
        beras yang disimpan sudah kadaluarsa */
    }

    void push(int tambah) {

        Node temp = new Node(tambah);

        if (isEmpty()) {
            top = bottom = temp;
        } else {
            temp.next = top;
            top.prev = temp;
            top = temp;
        }
        size++;
        kurangiUmur();
        /* Method ini berfungsi untuk menambahkan beras */
    }

    void pop() {

        if (!isEmpty()) {
            if (size == 1) {
                top = bottom = null;
            } else {
                top = top.prev;
                top.next = null;
            }
            size--;
            kurangiUmur();
        }
         /* Method ini berfungsi untuk menambahkan beras */
    }

    void print() {

        int tumpukan = 1;
        Node temp = bottom;
        System.out.println("======= APLIKASI STACK BERAS =========");
        System.out.println("TUMPUKKAN DARI PALING ATAS");

        while (temp != null) {
            System.out.println("Tumpukan ke-" + tumpukan + " : " + temp.data);
            temp = temp.prev; 
            tumpukan++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jumlah = in.nextInt();

        StackBeras stackBeras = new StackBeras();
        for (int i = 0; i < jumlah; i++) {
            String perintah = in.next().toLowerCase();

            if (perintah.equals("push")) {
                int num = in.nextInt();
                stackBeras.push(num);
            } else if (perintah.equals("pop")) {
                stackBeras.pop();
            } else if (perintah.equals("print")) {
                stackBeras.print();
            }
        }
        in.close();
    }
}
