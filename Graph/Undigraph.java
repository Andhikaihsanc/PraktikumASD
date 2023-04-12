import java.util.*;

class Vertex {

    public Object name;
    boolean wasVisited;

    public Vertex(Object v) {
        name = v;
        wasVisited = false;
    }
}

class Graph {

    private final int max = 20;
    private int con[][];
    private int size = 0;
    private Vertex vertexList[];
    private Stack<String> stack;
    private Queue<String> queue;
    private Map<String, Integer> index;
    private ArrayList<String> hasil;

    public Graph() {
        vertexList = new Vertex[max];
        con = new int[max][max];
        size = 0;
        for (int j = 0; j < max; j++) {
            for (int k = 0; k < max; k++) {
                con[j][k] = 0;
            }
        }
        stack = new Stack<>();
        queue = new LinkedList<>();
        index = new HashMap<>();
        hasil = new ArrayList<>();
    }

    public void addVertex(String lab) {
        index.put(lab, size);
        vertexList[size] = new Vertex(lab);
        size++;
    }

    public void addEdge(String start, String end) {
        con[index.get(start)][index.get(end)] = 1;
        con[index.get(end)][index.get(start)] = 1;
    }

    public String getAdjUnvisitedVertex(String v) {
        for (int i = 0; i < size; i++) {
            if (con[index.get(v)][index.get(vertexList[i].name)] == 1 && vertexList[index.get(vertexList[i].name)].wasVisited == false) {
                return vertexList[i].name + "";
            }
            if ((vertexList[i].name + "").equals(size+"")) {
                break;
            }
        }
        return "-1";
    }

    public void bfs(String start) {
        vertexList[index.get(start)].wasVisited = true;
        hasil.add(vertexList[index.get(start)].name + "");
        System.out.print("ACTION\t\tQUEUE\t\tRESULT");
        queue.add(vertexList[index.get(start)].name + "");
        printStep("queue", "Visit " + start);
        String v2;
        while (!queue.isEmpty()) {
            String v1 = queue.remove();
            printStep("queue", "Remove " + v1);
            while (!(v2 = getAdjUnvisitedVertex(v1)).equals("-1")) {
                vertexList[index.get(v2)].wasVisited = true;
                hasil.add(vertexList[index.get(v2)].name + "");
                queue.add(vertexList[index.get(v2)].name + "");
                printStep("queue", "Visit " + v2);
            }
        }
        System.out.print("\n\nResult : ");
        printResult();
        for (int j = 0; j < size; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public void dfs(String start) {
        vertexList[index.get(start)].wasVisited = true;
        hasil.add(vertexList[index.get(start)].name + "");
        stack.push(vertexList[index.get(start)].name + "");
        System.out.printf("%-15s%-15s%-15s","ACTION","STACK","RESULT");
        while (!stack.isEmpty()) 
        {
            String v = getAdjUnvisitedVertex(stack.peek());
            if (v.equals("-1"))
            {
                printStep("stack", "Remove " + stack.pop());
            } else
            {
                vertexList[index.get(v)].wasVisited = true;
                hasil.add(vertexList[index.get(v)].name + "");
                stack.push(vertexList[index.get(v)].name + "");
                printStep("stack", "Visit " + v);
            }
        }
        System.out.print("\n\nResult : ");
        printResult();
        for (int j = 0; j < size; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public void printResult() {
        for (int i = 0; i < hasil.size(); i++) {
            System.out.print(hasil.get(i));
            if (i != hasil.size() - 1) {
                System.out.print("-");
            }
        }
    }

    public void printQueue() {
        Object out[] = queue.toArray();
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(out[i] + "");
        }
    }

    public void printStack() {
        Object out[] = stack.toArray();
        String print="";
        for (int i = 0; i < stack.size(); i++) {
            print=print+(out[i] + "");
        }
        System.out.printf("%-15s",print);
    }

    public void printStep(String type, String action) {

        System.out.printf("\n%-15s",action);        
        if ("queue".equals(type)) {
            printQueue();
        } else {
            printStack();
        }
        printResult();

    }
}

public class Undigraph {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("a");
        g.addVertex("b");        
        g.addVertex("c");        
        g.addVertex("d");        
        g.addVertex("e");        
        g.addVertex("f");        
        g.addVertex("g");        
        g.addVertex("h");        
        g.addVertex("i");        
        g.addVertex("j");        
        g.addVertex("k");        
        g.addVertex("l");        
        g.addVertex("m");        

        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("d", "e");
        g.addEdge("e", "f");
        g.addEdge("h", "i");
        g.addEdge("i", "j");
        g.addEdge("a", "d");
        g.addEdge("d", "h");
        g.addEdge("b", "e");
        g.addEdge("e", "i");
        g.addEdge("c", "f");
        g.addEdge("f", "j");
        g.addEdge("f", "g");
        g.addEdge("j", "g");
        g.addEdge("g", "l");
        g.addEdge("h", "k");
        g.addEdge("i", "k");
        g.addEdge("m", "k");

        g.dfs("e");
        System.out.println("");
    }
}