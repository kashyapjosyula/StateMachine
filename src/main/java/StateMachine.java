import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kjosyula on 26/09/17.
 */
public class StateMachine {

    public static void main(String args[])
    {

        System.out.println("Number of vertices?");
        Scanner in = new Scanner(System.in);

        int V = in.nextInt();

        Graph graph = new Graph(V);

        System.out.println("Number of edges to add?");

        int numberOfEdges = in.nextInt();

        System.out.println("Enter "+numberOfEdges+" src and dest vertex pairs ");

        for (int i=0; i<numberOfEdges; i++) {

            int v1 = in.nextInt();
            int v2 = in.nextInt();

            graph = Graph.addEdge(graph, v1, v2, i+1);
        }

        System.out.println("Number of transitions?");

        int numberOfTransitions = in.nextInt();


        ArrayList<Integer> transitions = new ArrayList<>();


        System.out.println("Enter transitions");

        for (int i=0; i<numberOfTransitions; i++) {

            int transition = in.nextInt();
            transitions.add(transition);
        }

        int vertex = Graph.executeTransitions(graph, transitions);

        Graph.printGraph(graph, vertex);
    }
}
