import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by kjosyula on 26/09/17.
 */
public class Graph {

    int V;
    LinkedList<Node> adjListArray[];

    public Graph(int V)
    {

        if (V <=0 ){
            throw new IllegalArgumentException("Number of vertices cannot be negative or zero");
        }
        this.V = V;

        adjListArray = new LinkedList[V];

        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }


    public static Graph addEdge(Graph graph, int src, int dest, int weight)
    {

        int v = graph.V;

        if (src < 0 || src > v-1){
            throw new IllegalArgumentException("Source vertex - "+src+" is not a valid vertex");
        }

        if (dest < 0 || dest > v-1){
            throw new IllegalArgumentException("Destination vertex - "+dest+" is not a valid vertex");
        }

        Node node = new Node(dest, weight);

        graph.adjListArray[src].addFirst(node);

        Node srcNode = new Node(src, weight);

        graph.adjListArray[dest].addFirst(srcNode);

        return graph;
    }


    public static int executeTransitions(Graph graph, ArrayList<Integer> transitions)
    {
        int vertex = 0;

        for (int i=0; i< transitions.size(); i++) {

            int transition = transitions.get(i);

            for(Node node: graph.adjListArray[vertex]){

                if (node.getWeight() == transition) {
                    System.out.println(vertex + " -> " + node.getNode());
                    vertex = node.getNode();
                }
            }

        }
        return vertex;
    }

    public static int printGraph(Graph graph, int vertex)
    {

        int currentVertex = 0;
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print(v + ": ");
            for(Node node: graph.adjListArray[v]){
                System.out.print(v+" -> "+node.getNode()+"("+node.getWeight()+") ");
            }

            if (vertex == v){
                currentVertex = v;
                System.out.print(" *");
            }

            System.out.println("\n");
        }

        return currentVertex;
    }
}
