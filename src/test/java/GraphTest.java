import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjosyula on 26/09/17.
 */
public class GraphTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumberOfVertices() {
        Graph graph = new Graph(-1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroNumberOfVertices() {
        Graph graph = new Graph(0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSrcVertex() {

        Graph graph = new Graph(3);

        Graph.addEdge(graph, 4, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDestVertex() {

        Graph graph = new Graph(3);

        Graph.addEdge(graph, 0, 4, 1);
    }


    @Test
    public void testStateTransition() {

        Graph graph = new Graph(3);

        graph = Graph.addEdge(graph,0,1,1);
        graph = Graph.addEdge(graph,1,2,2);

        ArrayList<Integer> transitions = new ArrayList<>();
        transitions.add(1);
        transitions.add(2);

        int finalVertex = Graph.executeTransitions(graph, transitions);

        assertEquals(finalVertex, 2);
    }


    @Test
    public void testStateTransitionAndCurrentVertex() {

        Graph graph = new Graph(3);

        graph = Graph.addEdge(graph,0,1,1);
        graph = Graph.addEdge(graph,1,2,2);

        ArrayList<Integer> transitions = new ArrayList<>();
        transitions.add(1);
        transitions.add(2);

        int finalVertex = Graph.executeTransitions(graph, transitions);
        finalVertex = Graph.printGraph(graph, finalVertex);

        assertEquals(finalVertex, 2);
    }

    @Test
    public void testInvalidStateTransition() {

        Graph graph = new Graph(3);

        graph = Graph.addEdge(graph,0,1,1);
        graph = Graph.addEdge(graph,1,2,2);

        ArrayList<Integer> transitions = new ArrayList<>();
        transitions.add(1);
        transitions.add(3);

        int finalVertex = Graph.executeTransitions(graph, transitions);

        assertEquals(finalVertex, 1);
    }


    @Test
    public void testStateTransitionAndVertexForLargeGraph() {

        Graph graph = new Graph(999);

        graph = Graph.addEdge(graph,0,1,1);
        graph = Graph.addEdge(graph,1,2,2);

        ArrayList<Integer> transitions = new ArrayList<>();
        transitions.add(1);
        transitions.add(3);

        int finalVertex = Graph.executeTransitions(graph, transitions);
        finalVertex = Graph.printGraph(graph, finalVertex);
        assertEquals(finalVertex, 1);
    }
}
