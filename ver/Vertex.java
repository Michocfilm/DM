import java.util.ArrayList;
import java.util.List;
class Vertex {
    private String id;

    public Vertex(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
class Edge {
    private String id;      
    private Vertex endpoint1;
    private Vertex endpoint2;

    public Edge(String id, Vertex v1, Vertex v2) {
        this.id = id;
        this.endpoint1 = v1;
        this.endpoint2 = v2;
    }

    public String getEndpointsString() {
        if (endpoint1 == endpoint2) {
            return String.format("{%s}", endpoint1.getId());
        } else {
            return String.format("{%s, %s}", endpoint1.getId(), endpoint2.getId());
        }
    }

    public String getId() {
        return id;
    }
}
class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void printEdgeEndpointFunction() {
        System.out.println("-------------------------");
        System.out.println(" Edge  |  Endpoints");
        System.out.println("-------------------------");
        
        for (Edge e : edges) {
            System.out.printf("  %-4s |  %s\n", e.getId(), e.getEndpointsString());
        }
        System.out.println("-------------------------");
        
        System.out.print("Vertex Set: { ");
        for (Vertex v : vertices) {
            System.out.print(v.getId() + " ");
        }
        System.out.println("}");
    }
}
class test {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        graph.addVertex(v1); graph.addVertex(v2); graph.addVertex(v3);
        graph.addVertex(v4); graph.addVertex(v5); graph.addVertex(v6);

        graph.addEdge(new Edge("e1", v1, v2));
        
        graph.addEdge(new Edge("e2", v1, v3));
        
        graph.addEdge(new Edge("e3", v1, v3));
        
        graph.addEdge(new Edge("e4", v2, v3));
        
        graph.addEdge(new Edge("e5", v5, v6));

        graph.addEdge(new Edge("e6", v5, v5));
        
        graph.addEdge(new Edge("e7", v6, v6));

        System.out.println("Example 1(a) - Solution Output:");
        graph.printEdgeEndpointFunction();
    }
}