

class Node {
    Object data;
    Node next;
    Node prev;

    Node(Object data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

// class Deque {
// int size = 0;
// Node depan, belakang;

// public Deque(){
// depan=belakang=null;
// }
// boolean isEmpty (){
// return(size==0);
// }

// void addFront(Object input){
// Node temp = belakang;
// if (size == 0){
// depan=temp;
// belakang=temp;
// size++;
// } else {
// temp.next = depan;
// depan.prev = temp;
// depan = temp;
// size++;
// }
// }

// void addBack(Object input){
// Node temp = depan;
// if(size == 0){
// depan = temp;
// belakang = temp;
// size++;
// }else {
// belakang.next = temp;
// temp.prev = belakang;
// belakang = temp;
// size++;
// }
// }

// void removeFront(){

// if (!isEmpty()){
// depan = null;
// belakang = null;
// size--;
// } else {
// depan = depan.next;
// depan.prev = null;
// size--;
// }
// }

// void removeBack(){
// if (!isEmpty()){
// depan = null;
// belakang = null;
// size--;
// } else {
// belakang = belakang.prev;
// belakang.next = null;
// size--;
// }

// }

// void front(){
// if(!isEmpty()){
// System.out.println(depan.data);
// }
// }

// void back(){
// if(!isEmpty()){
// System.out.println(belakang.data);
// }
// }

// void print(){
// Node temp = depan;
// while (temp != null){
// System.out.println(temp.data + " ");
// temp = temp.next;
// }
// }


//Deklarasi Class Queue
class Queue {

    int size = 0;
    Node depan, belakang;

    // Inisialisasi
    public Queue() {
        depan = belakang = null;
    }

    // Operasi Enqueue
    void enqueue(Object input) {
        Node temp = new Node(input);
        if (depan == null) {
            depan = temp;
            belakang = temp;
            size++;
        } else {
            temp.next = depan;
            depan = temp;
            size++;
        }
    }

    // Operasi Dequeue
    void dequeue() {
        Node temp = depan;
        if (belakang == depan) {
            depan = belakang = null;
        } else {
            while (temp.next != belakang) {
                temp = temp.next;
            }
            temp.next = null;
            belakang = temp;
            temp = null;
        }
        size--;
    }

    // Operasi Peek
    public Object peek() {
        return belakang.data;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deque objek = new Deque();
        int jumlah = scan.nextInt();
        for (int i = 0; i < jumlah; i++) {
            String command = scan.next();
            if (command.equalsIgnoreCase("addFront")) {
                queue.addFront(scan.nextInt());
            } else if (command.equalsIgnoreCase("addBack")) {
                queue.addBack(scan.nextInt());
            } else if (command.equalsIgnoreCase("removeFront")) {
                queue.removeFirst();
            } else if (command.equalsIgnoreCase("removeBack")) {
                queue.removeLast();
            } else if (command.equalsIgnoreCase("front")) {
                queue.front();
            } else if (command.equalsIgnoreCase("back")) {
                queue.back();
            } else if (command.equalsIgnoreCase("isEmpty")) {
                System.out.println(queue.isEmpty());
            } else if (command.equalsIgnoreCase("print")) {
                queue.print();
            }
        
    }
    
}
