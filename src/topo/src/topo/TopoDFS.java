package topo;

import java.util.ArrayList;

public class TopoDFS {

  public TopoDFS() {
  }

  class Vertex {
    char label;
    boolean isExplored;
    boolean isVisited;
    int topoNumber;

    public Vertex(char l) {
      this.label = l;
    }
  }

  class Edge {
    Vertex v, w;

    public Edge(Vertex v, Vertex w) {
      this.v = v;
      this.w = w;
    }
  }

  class Graph {
    Vertex[] vertices;
    int vIndex = 0;
    Edge[] edges;
    int eIndex = 0;
    Vertex[][] adjMat;
    int n;

    public Graph(int numV, int numE) {
      vertices = new Vertex[numV];
      edges = new Edge[numE];
      adjMat = new Vertex[numV][numV];
    }

    Vertex insertVertex(char l) {
      Vertex v = new Vertex(l);
      vertices[vIndex] = v;
      vIndex++;
      return v;
    }

    void insertEdge(Vertex v, Vertex w) {
      Edge e = new Edge(v, w);
      edges[eIndex] = e;
      eIndex++;

    }

//  Couldn't find a way to get element by property val. Next time ArrayList
//    Vertex getByLabel(char x) {
//      Vertex v = Arrays.stream(vertices).filter(el => {
//        el.label == x;
//      });
//          return v;
//    }

    int getNumVertices() {
      return vIndex;
    }

    Edge[] outEdges(Vertex v) {
      ArrayList<Edge> outEdges = new ArrayList<>();
      for (int i = 0; i < edges.length; i++) {
        if (edges[i].v == v) {
          outEdges.add(edges[i]);
        }
      }
      Edge[] outArr = new Edge[outEdges.size()];
      for (int i = 0; i < outEdges.size(); i++) {
        outArr[i] = outEdges.get(i);
      }
      return outArr;
    }

    Vertex opposite(Edge e) {
      return e.w;
    }

    void topologicalDFS(Graph G, Vertex v) {
      v.isExplored = true;
      Edge[] outEdges = G.outEdges(v);
      for (int i = 0; i < outEdges.length; i++) {
        Vertex w = G.opposite(outEdges[i]);
        if (w.isExplored == false) {
//          System.out.println("sending " + w.label);
          topologicalDFS(G, w);
        } else {
          System.out.println("Topo # " + G.n + " for " + v.label + " is set.");
          v.topoNumber = G.n;
          G.n--;
        }
      }
    }
  }

  public static void main(String[] args) {
    TopoDFS dfs = new TopoDFS();
    System.out.println("GRAPH G");
    Graph G = dfs.new Graph(8, 13);
    Vertex v1 = G.insertVertex('1');
    Vertex v2 = G.insertVertex('2');
    Vertex v3 = G.insertVertex('3');
    Vertex v4 = G.insertVertex('4');
    Vertex v5 = G.insertVertex('5');
    Vertex v6 = G.insertVertex('6');
    Vertex v7 = G.insertVertex('7');
    Vertex v8 = G.insertVertex('8');
//    System.out.println(G.vertices[0].label);
    G.insertEdge(v1, v2);
    G.insertEdge(v1, v5);
    G.insertEdge(v1, v6);
    G.insertEdge(v2, v3);
    G.insertEdge(v2, v5);
    G.insertEdge(v2, v7);
    G.insertEdge(v3, v4);
    G.insertEdge(v4, v5);
    G.insertEdge(v5, v7);
    G.insertEdge(v5, v8);
    G.insertEdge(v6, v5);
    G.insertEdge(v6, v8);
    G.insertEdge(v7, v8);

    G.n = G.getNumVertices();

    // already set to false
    for (int i = 0; i < G.vertices.length; i++) {
      if (G.vertices[i].isExplored == false) {
//        System.out.println("first sending " + G.vertices[i].label);
        G.topologicalDFS(G, G.vertices[i]);
      }
    }
    if(G.n > 1) {
      System.out.println("Loop found after topo # " + (G.n + 1));
    }
    
    System.out.println("GRAPH H");
    System.out.println();
    
    Graph H = dfs.new Graph(14,20);
    Vertex v101 = H.insertVertex('m');
    Vertex v102 = H.insertVertex('n');
    Vertex v103 = H.insertVertex('o');
    Vertex v104 = H.insertVertex('p');
    Vertex v105 = H.insertVertex('q');
    Vertex v106 = H.insertVertex('r');
    Vertex v107 = H.insertVertex('s');
    Vertex v108 = H.insertVertex('t');
    Vertex v109 = H.insertVertex('u');
    Vertex v110 = H.insertVertex('v');
    Vertex v111 = H.insertVertex('w');
    Vertex v112 = H.insertVertex('x');
    Vertex v113 = H.insertVertex('y');
    Vertex v114 = H.insertVertex('z');
    H.insertEdge(v101, v106);
    H.insertEdge(v101, v105);
    H.insertEdge(v101, v112);
    H.insertEdge(v102, v105);
    H.insertEdge(v102, v109);
    H.insertEdge(v103, v106);
    H.insertEdge(v103, v107);
    H.insertEdge(v103, v110);
    H.insertEdge(v104, v103);
    H.insertEdge(v104, v107);
    H.insertEdge(v104, v114);
    H.insertEdge(v105, v108);
    H.insertEdge(v106, v109);
    H.insertEdge(v106, v113);
    H.insertEdge(v107, v106);
    H.insertEdge(v109, v110);
    H.insertEdge(v110, v112);
    H.insertEdge(v110, v111);
    H.insertEdge(v111, v114);
    H.insertEdge(v113, v110);
    
    H.n = H.getNumVertices();

    // already set to false
    for (int i = 0; i < H.vertices.length; i++) {
      if (H.vertices[i].isExplored == false) {
//        System.out.println("first sending " + G.vertices[i].label);
        H.topologicalDFS(H, H.vertices[i]);
      }
    }
    
    if(H.n > 1) {
      System.out.println("Loop found after topo # " + (H.n + 1));
    }
  }

}
