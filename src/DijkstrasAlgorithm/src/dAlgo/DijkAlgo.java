package dAlgo;

public class DijkAlgo {

  static void printVertices(int[][] adjMat) {
    System.out.println("Vertices:");
    for (int i = 0; i < adjMat.length; i++) {
      System.out.println("Vertex " + (i + 1) + ": " + i);
    }
  }
  
  private static void printEdges(int[][] adjMat) {
    int k = 1;
    for (int i = 0; i < adjMat.length; i++) {
      for (int j = 0; j < adjMat[i].length; j++) {
        if(adjMat[i][j] != 0) {
          System.out.println("Edge " + k + ": " + (i + 1) + " to " + (j + 1));
          k++;
        }
      }
    }
  }
  
  static int findMinimumPath(int[] distance, boolean[] visited) {

    int minVertex = -1;

    for (int i = 0; i < distance.length; i++) {
      if (visited[i] == false && (minVertex == -1 || distance[i] < distance[minVertex])) {
        minVertex = i;
      }
    }
    return minVertex;
  }

  public static void main(String[] args) {
    int adjMat[][] = { 
        {  0,  9,  0,  0,  0,  14,  15,  0,  0,  0 },
        {  0,  0, 24,  0,  0,   0,   0,  0,  0,  0 },
        {  0,  0,  0,  0,  0,   0,   0, 19,  0,  0 },
        {  0,  0,  6,  0,  0,   0,   0,  6, 99, 99 },
        {  0,  0,  0, 11,  0,   0,   0, 16,  0,  0 },
        {  0,  0, 18,  0, 30,   0,   5,  0,  0,  0 },
        {  0,  0,  0,  0, 20,   0,   0, 44,  0,  0 },
        {  0,  0,  0,  0,  0,   0,   0,  0, 67,  0 },
        {  0,  0,  0,  0,  0,   0,   0,  0,  0, 99 },
        {  0,  0,  0,  0,  0,   0,   0,  0,  0,  0 }
    };
    
    printVertices(adjMat);
    
    printEdges(adjMat);

    int[] distance = new int[adjMat.length];

    int start = 0;

    boolean[] visited = new boolean[adjMat.length];

    distance[start] = 0;

    for (int i = 0; i < adjMat.length; i++) {
      if (i == start)
        continue;
      distance[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < adjMat.length; i++) {
      int minimumPath = findMinimumPath(distance, visited);

      visited[minimumPath] = true;

      for (int j = 0; j < adjMat.length; j++) {
        if (adjMat[minimumPath][j] != 0 && visited[j] == false && distance[minimumPath] != Integer.MAX_VALUE) {
          int updatedDistance = distance[minimumPath] + adjMat[minimumPath][j];
          if (updatedDistance < distance[j]) {
            distance[j] = updatedDistance;
          }
        }
      }
    }

    for (int i = 0; i < adjMat.length; i++) {
      System.out.println("Vertex " + (i + 1) + " distance from start: " + distance[i]);
      if (i == adjMat.length - 1) {
        System.out.println("Vertex " + (i + 1) 
          + " is the final vertex with a total distance of " + distance[i]);
      }
    }
  }

}