import java.util.*;

class Vertex {

    public Object name;
    boolean wasVisited;

    public Vertex(Object v) {
        name = v;
        wasVisited = false;
    }
}

class DirectedGraph {

    private final int max = 20;
    private int con[][];
    private int size = 0;
    private Vertex vertexList[];
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private Map<Integer, Integer> index;
    private ArrayList<String> hasil;

    public DirectedGraph() {
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

    public void addVertex(int lab) {
        index.put(lab, size);
        vertexList[size] = new Vertex(lab);
        size++;
    }

    public void addEdgeDouble(int start, int end) {
        con[index.get(start)][index.get(end)] = 1;
        con[index.get(end)][index.get(start)] = 1;
    }

    public void addEdge(int start, int end) {
        con[index.get(start)][index.get(end)] = 1;
    }

    public int getAdjUnvisitedVertex(int v) {
        for (Vertex vertex : vertexList) {
            if (con[index.get(v)][index.get(vertex.name)] == 1 && vertexList[index.get(vertex.name)].wasVisited == false) {
                return Integer.parseInt(vertex.name + "");
            }
            if (Integer.parseInt(vertex.name + "") == size) {
                break;
            }
        }
        return -1;
    }

    public void bfs(int start) {
        vertexList[index.get(start)].wasVisited = true;
        hasil.add(vertexList[index.get(start)].name + "");
        queue.add(Integer.parseInt(vertexList[index.get(start)].name + ""));
        int v2;
        System.out.print("ACTION\t\tQUEUE\t\tRESULT");
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            printStep("queue", "Remove " + v1);
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[index.get(v2)].wasVisited = true;
                hasil.add(vertexList[index.get(v2)].name + "");
                queue.add(Integer.parseInt(vertexList[index.get(v2)].name + ""));
                printStep("queue", "Visit " + v2);
            }
        }
        System.out.print("\n\nResult : ");
        printResult();
        for (int j = 0; j < size; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public void dfs(int start) {
        vertexList[index.get(start)].wasVisited = true;
        hasil.add(vertexList[index.get(start)].name + "");
        stack.push(Integer.parseInt(vertexList[index.get(start)].name + ""));
        System.out.print("ACTION\t\tSTACK\t\tRESULT");
        while (!stack.isEmpty()) // until stack empty,
        {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) // if no such vertex,
            {
                printStep("stack", "Remove " + stack.pop());
            } else // if it exists,
            {
                vertexList[index.get(v)].wasVisited = true;
                hasil.add(vertexList[index.get(v)].name + "");
                stack.push(Integer.parseInt(vertexList[index.get(v)].name + ""));
                printStep("stack", "Visit " + v);
            }
        } // end while
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
        String Out = "";
        for (int i = 0; i < queue.size(); i++) {
            Out = Out + (out[i]) + "";
            if (i != queue.size() - 1) {
                Out = Out + ("-") + "";
            }
        }
        System.out.printf("%-16s", Out);
    }

    public void printStack() {
        Object out[] = stack.toArray();
        String Out = "";
        for (int i = 0; i < stack.size(); i++) {
            Out = Out + (out[i]) + "";
            if (i != stack.size() - 1) {
                Out = Out + ("-") + "";
            }
        }
        System.out.printf("%-16s", Out);
    }

    public void printStep(String type, String action) {

        System.out.printf("\n%-15s ", action);

        if ("queue".equals(type)) {
            printQueue();
        } else {
            printStack();
        }
        printResult();

    }
}

/**
 *
 * @author ACER
 */
public class Digraph {

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        g.addVertex(9);
        g.addVertex(10);
        g.addVertex(11);

        g.addEdgeDouble(1, 2);
        g.addEdgeDouble(5, 2);
        g.addEdgeDouble(6, 7);
        g.addEdgeDouble(5, 9);
        g.addEdgeDouble(8, 9);
        g.addEdgeDouble(7, 11);
        g.addEdge(1, 4);
        g.addEdge(4, 6);
        g.addEdge(5, 3);
        g.addEdge(5, 7);
        g.addEdge(8, 11);
        g.addEdge(11, 10);

        g.dfs(1);
        System.out.println("");
    }
}