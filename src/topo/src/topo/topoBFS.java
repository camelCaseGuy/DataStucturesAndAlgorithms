package topo;

import java.util.*;

class topoBFS {
  public boolean isLoop(int n, ArrayList<ArrayList<Integer>> adj) {
    int degree[] = new int[n];
    int topo[] = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j : adj.get(i)) {
        degree[j]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
      if (degree[i] == 0) {
        q.add(i);
      }
    }
    int index = 0;
    int count = 0;
    while (!q.isEmpty()) {
      int node = q.remove();
      topo[index++] = node;
      count++;
      for (int i = 0; i < adj.get(node).size(); i++) {
        degree[i]--;
        if (degree[i] == 0) {
          q.add(i);
        }
      }
    }
    for (int i = 0; i < topo.length; i++) {
      System.out.print(topo[i] + " ");
    }
    
    if (count == n)
      return false;
    return true;
  }

  // there has to be an easier way to do key-value pairs like javascript
  public static int find(char[] array, char value) {
    for (int i = 0; i < array.length; i++)
      if (array[i] == value)
        return i;
    return -1;
  }

  public static void main(String args[]) {

    System.out.println("Graph 1");
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    char[] verts = {
      '1', '2', '3', '4', '5', '6', '7', '8'
    };
    
    for (int i = 0; i < verts.length; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(find(verts, '1')).add(find(verts, '2'));
    adj.get(find(verts, '1')).add(find(verts, '5'));
    adj.get(find(verts, '1')).add(find(verts, '6'));
    adj.get(find(verts, '2')).add(find(verts, '3'));
    adj.get(find(verts, '2')).add(find(verts, '5'));
    adj.get(find(verts, '2')).add(find(verts, '7'));
    adj.get(find(verts, '3')).add(find(verts, '4'));
    adj.get(find(verts, '4')).add(find(verts, '5'));
    adj.get(find(verts, '5')).add(find(verts, '7'));
    adj.get(find(verts, '5')).add(find(verts, '8'));
    adj.get(find(verts, '6')).add(find(verts, '5'));
    adj.get(find(verts, '6')).add(find(verts, '8'));
    adj.get(find(verts, '7')).add(find(verts, '4'));
    adj.get(find(verts, '7')).add(find(verts, '8'));
    
    System.out.println("For values:");
    for (int i = 0; i < verts.length; i++) {
      System.out.print(verts[i] + " ");
    }
    System.out.println();
    System.out.println("\nIs it cyclic? \n" + new topoBFS().isLoop(verts.length, adj));

    System.out.println();
    System.out.println("Graph 2");
    ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

    char[] verts2 = {
      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    
    for (int i = 0; i < verts2.length; i++) {
      adj2.add(new ArrayList<>());
    }

    adj2.get(find(verts2, 'm')).add(find(verts2, 'r'));
    adj2.get(find(verts2, 'm')).add(find(verts2, 'q'));
    adj2.get(find(verts2, 'm')).add(find(verts2, 't'));
    adj2.get(find(verts2, 'n')).add(find(verts2, 'o'));
    adj2.get(find(verts2, 'n')).add(find(verts2, 'q'));
    adj2.get(find(verts2, 'n')).add(find(verts2, 'u'));
    adj2.get(find(verts2, 'o')).add(find(verts2, 'r'));
    adj2.get(find(verts2, 'o')).add(find(verts2, 's'));
    adj2.get(find(verts2, 'o')).add(find(verts2, 'v'));
    adj2.get(find(verts2, 'p')).add(find(verts2, 'o'));
    adj2.get(find(verts2, 'p')).add(find(verts2, 's'));
    adj2.get(find(verts2, 'p')).add(find(verts2, 'z'));
    adj2.get(find(verts2, 'q')).add(find(verts2, 't'));
    adj2.get(find(verts2, 'r')).add(find(verts2, 'u'));
    adj2.get(find(verts2, 'r')).add(find(verts2, 'y'));
    adj2.get(find(verts2, 's')).add(find(verts2, 'r'));
    adj2.get(find(verts2, 'u')).add(find(verts2, 't'));
    adj2.get(find(verts2, 'v')).add(find(verts2, 'w'));
    adj2.get(find(verts2, 'v')).add(find(verts2, 'x'));
    adj2.get(find(verts2, 'w')).add(find(verts2, 'z'));
    adj2.get(find(verts2, 'y')).add(find(verts2, 'v'));
    
    System.out.println("For values:");
    for (int i = 0; i < verts2.length; i++) {
      System.out.print(verts2[i] + " ");
    }
    System.out.println();
    System.out.println("\nIs there a loop? \n" + new topoBFS().isLoop(verts2.length, adj2));

  }
}