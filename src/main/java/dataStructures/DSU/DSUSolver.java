package dataStructures.DSU;

/**
 * Created by Dawid Pawlak.
 */

public class DSUSolver {

    private int rank[];

    private int parent[];

    public DSUSolver(int n) {
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int find(int v) {
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) return;
        if(rank[fa] < rank[fb]) {
            parent[fa] = fb;
        } else  {
            parent[fb] = fa;
        }
        if(rank[fa] == rank[fb]) {
            rank[fa]++;
        }
    }

}
