package problems.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 3/5/19.
 */
public class ShortestPathAllNodes {


    class Edge{

        int node;
        int cost;
        int bitmap;

        public Edge(int bit,int n, int c){
            this.node  = n;
            this.cost = c;
            this.bitmap = bit;
        }

        public boolean equals(Object o){
            Edge e = (Edge) o;
            return (this.bitmap==e.bitmap && this.cost == e.cost && this.node == e.node);
        }

        public int hashCode(){
            return 1331 * bitmap + 7193 * node + 727 * cost;
        }

    }


    public int shortestPathLength(int[][] graph) {
        int NODES = graph.length;
        HashSet<Edge> storage = new HashSet<>();
        Queue<Edge> q = new LinkedList<>();

        for(int i=0; i<NODES; i++){
            int b = (1 << i);
            q.offer(new Edge(b, i, 1));
            storage.add(new Edge(b, i, 0));
        }

        while(!q.isEmpty()){
            Edge e = q.remove();

            if (e.bitmap == (1 << NODES)-1) return e.cost-1;
            else{
                int[] neighbors = graph[e.node];


                for (int c : neighbors){
                    int b = e.bitmap;
                    b = b | (1 << c);
                    Edge tmp = new Edge(b, c, 0);

                    if (!storage.contains(tmp)) {
                        Edge n1 = new Edge(b, c, e.cost+1);
                        storage.add(tmp);
                        q.offer(n1);
                    }
                }
            }
        }
        return -1;
    }
}
