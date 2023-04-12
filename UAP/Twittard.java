package UAP;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// class Node {
//     int data;
//     Node next;

//     Node(int data, Node next) {
//         this.data = data;
//         this.next = next;
//     }
// }

// class Graph {
//     Node[] nodes;
//     int length;
//     LinkedList<> requests = new LinkedList(); //Terserah mau pake library atau bikin sendiri.

//     Graph(int length) {
//         this.length = length;
//         nodes = new Node[length];
//     }

//     void requestFollow(int follower, int followed) {
//         //Isi sendiri
//     }

//     void seeRequests(int userId) {
//         //Isi sendiri
//     }

//     void acceptFollow(int userId) {
//         //Isi sendiri
//       	System.out.println("No requests");
//     }

//     void checkFollowers(int userId) {
//         ArrayList<Integer> followers = new ArrayList<>();
// 		//Isi sendiri, disarankan pakai Arraylist karena nambahin elemen lebih enak.
//         if (followers.size() == 0) {
//             System.out.println("No followers");
//             return;
//         }
//     }
// }

// public class Twittard {

//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int graphLength = in.nextInt();
//         Graph graph = new Graph(graphLength);
//         int actions = in.nextInt();
//         in.nextLine();
//         for (int i = 0; i < actions; i++) {
//             String action = in.nextLine();
//             String[] actionList = action.split(" ");
//             switch (actionList[0]) {
//                 case "FOLLOW":
//                     graph.requestFollow(Integer.parseInt(actionList[1]), Integer.parseInt(actionList[2]));
//                     break;
//                 case "SEEREQUESTS":
//                     graph.seeRequests(Integer.parseInt(actionList[1]));
//                     break;
//                 case "ACCEPT":
//                     graph.acceptFollow(Integer.parseInt(actionList[1]));
//                     break;
//                 case "FOLLOWERS":
//                     graph.checkFollowers(Integer.parseInt(actionList[1]));
//                     break;
//             }
//         }
//     }
// }



class Graph {
    Node[] node;
    int length;

    Graph(int panjang) {
        this.length = panjang;
        node = new Node[panjang];
        for(int i = 0; i < panjang; i++){
            node[i] = new Node(i);
        }
    }

    void requestFollow(int follower, int followed) {
        node[followed].requests.add(node[follower]);
    }

    void seeRequests(int userId) {
        Iterator<Node> daftar = node[userId].requests.iterator();
        if(!daftar.hasNext()){
            return;
        }
        while(daftar.hasNext()){
            System.out.print(daftar.next().data + " ");
        }
        System.out.println();
    }

    void acceptFollow(int userId) {
        int size = node[userId].requests.size();
        if(size == 0){
            System.out.println("No requests");
            return; 
        }
        Node head = node[userId].requests.peek();
        node[userId].requests.remove();
        node[userId].follower.add(head);
    }

    void checkFollowers(int userId) {
        ArrayList<Integer> followers = new ArrayList<>();
		Iterator<Node> companion = node[userId].follower.iterator();
        if(!companion.hasNext()){
            System.out.println("No followers");
            return;
        }
        while(companion.hasNext()){
            followers.add(companion.next().data);
        }
        for(int x : followers){
            System.out.print(x + " ");
        }
        System.out.println();
    }
  
    class Node {
        int data;
        LinkedList<Node> follower = new LinkedList<Node>();
        Queue<Node> requests = new LinkedList<Node>();
    
        Node(int data){
            this.data = data;
        }
    }
}

public class Twittard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int graphLength = in.nextInt();
        Graph graph = new Graph(graphLength);
        int actions = in.nextInt();
        in.nextLine();
        for (int i = 0; i < actions; i++) {
            String action = in.nextLine();
            String[] actionList = action.split(" ");
            switch (actionList[0]) {
                case "FOLLOW":
                    graph.requestFollow(Integer.parseInt(actionList[1]), Integer.parseInt(actionList[2]));
                    break;
                case "SEEREQUESTS":
                    graph.seeRequests(Integer.parseInt(actionList[1]));
                    break;
                case "ACCEPT":
                    graph.acceptFollow(Integer.parseInt(actionList[1]));
                    break;
                case "FOLLOWERS":
                    graph.checkFollowers(Integer.parseInt(actionList[1]));
                    break;
            }
        }
    }
}