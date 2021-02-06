import graph.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private final Graph<String, String> graph = new Graph<>();

    @Test
    void addingNode(){
        graph.addNode("testNode1");
        assertEquals("testNode1", graph.getNodes().get(0));
        graph.addNode("testNode2");
        assertEquals("testNode1", graph.getNodes().get(0));
        assertEquals("testNode2", graph.getNodes().get(1));
    }

    @Test
    void removingNode(){
        graph.addNode("testNode1");
        graph.addNode("testNode2");
        graph.removeNode(0);
        assertEquals("testNode2", graph.getNodes().get(0));
        graph.removeNode(0);
    }

    @Test
    void addingEdge(){
        graph.addNode("testNode1");
        graph.addNode("testNode2");
        graph.addNode("testNode3");
        for (int i = 0; i < graph.getNodes().size(); i++) {
            for (int j = 0; j < graph.getNodes().size(); j++) {
                graph.addEdge(i,j, "testInfo"+i+j);
                assertEquals(graph.getEdges().get(i).get(j), "testInfo"+i+j);
                for (int k = i; k < graph.getNodes().size(); k++) {
                    for (int l = j+1; l < graph.getNodes().size(); l++) {
                        assertNull(graph.getEdges().get(k).get(l));
                    }
                }
            }
        }
    }

    @Test
    void removingEdge(){
        graph.addNode("testNode1");
        graph.addNode("testNode2");
        graph.addNode("testNode3");
        for (int i = 0; i < graph.getNodes().size(); i++) {
            for (int j = 0; j < graph.getNodes().size(); j++) {
                graph.addEdge(i,j, "testInfo"+i+j);
            }
        }
        for (int i = 0; i < graph.getNodes().size(); i++) {
            for (int j = 0; j < graph.getNodes().size(); j++) {
                graph.removeEdge(i,j);
                assertNull(graph.getEdges().get(i).get(j));
                for (int k = i; k < graph.getNodes().size(); k++) {
                    for (int l = j+1; l < graph.getNodes().size(); l++) {
                        assertNotNull(graph.getEdges().get(k).get(l));
                    }
                }
            }
        }

    }
}
